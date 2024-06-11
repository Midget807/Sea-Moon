package net.midget807.seamoon.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.midget807.seamoon.block.ModBlocks;
import net.midget807.seamoon.item.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.PotionUtil;
import net.minecraft.potion.Potions;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool seamoonPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SEAMOON_BLOCK);
        seamoonPool.stairs(ModBlocks.SEAMOON_STAIR);
        seamoonPool.slab(ModBlocks.SEAMOON_SLAB);
        seamoonPool.fence(ModBlocks.SEAMOON_FENCE);
        seamoonPool.fenceGate(ModBlocks.SEAMOON_FENCE_GATE);
        seamoonPool.wall(ModBlocks.SEAMOON_WALL);
        seamoonPool.button(ModBlocks.SEAMOON_BUTTON);
        seamoonPool.pressurePlate(ModBlocks.SEAMOON_PRESSURE_PLATE);
        blockStateModelGenerator.registerDoor(ModBlocks.SEAMOON_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.SEAMOON_TRAPDOOR);
        blockStateModelGenerator.registerWallPlant(ModBlocks.SEAMOON_SPLATTER);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.SEAMOON_BOTTLE, Items.HONEY_BOTTLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SEAMOON_BUCKET, Items.MILK_BUCKET, Models.GENERATED);

        itemModelGenerator.register(ModItems.GLAZED_APPLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.GLAZED_BAKED_POTATO, Models.GENERATED);
        itemModelGenerator.register(ModItems.GLAZED_BEEF, Models.GENERATED);
        itemModelGenerator.register(ModItems.GLAZED_BEETROOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.GLAZED_BEETROOT_SOUP, Models.GENERATED);
        itemModelGenerator.register(ModItems.GLAZED_BREAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.GLAZED_CARROT, Models.GENERATED);
        itemModelGenerator.register(ModItems.GLAZED_CHICKEN, Models.GENERATED);
        itemModelGenerator.register(ModItems.GLAZED_CHORUS_FRUIT, Models.GENERATED);
        itemModelGenerator.register(ModItems.GLAZED_COD, Models.GENERATED);
        itemModelGenerator.register(ModItems.GLAZED_COOKED_BEEF, Models.GENERATED);
        itemModelGenerator.register(ModItems.GLAZED_COOKED_CHICKEN, Models.GENERATED);
        itemModelGenerator.register(ModItems.GLAZED_COOKED_COD, Models.GENERATED);
        itemModelGenerator.register(ModItems.GLAZED_COOKED_MUTTON, Models.GENERATED);
        itemModelGenerator.register(ModItems.GLAZED_COOKED_PORKCHOP, Models.GENERATED);
        itemModelGenerator.register(ModItems.GLAZED_COOKED_RABBIT, Models.GENERATED);
        itemModelGenerator.register(ModItems.GLAZED_COOKED_SALMON, Models.GENERATED);
        itemModelGenerator.register(ModItems.GLAZED_COOKIE, Models.GENERATED);
        itemModelGenerator.register(ModItems.GLAZED_DRIED_KELP, Models.GENERATED);
        itemModelGenerator.register(ModItems.GLAZED_ENCHANTED_GOLDEN_APPLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.GLAZED_GOLDEN_APPLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.GLAZED_GOLDEN_CARROT, Models.GENERATED);
        itemModelGenerator.register(ModItems.GLAZED_HONEY_BOTTLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.GLAZED_MELON_SLICE, Models.GENERATED);
        itemModelGenerator.register(ModItems.GLAZED_MUSHROOM_STEW, Models.GENERATED);
        itemModelGenerator.register(ModItems.GLAZED_MUTTON, Models.GENERATED);
        itemModelGenerator.register(ModItems.GLAZED_POISONOUS_POTATO, Models.GENERATED);
        itemModelGenerator.register(ModItems.GLAZED_PORKCHOP, Models.GENERATED);
        itemModelGenerator.register(ModItems.GLAZED_POTATO, Models.GENERATED);
        itemModelGenerator.register(ModItems.GLAZED_PUFFERFISH, Models.GENERATED);
        itemModelGenerator.register(ModItems.GLAZED_PUMPKIN_PIE, Models.GENERATED);
        itemModelGenerator.register(ModItems.GLAZED_RABBIT, Models.GENERATED);
        itemModelGenerator.register(ModItems.GLAZED_RABBIT_STEW, Models.GENERATED);
        itemModelGenerator.register(ModItems.GLAZED_ROTTEN_FLESH, Models.GENERATED);
        itemModelGenerator.register(ModItems.GLAZED_SALMON, Models.GENERATED);
        itemModelGenerator.register(ModItems.GLAZED_SPIDER_EYE, Models.GENERATED);
        itemModelGenerator.register(ModItems.GLAZED_SUSPICIOUS_STEW, Models.GENERATED);
        itemModelGenerator.register(ModItems.GLAZED_SWEET_BERRIES, Models.GENERATED);
        itemModelGenerator.register(ModItems.GLAZED_GLOW_BERRIES, Models.GENERATED);
        itemModelGenerator.register(ModItems.GLAZED_TROPICAL_FISH, Models.GENERATED);
        itemModelGenerator.register(ModItems.STICKY_BICKY, Models.GENERATED);
        itemModelGenerator.register(ModItems.SOGGY_SEAWEED, Models.GENERATED);
    }
}
