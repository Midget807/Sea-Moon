package net.midget807.seamoon.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.midget807.seamoon.SeaMoonMain;
import net.midget807.seamoon.block.ModBlocks;
import net.midget807.seamoon.effect.seamoon.potion.ModPotions;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SuspiciousStewIngredient;
import net.minecraft.item.*;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionUtil;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;

import java.util.List;
import java.util.Set;

public class ModItemGroups {
    public static final ItemGroup SEA_MOON = registerItemGroup("seamoon", FabricItemGroup.builder()
            .displayName(Text.translatable("itemGroup.seamoon.seamoon"))
            .icon(() -> new ItemStack(ModItems.SEAMOON_BOTTLE))
            .entries(((displayContext, entries) -> {
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
                entries.add(ModItems.SEAMOON_BUCKET);
                entries.add(PotionUtil.setPotion(ModItems.SEAMOON_BOTTLE.getDefaultStack(), ModPotions.AFFECTION));
                entries.add(PotionUtil.setPotion(ModItems.SEAMOON_BOTTLE.getDefaultStack(), ModPotions.LONG_AFFECTION));
                entries.add(PotionUtil.setPotion(ModItems.SPLASH_SEAMOON_BOTTLE.getDefaultStack(), ModPotions.AFFECTION));
                entries.add(PotionUtil.setPotion(ModItems.SPLASH_SEAMOON_BOTTLE.getDefaultStack(), ModPotions.LONG_AFFECTION));
                entries.add(PotionUtil.setPotion(ModItems.LINGERING_SEAMOON_BOTTLE.getDefaultStack(), ModPotions.AFFECTION));
                entries.add(PotionUtil.setPotion(ModItems.LINGERING_SEAMOON_BOTTLE.getDefaultStack(), ModPotions.LONG_AFFECTION));

            }))
            .build());

