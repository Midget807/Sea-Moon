package net.midget807.seamoon.block.seamoon.fluid;

import net.midget807.seamoon.block.ModBlocks;
import net.midget807.seamoon.block.seamoon.ModFluids;
import net.midget807.seamoon.datagen.ModFluidTagProvider;
import net.midget807.seamoon.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FluidBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public abstract class AbstractSeaMoonFluid extends FlowableFluid {
    @Override
    public Fluid getFlowing() {
        return getStill();
    }

    @Override
    public Fluid getStill() {
        return getFlowing();
    }

    @Override
    protected boolean isInfinite(World world) {
        return false;
    }

    @Override
    protected void beforeBreakingBlock(WorldAccess world, BlockPos pos, BlockState state) {
        final BlockEntity blockEntity = state.hasBlockEntity() ? world.getBlockEntity(pos) : null;
        Block.dropStacks(state, world, pos, blockEntity);
    }

    @Override
    public boolean matchesType(Fluid fluid) {
        return fluid == getStill() || fluid == getFlowing();
    }

    @Override
    protected int getFlowSpeed(WorldView world) {
        return 2; //Same as lava in the Overworld
    }

    @Override
    protected int getLevelDecreasePerBlock(WorldView world) {
        return 2; //Same as lava in the Overworld
    }

    @Override
    protected boolean canBeReplacedWith(FluidState state, BlockView world, BlockPos pos, Fluid fluid, Direction direction) {
        return false;
    }

    //Water returns 5. Lava returns 30 in the Overworld and 10 in the Nether.
    @Override
    public int getTickRate(WorldView world) {
        return 20;
    }

    @Override
    protected float getBlastResistance() {
        return 100.0f;
    }
}
