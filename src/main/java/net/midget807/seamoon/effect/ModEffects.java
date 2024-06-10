package net.midget807.seamoon.effect;

import net.midget807.seamoon.SeaMoonMain;
import net.midget807.seamoon.effect.seamoon.EmptyEffect;
import net.midget807.seamoon.entity.attribute.ModAttributes;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModEffects {
    public static final StatusEffect AFFECTIONATE = registerEffect("affectionate", new EmptyEffect(StatusEffectCategory.NEUTRAL, 3402751)
            /*.addAttributeModifier(ModAttributes.SEAMOON_AFFECTION, "b51fb147-0f19-4fbe-90d2-46079d272727", 5.0, EntityAttributeModifier.Operation.ADDITION)*/
    );

    public static StatusEffect registerEffect(String name, StatusEffect effect) {
        return Registry.register(Registries.STATUS_EFFECT, SeaMoonMain.id(name), effect);
    }
    public static void registerModEffects() {
        SeaMoonMain.LOGGER.info("Registering Sea Moon Effects");
    }
}
