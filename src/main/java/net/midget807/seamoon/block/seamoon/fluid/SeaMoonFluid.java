package net.midget807.seamoon.block.seamoon.fluid;

import net.midget807.seamoon.block.ModBlocks;
import net.midget807.seamoon.block.seamoon.ModFluids;
import net.midget807.seamoon.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;

public abstract class SeaMoonFluid extends AbstractSeaMoonFluid{
    @Override
    public Fluid getStill() {
        return ModFluids.SEAMOON_FLUID;
    }

    @Override
    public Fluid getFlowing() {
        return ModFluids.FLOWING_SEAMOON_FLUID;
    }

    @Override
    public Item getBucketItem() {
        return ModItems.SEAMOON_BUCKET;
    }

    @Override
    protected BlockState toBlockState(FluidState state) {
        return ModBlocks.SEAMOON.getDefaultState().with(Properties.LEVEL_15, getBlockStateLevel(state));
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
