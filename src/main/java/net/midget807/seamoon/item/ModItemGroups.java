package net.midget807.seamoon.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.midget807.seamoon.SeaMoonMain;
import net.midget807.seamoon.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;

public class ModItemGroups {
    public static final ItemGroup SEA_MOON = registerItemGroup("seamoon", FabricItemGroup.builder()
            .displayName(Text.translatable("itemGroup.seamoon.seamoon"))
            .icon(() -> new ItemStack(ModItems.SEAMOON_BOTTLE))
            .entries(((displayContext, entries) -> {
                entries.add(ModItems.SEAMOON_BOTTLE);
                entries.add(ModItems.SEAMOON_BUCKET);
                entries.add(ModBlocks.SEAMOON_BLOCK);
                entries.add(ModBlocks.SEAMOON_STAIR);
                entries.add(ModBlocks.SEAMOON_SLAB);
                entries.add(ModBlocks.SEAMOON_POST);
                entries.add(ModBlocks.SEAMOON_FENCE);
                entries.add(ModBlocks.SEAMOON_FENCE_GATE);
                entries.add(ModBlocks.SEAMOON_DOOR);
                entries.add(ModBlocks.SEAMOON_TRAPDOOR);
                entries.add(ModBlocks.SEAMOON_PRESSURE_PLATE);
                entries.add(ModBlocks.SEAMOON_BUTTON);

            }))
            .build());
    private static void addItemsToRedstoneGroup(FabricItemGroupEntries entries) {
        entries.addAfter(Blocks.STONE_BUTTON, ModBlocks.SEAMOON_BUTTON);
        entries.addAfter(Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE, ModBlocks.SEAMOON_PRESSURE_PLATE);
    }
    private static void addItemsToBuildingBlocksGroups(FabricItemGroupEntries entries) {
        entries.add(ModBlocks.SEAMOON_BLOCK);
        entries.add(ModBlocks.SEAMOON_STAIR);
        entries.add(ModBlocks.SEAMOON_SLAB);
        entries.add(ModBlocks.SEAMOON_POST);
        entries.add(ModBlocks.SEAMOON_FENCE);
        entries.add(ModBlocks.SEAMOON_FENCE_GATE);
        entries.add(ModBlocks.SEAMOON_DOOR);
        entries.add(ModBlocks.SEAMOON_TRAPDOOR);
        entries.add(ModBlocks.SEAMOON_PRESSURE_PLATE);
        entries.add(ModBlocks.SEAMOON_BUTTON);
    }
    public static ItemGroup registerItemGroup(String name, ItemGroup group) {
        return Registry.register(Registries.ITEM_GROUP, SeaMoonMain.id(name), group);
    }
    public static void registerModItemGroups() {
        SeaMoonMain.LOGGER.info("Registering Sea Moon Item Groups and adding Items to vanilla groups");
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(ModItemGroups::addItemsToBuildingBlocksGroups);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(ModItemGroups::addItemsToRedstoneGroup);
    }
}
