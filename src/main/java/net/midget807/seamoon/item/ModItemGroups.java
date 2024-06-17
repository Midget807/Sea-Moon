package net.midget807.seamoon.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.midget807.seamoon.SeaMoonMain;
import net.midget807.seamoon.block.ModBlocks;
import net.midget807.seamoon.effect.seamoon.potion.ModPotions;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.PotionUtil;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;

public class ModItemGroups {
    public static final ItemGroup SEA_MOON = registerItemGroup("seamoon", FabricItemGroup.builder()
            .displayName(Text.translatable("itemGroup.seamoon.seamoon"))
            .icon(() -> new ItemStack(ModItems.SEAMOON_BOTTLE))
            .entries(((displayContext, entries) -> {
                entries.add(ModItems.SEAMOON_BUCKET);
                entries.add(PotionUtil.setPotion(ModItems.SEAMOON_BOTTLE.getDefaultStack(), ModPotions.AFFECTION));
                entries.add(PotionUtil.setPotion(ModItems.SPLASH_SEAMOON_BOTTLE.getDefaultStack(), ModPotions.AFFECTION));
                entries.add(PotionUtil.setPotion(ModItems.LINGERING_SEAMOON_BOTTLE.getDefaultStack(), ModPotions.AFFECTION));
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
    private static void addItemsToFoodAndDrinksGroup(FabricItemGroupEntries entries) {
        entries.add(ModItems.GLAZED_APPLE);
        entries.add(ModItems.GLAZED_BAKED_POTATO);
        entries.add(ModItems.GLAZED_BEEF);
        entries.add(ModItems.GLAZED_BEETROOT);
        entries.add(ModItems.GLAZED_BEETROOT_SOUP);
        entries.add(ModItems.GLAZED_BREAD);
        entries.add(ModItems.GLAZED_CARROT);
        entries.add(ModItems.GLAZED_CHICKEN);
        entries.add(ModItems.GLAZED_CHORUS_FRUIT);
        entries.add(ModItems.GLAZED_COD);
        entries.add(ModItems.GLAZED_COOKED_BEEF);
        entries.add(ModItems.GLAZED_COOKED_CHICKEN);
        entries.add(ModItems.GLAZED_COOKED_COD);
        entries.add(ModItems.GLAZED_COOKED_MUTTON);
        entries.add(ModItems.GLAZED_COOKED_PORKCHOP);
        entries.add(ModItems.GLAZED_COOKED_RABBIT);
        entries.add(ModItems.GLAZED_COOKED_SALMON);
        entries.add(ModItems.GLAZED_COOKIE);
        entries.add(ModItems.GLAZED_DRIED_KELP);
        entries.add(ModItems.GLAZED_ENCHANTED_GOLDEN_APPLE);
        entries.add(ModItems.GLAZED_GOLDEN_APPLE);
        entries.add(ModItems.GLAZED_GOLDEN_CARROT);
        entries.add(ModItems.GLAZED_HONEY_BOTTLE);
        entries.add(ModItems.GLAZED_MELON_SLICE);
        entries.add(ModItems.GLAZED_MUSHROOM_STEW);
        entries.add(ModItems.GLAZED_MUTTON);
        entries.add(ModItems.GLAZED_POISONOUS_POTATO);
        entries.add(ModItems.GLAZED_PORKCHOP);
        entries.add(ModItems.GLAZED_POTATO);
        entries.add(ModItems.GLAZED_PUFFERFISH);
        entries.add(ModItems.GLAZED_PUMPKIN_PIE);
        entries.add(ModItems.GLAZED_RABBIT);
        entries.add(ModItems.GLAZED_RABBIT_STEW);
        entries.add(ModItems.GLAZED_ROTTEN_FLESH);
        entries.add(ModItems.GLAZED_SALMON);
        entries.add(ModItems.GLAZED_SPIDER_EYE);
        entries.add(ModItems.GLAZED_SUSPICIOUS_STEW);
        entries.add(ModItems.GLAZED_SWEET_BERRIES);
        entries.add(ModItems.GLAZED_GLOW_BERRIES);
        entries.add(ModItems.GLAZED_TROPICAL_FISH);
        entries.add(ModItems.STICKY_BICKY);
        entries.add(ModItems.SOGGY_SEAWEED);
        entries.add(ModItems.CREAM_PIE);
    }
    public static ItemGroup registerItemGroup(String name, ItemGroup group) {
        return Registry.register(Registries.ITEM_GROUP, SeaMoonMain.id(name), group);
    }
    public static void registerModItemGroups() {
        SeaMoonMain.LOGGER.info("Registering Sea Moon Item Groups and adding Items to vanilla groups");
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(ModItemGroups::addItemsToBuildingBlocksGroups);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(ModItemGroups::addItemsToRedstoneGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModItemGroups::addItemsToFoodAndDrinksGroup);
    }
}