    private static void addPotions(ItemGroup.Entries entries, RegistryWrapper.Impl<Potion> wrapper, Item item, ItemGroup.StackVisibility stackVisibility) {
        wrapper.streamEntries().filter(entry -> !entry.matchesKey(ModPotions.EMPTY_KEY)).map(entry -> PotionUtil.setPotion(new ItemStack(item), entry.value())).forEach(stack -> entries.add(stack, stackVisibility));
    }

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
        entries.addAfter(Items.MILK_BUCKET, ModItems.SEAMOON_BUCKET);
        entries.addAfter(Items.APPLE, ModItems.GLAZED_APPLE);
        entries.addAfter(Items.BAKED_POTATO, ModItems.GLAZED_BAKED_POTATO);
        entries.addAfter(Items.BEEF, ModItems.GLAZED_BEEF);
        entries.addAfter(Items.BEETROOT, ModItems.GLAZED_BEETROOT);
        entries.addAfter(Items.BEETROOT_SOUP, ModItems.GLAZED_BEETROOT_SOUP);
        entries.addAfter(Items.BREAD, ModItems.GLAZED_BREAD);
        entries.addAfter(Items.CARROT, ModItems.GLAZED_CARROT);
        entries.addAfter(Items.CHICKEN, ModItems.GLAZED_CHICKEN);
        entries.addAfter(Items.CHORUS_FRUIT, ModItems.GLAZED_CHORUS_FRUIT);
        entries.addAfter(Items.COD, ModItems.GLAZED_COD);
        entries.addAfter(Items.COOKED_BEEF, ModItems.GLAZED_COOKED_BEEF);
        entries.addAfter(Items.COOKED_CHICKEN, ModItems.GLAZED_COOKED_CHICKEN);
        entries.addAfter(Items.COOKED_COD, ModItems.GLAZED_COOKED_COD);
        entries.addAfter(Items.COOKED_MUTTON, ModItems.GLAZED_COOKED_MUTTON);
        entries.addAfter(Items.COOKED_PORKCHOP, ModItems.GLAZED_COOKED_PORKCHOP);
        entries.addAfter(Items.COOKED_RABBIT, ModItems.GLAZED_COOKED_RABBIT);
        entries.addAfter(Items.COOKED_SALMON, ModItems.GLAZED_COOKED_SALMON);
        entries.addAfter(Items.COOKIE, ModItems.GLAZED_COOKIE);
        entries.addAfter(Items.DRIED_KELP, ModItems.GLAZED_DRIED_KELP);
        entries.addAfter(Items.ENCHANTED_GOLDEN_APPLE, ModItems.GLAZED_ENCHANTED_GOLDEN_APPLE);
        entries.addAfter(Items.GOLDEN_APPLE, ModItems.GLAZED_GOLDEN_APPLE);
        entries.addAfter(Items.GOLDEN_CARROT, ModItems.GLAZED_GOLDEN_CARROT);
        entries.addAfter(Items.HONEY_BOTTLE, ModItems.GLAZED_HONEY_BOTTLE);
        entries.addAfter(Items.MELON_SLICE, ModItems.GLAZED_MELON_SLICE);
        entries.addAfter(Items.MUSHROOM_STEW, ModItems.GLAZED_MUSHROOM_STEW);
        entries.addAfter(Items.MUTTON, ModItems.GLAZED_MUTTON);
        entries.addAfter(Items.POISONOUS_POTATO, ModItems.GLAZED_POISONOUS_POTATO);
        entries.addAfter(Items.PORKCHOP, ModItems.GLAZED_PORKCHOP);
        entries.addAfter(Items.POTATO, ModItems.GLAZED_POTATO);
        entries.addAfter(Items.PUFFERFISH, ModItems.GLAZED_PUFFERFISH);
        entries.addAfter(Items.PUMPKIN_PIE, ModItems.GLAZED_PUMPKIN_PIE);
        entries.addAfter(Items.RABBIT, ModItems.GLAZED_RABBIT);
        entries.addAfter(Items.RABBIT_STEW, ModItems.GLAZED_RABBIT_STEW);
        entries.addAfter(Items.ROTTEN_FLESH, ModItems.GLAZED_ROTTEN_FLESH);
        entries.addAfter(Items.SALMON, ModItems.GLAZED_SALMON);
        entries.addAfter(Items.SPIDER_EYE, ModItems.GLAZED_SPIDER_EYE);
        addSuspiciousStews(entries, ItemGroup.StackVisibility.PARENT_AND_SEARCH_TABS);
        entries.addAfter(Items.SWEET_BERRIES, ModItems.GLAZED_SWEET_BERRIES);
        entries.addAfter(Items.GLOW_BERRIES, ModItems.GLAZED_GLOW_BERRIES);
        entries.addAfter(Items.TROPICAL_FISH, ModItems.GLAZED_TROPICAL_FISH);
        entries.addAfter(ModItems.GLAZED_COOKIE, ModItems.STICKY_BICKY);
        entries.addAfter(ModItems.GLAZED_DRIED_KELP, ModItems.SOGGY_SEAWEED);
        entries.addAfter(ModItems.GLAZED_PUMPKIN_PIE, ModItems.CREAM_PIE);
        entries.prepend(PotionUtil.setPotion(Items.POTION.getDefaultStack(), ModPotions.AFFECTION));
        entries.prepend(PotionUtil.setPotion(Items.POTION.getDefaultStack(), ModPotions.LONG_AFFECTION));
        entries.prepend(PotionUtil.setPotion(Items.SPLASH_POTION.getDefaultStack(), ModPotions.AFFECTION));
        entries.prepend(PotionUtil.setPotion(Items.SPLASH_POTION.getDefaultStack(), ModPotions.LONG_AFFECTION));
        entries.prepend(PotionUtil.setPotion(Items.LINGERING_POTION.getDefaultStack(), ModPotions.AFFECTION));
        entries.prepend(PotionUtil.setPotion(Items.LINGERING_POTION.getDefaultStack(), ModPotions.LONG_AFFECTION));
        entries.addAfter(PotionUtil.setPotion(Items.POTION.getDefaultStack(), Potions.LONG_SLOW_FALLING), PotionUtil.setPotion(ModItems.SEAMOON_BOTTLE.getDefaultStack(), ModPotions.AFFECTION));
        entries.addAfter(PotionUtil.setPotion(ModItems.SEAMOON_BOTTLE.getDefaultStack(), ModPotions.AFFECTION), PotionUtil.setPotion(ModItems.SEAMOON_BOTTLE.getDefaultStack(), ModPotions.LONG_AFFECTION));
        entries.addAfter(PotionUtil.setPotion(Items.SPLASH_POTION.getDefaultStack(), Potions.LONG_SLOW_FALLING), PotionUtil.setPotion(ModItems.SPLASH_SEAMOON_BOTTLE.getDefaultStack(), ModPotions.AFFECTION));
        entries.addAfter(PotionUtil.setPotion(ModItems.SPLASH_SEAMOON_BOTTLE.getDefaultStack(), ModPotions.AFFECTION), PotionUtil.setPotion(ModItems.SPLASH_SEAMOON_BOTTLE.getDefaultStack(), ModPotions.LONG_AFFECTION));
        entries.addAfter(PotionUtil.setPotion(Items.LINGERING_POTION.getDefaultStack(), Potions.LONG_SLOW_FALLING), PotionUtil.setPotion(ModItems.LINGERING_SEAMOON_BOTTLE.getDefaultStack(), ModPotions.AFFECTION));
        entries.addAfter(PotionUtil.setPotion(ModItems.LINGERING_SEAMOON_BOTTLE.getDefaultStack(), ModPotions.AFFECTION), PotionUtil.setPotion(ModItems.LINGERING_SEAMOON_BOTTLE.getDefaultStack(), ModPotions.LONG_AFFECTION));
    }

    private static void addSuspiciousStews(FabricItemGroupEntries entries, ItemGroup.StackVisibility stackVisibility) {
        List<SuspiciousStewIngredient> list = SuspiciousStewIngredient.getAll();
        Set<ItemStack> set = ItemStackSet.create();
        for (SuspiciousStewIngredient suspiciousStewIngredient : list) {
            ItemStack itemStack = new ItemStack(ModItems.GLAZED_SUSPICIOUS_STEW);
            SuspiciousStewItem.writeEffectsToStew(itemStack, suspiciousStewIngredient.getStewEffects());
            set.add(itemStack);
        }
        entries.addBefore(Items.MILK_BUCKET, set, stackVisibility);
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
