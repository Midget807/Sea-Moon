package net.midget807.seamoon.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.midget807.seamoon.SeaMoonMain;
import net.midget807.seamoon.block.seamoon.ExtractorBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModBlocks {
    public static final Block EXTRACTOR = registerBlock("extractor",
            new ExtractorBlock(FabricBlockSettings.copyOf(Blocks.DISPENSER)));

    public static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, SeaMoonMain.id(name), block);
    }
    public static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, SeaMoonMain.id(name), new BlockItem(block, new FabricItemSettings()));
    }
    public static void registerModBlocks() {
        SeaMoonMain.LOGGER.info("Registering Sea Moon Blocks");
    }
}
