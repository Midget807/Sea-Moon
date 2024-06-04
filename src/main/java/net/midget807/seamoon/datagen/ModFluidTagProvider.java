package net.midget807.seamoon.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.midget807.seamoon.SeaMoonMain;
import net.midget807.seamoon.block.seamoon.ModFluids;
import net.minecraft.fluid.Fluid;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;

import java.util.concurrent.CompletableFuture;

public class ModFluidTagProvider extends FabricTagProvider.FluidTagProvider {

    public static final TagKey<Fluid> SEAMOON = of("seamoon");
    public ModFluidTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(SEAMOON)
                .add(ModFluids.SEAMOON_FLUID)
                .add(ModFluids.FLOWING_SEAMOON_FLUID);

    }
    private static TagKey<Fluid> of(String name) {
        return TagKey.of(RegistryKeys.FLUID, SeaMoonMain.id(name));
    }
}
