package net.midget807.seamoon.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.midget807.seamoon.SeaMoonMain;
import net.midget807.seamoon.block.seamoon.ExtractorBlock;
import net.midget807.seamoon.block.seamoon.ModFluids;
import net.midget807.seamoon.block.seamoon.PostBlock;
import net.midget807.seamoon.block.seamoon.SeaMoonSplatterBlock;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;

public class ModBlocks {
    public static final Block SEAMOON = registerBlock("seamoon",
            (Block) new FluidBlock(ModFluids.SEAMOON_FLUID, AbstractBlock.Settings.create()
                    .mapColor(MapColor.WHITE)
                    .replaceable()
                    .noCollision()
                    .strength(100.0f)
                    .pistonBehavior(PistonBehavior.DESTROY)
                    .dropsNothing()
                    .liquid().
                    sounds(BlockSoundGroup.INTENTIONALLY_EMPTY)));
    public static final Block SEAMOON_BLOCK = registerBlock("seamoon_block",
            new Block(FabricBlockSettings.copyOf(Blocks.SANDSTONE).sounds(BlockSoundGroup.HONEY)));
    public static final Block SEAMOON_STAIR = registerBlock("seamoon_stair",
            new StairsBlock(ModBlocks.SEAMOON_BLOCK.getDefaultState(), FabricBlockSettings.copyOf(Blocks.SANDSTONE).sounds(BlockSoundGroup.HONEY)));
    public static final Block SEAMOON_SLAB = registerBlock("seamoon_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.SANDSTONE).sounds(BlockSoundGroup.HONEY)));
    public static final Block SEAMOON_POST = registerBlock("seamoon_post",
            new PostBlock(FabricBlockSettings.copyOf(Blocks.SANDSTONE).sounds(BlockSoundGroup.HONEY)));
    public static final Block SEAMOON_FENCE = registerBlock("seamoon_fence",
            new FenceBlock(FabricBlockSettings.copyOf(Blocks.SANDSTONE).sounds(BlockSoundGroup.HONEY)));
    public static final Block SEAMOON_FENCE_GATE = registerBlock("seamoon_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.SANDSTONE).sounds(BlockSoundGroup.HONEY), WoodType.WARPED));
    public static final Block SEAMOON_WALL = registerBlock("seamoon_wall",
            new WallBlock(FabricBlockSettings.copyOf(Blocks.SANDSTONE).sounds(BlockSoundGroup.HONEY)));
    public static final Block SEAMOON_BUTTON = registerBlock("seamoon_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.SANDSTONE).sounds(BlockSoundGroup.HONEY), BlockSetType.WARPED, 10, true));
    public static final Block SEAMOON_PRESSURE_PLATE = registerBlock("seamoon_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.SANDSTONE).sounds(BlockSoundGroup.HONEY), BlockSetType.WARPED));
    public static final Block SEAMOON_DOOR = registerBlock("seamoon_door",
            new DoorBlock(FabricBlockSettings.copyOf(Blocks.SANDSTONE).nonOpaque().sounds(BlockSoundGroup.HONEY), BlockSetType.WARPED));
    public static final Block SEAMOON_TRAPDOOR = registerBlock("seamoon_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.SANDSTONE).nonOpaque().sounds(BlockSoundGroup.HONEY), BlockSetType.WARPED));
    public static final Block SEAMOON_SPLATTER = registerBlock("seamoon_splatter",
            new SeaMoonSplatterBlock(FabricBlockSettings.copyOf(Blocks.GLOW_LICHEN).sounds(BlockSoundGroup.HONEY).nonOpaque().noCollision().pistonBehavior(PistonBehavior.DESTROY).luminance(0)));
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
