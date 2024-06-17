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

public class ModPotions {
    public static final Potion AFFECTION = registerPotion("affection", new Potion(new StatusEffectInstance(ModEffects.AFFECTIONATE, 2400, 0)));
    public static Potion registerPotion(String name, Potion potion) {
        return Registry.register(Registries.POTION, SeaMoonMain.id(name), potion);
    }
    public static Potion registerPotionKey(RegistryKey<Potion> key, Potion potion) {
        return Registry.register(Registries.POTION, key, potion);
    }
    public static void registerModPotionRecipes() {
        BrewingRecipeRegistry.registerPotionType(ModItems.SPLASH_SEAMOON_BOTTLE);
        BrewingRecipeRegistry.registerItemRecipe(Items.POTION, ModItems.SEAMOON_BOTTLE, ModItems.SPLASH_SEAMOON_BOTTLE);
    }
}
