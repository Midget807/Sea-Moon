package net.midget807.seamoon;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.midget807.seamoon.block.ModBlocks;
import net.midget807.seamoon.entity.ModEntityTypes;
import net.midget807.seamoon.network.ModMessages;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.entity.mob.FlyingEntity;

public class SeaMoonClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SEAMOON_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SEAMOON_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SEAMOON_SPLATTER, RenderLayer.getCutout());
        EntityRendererRegistry.register(ModEntityTypes.SPLASH_SEAMOON_BOTTLE_ENTITY_TYPE, FlyingItemEntityRenderer::new);
        ModMessages.registerS2CPackets();
    }
}
