package net.midget807.seamoon.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.midget807.seamoon.SeaMoonMain;
import net.midget807.seamoon.block.seamoon.ModFluids;
import net.midget807.seamoon.item.seamoon.LingeringSeaMoonBottle;
import net.midget807.seamoon.item.seamoon.SeaMoonBottle;
import net.midget807.seamoon.item.seamoon.SplashSeaMoonBottle;
import net.midget807.seamoon.item.seamoon.food.ModFoodComponents;
import net.midget807.seamoon.item.seamoon.SeaMoonBucket;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModItems {
    public static final Item SEAMOON_BUCKET = registerItem("seamoon_bucket", new SeaMoonBucket(ModFluids.SEAMOON_FLUID, new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1)));

    public static final Item SEAMOON_BOTTLE = registerItem("seamoon_bottle", new SeaMoonBottle(new FabricItemSettings().maxCount(16).food(ModFoodComponents.SEAMOON)));
    public static final Item SPLASH_SEAMOON_BOTTLE = registerItem("splash_seamoon_bottle", new SplashSeaMoonBottle(new FabricItemSettings()));
    public static final Item LINGERING_SEAMOON_BOTTLE = registerItem("lingering_seamoon_bottle", new LingeringSeaMoonBottle(new FabricItemSettings()));

    //Glazed Foods
    public static final Item GLAZED_APPLE = registerItem("glazed_apple", new Item(new FabricItemSettings().food(ModFoodComponents.GLAZED_APPLE)));
    public static final Item GLAZED_BAKED_POTATO = registerItem("glazed_baked_potato", new Item(new FabricItemSettings().food(ModFoodComponents.GLAZED_BAKED_POTATO)));
    public static final Item GLAZED_BEEF = registerItem("glazed_beef", new Item(new FabricItemSettings().food(ModFoodComponents.GLAZED_BEEF)));
    public static final Item GLAZED_BEETROOT = registerItem("glazed_beetroot", new Item(new FabricItemSettings().food(ModFoodComponents.GLAZED_BEETROOT)));
    public static final Item GLAZED_BEETROOT_SOUP = registerItem("glazed_beetroot_soup", new Item(new FabricItemSettings().food(ModFoodComponents.GLAZED_BEETROOT_SOUP)));
    public static final Item GLAZED_BREAD = registerItem("glazed_bread", new Item(new FabricItemSettings().food(ModFoodComponents.GLAZED_BREAD)));
    public static final Item GLAZED_CARROT = registerItem("glazed_carrot", new Item(new FabricItemSettings().food(ModFoodComponents.GLAZED_CARROT)));
    public static final Item GLAZED_CHICKEN = registerItem("glazed_chicken", new Item(new FabricItemSettings().food(ModFoodComponents.GLAZED_CHICKEN)));
    public static final Item GLAZED_CHORUS_FRUIT = registerItem("glazed_chorus_fruit", new Item(new FabricItemSettings().food(ModFoodComponents.GLAZED_CHORUS_FRUIT)));
    public static final Item GLAZED_COD = registerItem("glazed_cod", new Item(new FabricItemSettings().food(ModFoodComponents.GLAZED_COD)));
    public static final Item GLAZED_COOKED_BEEF = registerItem("glazed_cooked_beef", new Item(new FabricItemSettings().food(ModFoodComponents.GLAZED_COOKED_BEEF)));
    public static final Item GLAZED_COOKED_CHICKEN = registerItem("glazed_cooked_chicken", new Item(new FabricItemSettings().food(ModFoodComponents.GLAZED_COOKED_CHICKEN)));
    public static final Item GLAZED_COOKED_COD = registerItem("glazed_cooked_cod", new Item(new FabricItemSettings().food(ModFoodComponents.GLAZED_COOKED_COD)));
    public static final Item GLAZED_COOKED_MUTTON = registerItem("glazed_cooked_mutton", new Item(new FabricItemSettings().food(ModFoodComponents.GLAZED_COOKED_MUTTON)));
    public static final Item GLAZED_COOKED_PORKCHOP = registerItem("glazed_cooked_porkchop", new Item(new FabricItemSettings().food(ModFoodComponents.GLAZED_COOKED_PORKCHOP)));
    public static final Item GLAZED_COOKED_RABBIT = registerItem("glazed_cooked_rabbit", new Item(new FabricItemSettings().food(ModFoodComponents.GLAZED_COOKED_RABBIT)));
    public static final Item GLAZED_COOKED_SALMON = registerItem("glazed_cooked_salmon", new Item(new FabricItemSettings().food(ModFoodComponents.GLAZED_COOKED_SALMON)));
    public static final Item GLAZED_COOKIE = registerItem("glazed_cookie", new Item(new FabricItemSettings().food(ModFoodComponents.GLAZED_COOKIE)));
    public static final Item GLAZED_DRIED_KELP = registerItem("glazed_dried_kelp", new Item(new FabricItemSettings().food(ModFoodComponents.GLAZED_DRIED_KELP)));
    public static final Item GLAZED_ENCHANTED_GOLDEN_APPLE = registerItem("glazed_enchanted_golden_apple", new Item(new FabricItemSettings().food(ModFoodComponents.GLAZED_ENCHANTED_GOLDEN_APPLE)));
    public static final Item GLAZED_GOLDEN_APPLE = registerItem("glazed_golden_apple", new Item(new FabricItemSettings().food(ModFoodComponents.GLAZED_GOLDEN_APPLE)));
    public static final Item GLAZED_GOLDEN_CARROT = registerItem("glazed_golden_carrot", new Item(new FabricItemSettings().food(ModFoodComponents.GLAZED_GOLDEN_CARROT)));
    public static final Item GLAZED_HONEY_BOTTLE = registerItem("glazed_honey_bottle", new Item(new FabricItemSettings().food(ModFoodComponents.GLAZED_HONEY_BOTTLE)));
    public static final Item GLAZED_MELON_SLICE = registerItem("glazed_melon_slice", new Item(new FabricItemSettings().food(ModFoodComponents.GLAZED_MELON_SLICE)));
    public static final Item GLAZED_MUSHROOM_STEW = registerItem("glazed_mushroom_stem", new Item(new FabricItemSettings().food(ModFoodComponents.GLAZED_MUSHROOM_STEW)));
    public static final Item GLAZED_MUTTON = registerItem("glazed_mutton", new Item(new FabricItemSettings().food(ModFoodComponents.GLAZED_MUTTON)));
    public static final Item GLAZED_POISONOUS_POTATO = registerItem("glazed_poisonous_potato", new Item(new FabricItemSettings().food(ModFoodComponents.GLAZED_POISONOUS_POTATO)));
    public static final Item GLAZED_PORKCHOP = registerItem("glazed_porkchop", new Item(new FabricItemSettings().food(ModFoodComponents.GLAZED_PORKCHOP)));
    public static final Item GLAZED_POTATO = registerItem("glazed_potato", new Item(new FabricItemSettings().food(ModFoodComponents.GLAZED_POTATO)));
    public static final Item GLAZED_PUFFERFISH = registerItem("glazed_pufferfish", new Item(new FabricItemSettings().food(ModFoodComponents.GLAZED_PUFFERFISH)));
    public static final Item GLAZED_PUMPKIN_PIE = registerItem("glazed_pumpkin_pie", new Item(new FabricItemSettings().food(ModFoodComponents.GLAZED_PUMPKIN_PIE)));
    public static final Item GLAZED_RABBIT = registerItem("glazed_rabbit", new Item(new FabricItemSettings().food(ModFoodComponents.GLAZED_RABBIT)));
    public static final Item GLAZED_RABBIT_STEW = registerItem("glazed_rabbit_stew", new Item(new FabricItemSettings().food(ModFoodComponents.GLAZED_RABBIT_STEW)));
    public static final Item GLAZED_ROTTEN_FLESH = registerItem("glazed_rotten_flesh", new Item(new FabricItemSettings().food(ModFoodComponents.GLAZED_ROTTEN_FLESH)));
    public static final Item GLAZED_SALMON = registerItem("glazed_salmon", new Item(new FabricItemSettings().food(ModFoodComponents.GLAZED_SALMON)));
    public static final Item GLAZED_SPIDER_EYE = registerItem("glazed_spider_eye", new Item(new FabricItemSettings().food(ModFoodComponents.GLAZED_SPIDER_EYE)));
    public static final Item GLAZED_SUSPICIOUS_STEW = registerItem("glazed_suspicious_stew", new SuspiciousStewItem(new FabricItemSettings().food(ModFoodComponents.GLAZED_SUSPICIOUS_STEW)));
    public static final Item GLAZED_SWEET_BERRIES = registerItem("glazed_sweet_berries", new Item(new FabricItemSettings().food(ModFoodComponents.GLAZED_SWEET_BERRIES)));
    public static final Item GLAZED_GLOW_BERRIES = registerItem("glazed_glow_berries", new Item(new FabricItemSettings().food(ModFoodComponents.GLAZED_GLOW_BERRIES)));
    public static final Item GLAZED_TROPICAL_FISH = registerItem("glazed_tropical_fish", new Item(new FabricItemSettings().food(ModFoodComponents.GLAZED_TROPICAL_FISH)));
    public static final Item STICKY_BICKY = registerItem("sticky_bicky", new Item(new FabricItemSettings().food(ModFoodComponents.STICKY_BICKY)));
    public static final Item SOGGY_SEAWEED = registerItem("soggy_seaweed", new Item(new FabricItemSettings().food(ModFoodComponents.SOGGY_SEAWEED)));
    public static final Item CREAM_PIE = registerItem("cream_pie", new Item(new FabricItemSettings().food(ModFoodComponents.CREAM_PIE)));

    public static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, SeaMoonMain.id(name), item);
    }
    public static void registerModItems() {
        SeaMoonMain.LOGGER.info("Registering Sea Moon Items");
    }
}
