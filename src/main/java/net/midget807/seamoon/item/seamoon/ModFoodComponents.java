package net.midget807.seamoon.item.seamoon;

import net.midget807.seamoon.effect.ModEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent SEAMOON = new FoodComponent.Builder()
            .hunger(1)
            .saturationModifier(0.1f)
            .statusEffect(new StatusEffectInstance(
                    ModEffects.AFFECTIONATE,
                    2400,
                    0),
                    1.0f)
            .alwaysEdible()
            .build();
}
