package net.midget807.seamoon;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.midget807.seamoon.block.ModBlocks;
import net.midget807.seamoon.block.seamoon.ModFluids;
import net.midget807.seamoon.entity.ModEntityTypes;
import net.midget807.seamoon.network.ModMessages;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.entity.mob.FlyingEntity;
import net.minecraft.util.Identifier;

public class SeaMoonClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SEAMOON_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SEAMOON_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SEAMOON_SPLATTER, RenderLayer.getCutout());
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.SEAMOON_FLUID, ModFluids.FLOWING_SEAMOON_FLUID, new SimpleFluidRenderHandler(
                SeaMoonMain.id("block/seamoon_still"),
                SeaMoonMain.id("block/seamoon_flow"),
                0xf2eded
        ));
        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluids.SEAMOON_FLUID, ModFluids.FLOWING_SEAMOON_FLUID);
        /*
        Custom Fluid texture
        Translate ClientSpriteRegistryCallback to 1.20.2

        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
		    registry.register(new Identifier("tutorial:block/custom_fluid_still"));
		    registry.register(new Identifier("tutorial:block/custom_fluid_flowing"));
		});
        */


        EntityRendererRegistry.register(ModEntityTypes.SPLASH_SEAMOON_BOTTLE_ENTITY_TYPE, FlyingItemEntityRenderer::new);
        ModMessages.registerS2CPackets();
    }
}
