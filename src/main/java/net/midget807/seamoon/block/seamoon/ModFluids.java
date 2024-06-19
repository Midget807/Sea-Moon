package net.midget807.seamoon.block.seamoon;

import net.midget807.seamoon.SeaMoonMain;
import net.midget807.seamoon.block.seamoon.fluid.AbstractSeaMoonFluid;
import net.midget807.seamoon.block.seamoon.fluid.SeaMoonFluid;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModFluids {
    public static final FlowableFluid SEAMOON_FLUID = registerFluid("seamoon_fluid", new SeaMoonFluid.Still());
    public static final FlowableFluid FLOWING_SEAMOON_FLUID = registerFluid("flowing_seamoon_fluid", new SeaMoonFluid.Flowing());

    private static <T extends Fluid> T registerFluid(String name, T value) {
        return (T) Registry.register(Registries.FLUID, SeaMoonMain.id(name), value);
    }
    static {
        for (Fluid fluid : Registries.FLUID) {
            for (FluidState fluidState : fluid.getStateManager().getStates()) {
                Fluid.STATE_IDS.add(fluidState);
            }
        }
    }
}
