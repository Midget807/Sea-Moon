package net.midget807.seamoon.block.seamoon.fluid;

import net.midget807.seamoon.block.ModBlocks;
import net.midget807.seamoon.block.seamoon.ModFluids;
import net.midget807.seamoon.datagen.ModFluidTagProvider;
import net.midget807.seamoon.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.LavaFluid;
import net.minecraft.item.Item;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public abstract class SeaMoonFluid extends FlowableFluid {
    @Override
    public Fluid getFlowing() {
        return ModFluids.FLOWING_SEAMOON_FLUID;
    }

    @Override
    public Fluid getStill() {
        return ModFluids.SEAMOON_FLUID;
    }

    @Override
    protected boolean isInfinite(World world) {
        return false;
    }

    @Override
    protected void beforeBreakingBlock(WorldAccess world, BlockPos pos, BlockState state) {
        BlockEntity blockEntity = state.hasBlockEntity() ? world.getBlockEntity(pos) : null;
        Block.dropStacks(state, world, pos, blockEntity);
    }

    @Override
    protected int getFlowSpeed(WorldView world) {
        return 2;
    }

    @Override
    protected int getLevelDecreasePerBlock(WorldView world) {
        return 2;
    }

    @Override
    public Item getBucketItem() {
        return ModItems.SEAMOON_BUCKET;
    }

    @Override
    protected boolean canBeReplacedWith(FluidState state, BlockView world, BlockPos pos, Fluid fluid, Direction direction) {
        return direction == Direction.DOWN && !fluid.isIn(ModFluidTagProvider.SEAMOON);
    }

    @Override
    public int getTickRate(WorldView world) {
        return 20;
    }

    @Override
    protected float getBlastResistance() {
        return 100.0f;
    }

    @Override
    protected BlockState toBlockState(FluidState state) {
        return (BlockState) ModBlocks.SEAMOON.getDefaultState().with(FluidBlock.LEVEL, getBlockStateLevel(state));
    }

    @Override
    public boolean isStill(FluidState state) {
        return false;
    }

    @Override
    public int getLevel(FluidState state) {
        return 8;
    }

    @Override
    protected void flow(WorldAccess world, BlockPos pos, BlockState state, Direction direction, FluidState fluidState) {
        if (direction == Direction.DOWN) {
            FluidState fluidState2 = world.getFluidState(pos);
            if (this.isIn(ModFluidTagProvider.SEAMOON) && fluidState2.isIn(FluidTags.WATER)) {
                if (state.getBlock() instanceof FluidBlock) {
                    world.setBlockState(pos, ModBlocks.SEAMOON.getDefaultState(), Block.NOTIFY_ALL);
                }
                return;
            }
        }
        super.flow(world, pos, state, direction, fluidState);
    }
    public static class Flowing extends SeaMoonFluid {
        @Override
        protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
            super.appendProperties(builder);
            builder.add(LEVEL);
        }
        @Override
        public int getLevel(FluidState state) {
            return state.get(LEVEL);
        }

        @Override
        public boolean isStill(FluidState state) {
            return false;
        }

    }
    public static class Still extends SeaMoonFluid {
        @Override
        public int getLevel(FluidState state) {
            return 8;
        }

        @Override
        public boolean isStill(FluidState state) {
            return true;
        }

    }
}
