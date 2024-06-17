package net.midget807.seamoon.effect.seamoon.potion;

import net.midget807.seamoon.SeaMoonMain;
import net.midget807.seamoon.effect.ModEffects;
import net.midget807.seamoon.item.ModItems;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.BrewingRecipeRegistry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

public class ModPotions {
    public static RegistryKey<Potion> EMPTY_KEY = RegistryKey.of(RegistryKeys.POTION, SeaMoonMain.id("empty_key"));
    //public static final Potion EMPTY = registerPotionWithKey(EMPTY_KEY, new Potion(new StatusEffectInstance[0]));
    public static final Potion AFFECTION = registerPotion("affection", new Potion(new StatusEffectInstance(ModEffects.AFFECTIONATE, 2400, 0)));
    public static final Potion LONG_AFFECTION = registerPotion("long_affection", new Potion(new StatusEffectInstance(ModEffects.AFFECTIONATE, 4800, 0)));
    public static Potion registerPotion(String name, Potion potion) {
        return Registry.register(Registries.POTION, SeaMoonMain.id(name), potion);
    }
    public static Potion registerPotionWithKey(RegistryKey<Potion> key, Potion potion) {
        return Registry.register(Registries.POTION, key, potion);
    }
    public static void registerModPotionRecipes() {
        BrewingRecipeRegistry.registerPotionType(ModItems.SEAMOON_BOTTLE);
        BrewingRecipeRegistry.registerPotionType(ModItems.SPLASH_SEAMOON_BOTTLE);
        BrewingRecipeRegistry.registerPotionType(ModItems.LINGERING_SEAMOON_BOTTLE);
        BrewingRecipeRegistry.registerItemRecipe(ModItems.SEAMOON_BOTTLE, Items.GUNPOWDER, ModItems.SPLASH_SEAMOON_BOTTLE);
        BrewingRecipeRegistry.registerItemRecipe(ModItems.SPLASH_SEAMOON_BOTTLE, Items.DRAGON_BREATH, ModItems.LINGERING_SEAMOON_BOTTLE);
        BrewingRecipeRegistry.registerPotionRecipe(ModPotions.AFFECTION, Items.GLOWSTONE, ModPotions.LONG_AFFECTION);
    }
}
