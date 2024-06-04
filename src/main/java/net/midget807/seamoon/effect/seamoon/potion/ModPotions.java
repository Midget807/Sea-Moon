package net.midget807.seamoon.effect.seamoon.potion;

import net.midget807.seamoon.SeaMoonMain;
import net.midget807.seamoon.effect.ModEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;

public class ModPotions {
    public static final Potion AFFECTION = registerPotion("affection", new Potion(new StatusEffectInstance(ModEffects.AFFECTIONATE, 2400)));
    public static Potion registerPotion(String name, Potion potion) {
        return Registry.register(Registries.POTION, SeaMoonMain.id(name), potion);
    }
    public static Potion registerPotionKey(RegistryKey<Potion> key, Potion potion) {
        return Registry.register(Registries.POTION, key, potion);
    }
}
