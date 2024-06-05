package net.midget807.seamoon.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.midget807.seamoon.block.ModBlocks;
import net.midget807.seamoon.item.ModItems;
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
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.SEAMOON_BOTTLE, Items.HONEY_BOTTLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SEAMOON_BUCKET, Items.MILK_BUCKET, Models.GENERATED);
    }
}
