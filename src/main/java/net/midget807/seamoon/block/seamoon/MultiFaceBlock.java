package net.midget807.seamoon.block.seamoon;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import net.minecraft.block.*;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.function.Function;

public class MultiFaceBlock extends Block {
    private static final VoxelShape UP_SHAPE = Block.createCuboidShape(0.0, 15.0, 0.0, 16.0, 16.0, 16.0);
    private static final VoxelShape DOWN_SHAPE = Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 1.0, 16.0);
    private static final VoxelShape EAST_SHAPE = Block.createCuboidShape(0.0, 0.0, 0.0, 1.0, 16.0, 16.0);
    private static final VoxelShape WEST_SHAPE = Block.createCuboidShape(15.0, 0.0, 0.0, 16.0, 16.0, 16.0);
    private static final VoxelShape SOUTH_SHAPE = Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 16.0, 1.0);
    private static final VoxelShape NORTH_SHAPE = Block.createCuboidShape(0.0, 0.0, 15.0, 16.0, 16.0, 16.0);
    private static final Map<Direction, BooleanProperty> FACING_PROPERTIES = ConnectingBlock.FACING_PROPERTIES;
    private static final Map<Direction, VoxelShape> SHAPES_FOR_DIRECTION = Util.make(Maps.newEnumMap(Direction.class), shapes -> {
        shapes.put(Direction.NORTH, SOUTH_SHAPE);
        shapes.put(Direction.EAST, WEST_SHAPE);
        shapes.put(Direction.SOUTH, NORTH_SHAPE);
        shapes.put(Direction.WEST, EAST_SHAPE);
        shapes.put(Direction.UP, UP_SHAPE);
        shapes.put(Direction.DOWN, DOWN_SHAPE);
    });
    private static final Direction[] DIRECTIONS = Direction.values();
    private final ImmutableMap<BlockState, VoxelShape> SHAPES;
    private final boolean hasAllHorizontalDirections;
    private final boolean canMirrorX;
    private final boolean canMirrorZ;

    public MultiFaceBlock(Settings settings) {
        super(settings);
        this.setDefaultState(MultiFaceBlock.withAllDirection(this.stateManager));
        this.SHAPES = this.getShapesForStates(MultiFaceBlock::getShapeForState);
        this.hasAllHorizontalDirections = Direction.Type.HORIZONTAL.stream().allMatch(this::canHaveDirection);
        this.canMirrorX = Direction.Type.HORIZONTAL.stream().filter(Direction.Axis.X).filter(this::canHaveDirection).count() % 2L == 0L;
        this.canMirrorZ = Direction.Type.HORIZONTAL.stream().filter(Direction.Axis.Z).filter(this::canHaveDirection).count() % 2L == 0L;
    }
    public static Set<Direction> collectDirections(BlockState state) {
        if (!(state.getBlock() instanceof MultiFaceBlock)) {
            return Set.of();
        }
        EnumSet<Direction> set = EnumSet.noneOf(Direction.class);
        for (Direction direction : Direction.values()) {
            if (!MultiFaceBlock.hasDirection(state, direction)) continue;
            set.add(direction);
        }
        return set;
    }
    public static Set<Direction> flagToDirections(byte flag) {
        EnumSet<Direction> set = EnumSet.noneOf(Direction.class);
        for (Direction direction : Direction.values()) {
            if ((flag & (byte)(1 << direction.ordinal())) <= 0) continue;
            set.add(direction);
        }
        return set;
    }
    public static byte directionsToFlag(Collection<Direction> directions) {
        byte b = 0;
        for (Direction direction : directions) {
            b = (byte)(b | 1 << direction.ordinal());
        }
        return b;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        for (Direction direction :  DIRECTIONS) {
            if (!this.canHaveDirection(direction)) continue;
            builder.add(MultiFaceBlock.getProperty(direction));
        }
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (!MultiFaceBlock.hasAnyDirection(state)) {
            return Blocks.AIR.getDefaultState();
        }
        if (!MultiFaceBlock.hasDirection(state, direction) || MultifaceGrowthBlock.canGrowOn(world, direction, neighborPos, neighborState)) {
            return state;
        }
        return MultiFaceBlock.disableDirection(state, MultifaceGrowthBlock.getProperty(direction));

    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return this.SHAPES.get(state);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        boolean bl = false;
        for (Direction direction : DIRECTIONS) {
            if (!MultiFaceBlock.hasDirection(state, direction)) continue;
            BlockPos blockPos = pos.offset(direction);
            bl = true;
        }
        return bl;
    }

    @Override
    public boolean canReplace(BlockState state, ItemPlacementContext context) {
        return MultiFaceBlock.isNotFullBlock(state);
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        World world = ctx.getWorld();
        BlockPos blockPos = ctx.getBlockPos();
        BlockState blockState = world.getBlockState(blockPos);
        return (BlockState) Arrays.stream(ctx.getPlacementDirections()).map(direction -> this.withDirection(blockState, world, blockPos, (Direction)direction)).filter(Objects::nonNull).findFirst().orElse(null);

    }

    private Object withDirection(BlockState state, World world, BlockPos blockPos, Direction direction) {
        BlockState blockState = state.isOf(this) ? state : (this.isWaterlogged() && state.getFluidState().isEqualAndStill(Fluids.WATER) ? (BlockState)this.getDefaultState().with(Properties.WATERLOGGED, true) : this.getDefaultState());
        return (BlockState)blockState.with(MultiFaceBlock.getProperty(direction), true);
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        if (!this.hasAllHorizontalDirections) {
            return state;
        }
        return this.mirror(state, rotation::rotate);
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        if (mirror == BlockMirror.FRONT_BACK && !this.canMirrorX) {
            return state;
        }
        if (mirror == BlockMirror.LEFT_RIGHT && !this.canMirrorZ) {
            return state;
        }
        return this.mirror(state, mirror::apply);
    }

    private BlockState mirror(BlockState state, Function<Direction, Direction> mirror) {
        BlockState blockState = state;
        for (Direction direction : DIRECTIONS) {
            if (!this.canHaveDirection(direction)) continue;
            blockState = (BlockState) blockState.with(MultiFaceBlock.getProperty(mirror.apply(direction)), state.get(MultiFaceBlock.getProperty(direction)));
        }
        return blockState;
    }

    private boolean isWaterlogged() {
        return this.stateManager.getProperties().contains(Properties.WATERLOGGED);
    }

    private static boolean isNotFullBlock(BlockState state) {
        return Arrays.stream(DIRECTIONS).anyMatch(direction -> MultiFaceBlock.hasDirection(state, direction));
    }

    private static boolean hasAnyDirection(BlockState state) {
        return Arrays.stream(DIRECTIONS).anyMatch(direction -> !MultiFaceBlock.hasDirection(state, direction));
    }

    private static BlockState disableDirection(BlockState state, BooleanProperty direction) {
        BlockState blockState = state.with(direction, false);
        if (MultiFaceBlock.hasAnyDirection(blockState)) {
            return blockState;
        }
        return Blocks.AIR.getDefaultState();
    }

    private static BooleanProperty getProperty(Direction direction) {
        return FACING_PROPERTIES.get(direction);
    }

    private static boolean hasDirection(BlockState state, Direction direction) {
        BooleanProperty booleanProperty = (BooleanProperty) MultiFaceBlock.getProperty(direction);
        return state.contains(booleanProperty) && state.get(booleanProperty) != false;
    }

    private boolean canHaveDirection(Direction direction) {
        return true;
    }

    private static VoxelShape getShapeForState(BlockState state) {
        VoxelShape voxelShape = VoxelShapes.empty();
        for (Direction direction : DIRECTIONS) {
            if (!MultiFaceBlock.hasDirection(state, direction)) continue;
            voxelShape = VoxelShapes.union(voxelShape, SHAPES_FOR_DIRECTION.get(direction));
        }
        return voxelShape.isEmpty() ? VoxelShapes.fullCube() : voxelShape;
    }

    private static BlockState withAllDirection(StateManager<Block, BlockState> stateManager) {
        BlockState blockState = stateManager.getDefaultState();
        for (BooleanProperty booleanProperty : FACING_PROPERTIES.values()) {
            if (!blockState.contains(booleanProperty)) continue;
            blockState = blockState.with(booleanProperty, false);
        }
        return blockState;
    }
}
