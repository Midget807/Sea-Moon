package net.midget807.seamoon.item.seamoon.food;

import net.midget807.seamoon.effect.ModEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.FoodComponents;

public class ModFoodComponents {
    public static final FoodComponent SEAMOON = new FoodComponent.Builder()
            .hunger(1)
            .saturationModifier(0.1f)
            .statusEffect(new StatusEffectInstance(
                    ModEffects.AFFECTIONATE,
                    2400,
                    0),
                    1.0f
            )
            .alwaysEdible()
            .build();
    public static final FoodComponent GLAZED_APPLE = new FoodComponent.Builder()
            .hunger(FoodComponents.APPLE.getHunger())
            .saturationModifier(FoodComponents.APPLE.getSaturationModifier())
            .statusEffect(new StatusEffectInstance(
                    ModEffects.AFFECTIONATE,
                    FoodComponents.APPLE.getHunger() * 20 * 15,
                    0),
                    1.0f
            )
            .build();
    public static final FoodComponent GLAZED_BAKED_POTATO = new FoodComponent.Builder()
            .hunger(FoodComponents.BAKED_POTATO.getHunger())
            .saturationModifier(FoodComponents.BAKED_POTATO.getSaturationModifier())
            .statusEffect(new StatusEffectInstance(
                    ModEffects.AFFECTIONATE,
                    FoodComponents.BAKED_POTATO.getHunger() * 20 * 15,
                    0),
                    1.0f
            )
            .build();
    public static final FoodComponent GLAZED_BEEF = new FoodComponent.Builder()
            .hunger(FoodComponents.BEEF.getHunger())
            .saturationModifier(FoodComponents.BEEF.getSaturationModifier())
            .statusEffect(new StatusEffectInstance(
                    ModEffects.AFFECTIONATE,
                    FoodComponents.BEEF.getHunger() * 20 * 15,
                    0),
                    1.0f
            )
            .build();
    public static final FoodComponent GLAZED_BEETROOT = new FoodComponent.Builder()
            .hunger(FoodComponents.BEETROOT.getHunger())
            .saturationModifier(FoodComponents.BEETROOT.getSaturationModifier())
            .statusEffect(new StatusEffectInstance(
                    ModEffects.AFFECTIONATE,
                    FoodComponents.BEETROOT.getHunger() * 20 * 15,
                    0),
                    1.0f
            )
            .build();
    public static final FoodComponent GLAZED_BEETROOT_SOUP = new FoodComponent.Builder()
            .hunger(FoodComponents.BEETROOT_SOUP.getHunger())
            .saturationModifier(FoodComponents.BEETROOT_SOUP.getSaturationModifier())
            .statusEffect(new StatusEffectInstance(
                    ModEffects.AFFECTIONATE,
                    FoodComponents.BEETROOT_SOUP.getHunger() * 20 * 15,
                    0),
                    1.0f
            )
            .build();
    public static final FoodComponent GLAZED_BREAD = new FoodComponent.Builder()
            .hunger(FoodComponents.BREAD.getHunger())
            .saturationModifier(FoodComponents.BREAD.getSaturationModifier())
            .statusEffect(new StatusEffectInstance(
                    ModEffects.AFFECTIONATE,
                    FoodComponents.BREAD.getHunger() * 20 * 15,
                    0),
                    1.0f
            )
            .build();
    public static final FoodComponent GLAZED_CARROT = new FoodComponent.Builder()
            .hunger(FoodComponents.CARROT.getHunger())
            .saturationModifier(FoodComponents.CARROT.getSaturationModifier())
            .statusEffect(new StatusEffectInstance(
                    ModEffects.AFFECTIONATE,
                    FoodComponents.CARROT.getHunger() * 20 * 15,
                    0),
                    1.0f
            )
            .build();
    public static final FoodComponent GLAZED_CHICKEN = new FoodComponent.Builder()
            .hunger(FoodComponents.CHICKEN.getHunger())
            .saturationModifier(FoodComponents.CHICKEN.getSaturationModifier())
            .statusEffect(new StatusEffectInstance(
                    ModEffects.AFFECTIONATE,
                    FoodComponents.CHICKEN.getHunger() * 20 * 15,
                    0),
                    1.0f
            )
            .build();
    public static final FoodComponent GLAZED_CHORUS_FRUIT = new FoodComponent.Builder()
            .hunger(FoodComponents.CHORUS_FRUIT.getHunger())
            .saturationModifier(FoodComponents.CHORUS_FRUIT.getSaturationModifier())
            .statusEffect(new StatusEffectInstance(
                    ModEffects.AFFECTIONATE,
                    FoodComponents.CHORUS_FRUIT.getHunger() * 20 * 15,
                    0),
                    1.0f
            )
            .build();
    public static final FoodComponent GLAZED_COD = new FoodComponent.Builder()
            .hunger(FoodComponents.COD.getHunger())
            .saturationModifier(FoodComponents.COD.getSaturationModifier())
            .statusEffect(new StatusEffectInstance(
                    ModEffects.AFFECTIONATE,
                    FoodComponents.COD.getHunger() * 20 * 15,
                    0),
                    1.0f
            )
            .build();
    public static final FoodComponent GLAZED_COOKED_BEEF = new FoodComponent.Builder()
            .hunger(FoodComponents.COOKED_BEEF.getHunger())
            .saturationModifier(FoodComponents.COOKED_BEEF.getSaturationModifier())
            .statusEffect(new StatusEffectInstance(
                    ModEffects.AFFECTIONATE,
                    FoodComponents.COOKED_BEEF.getHunger() * 20 * 15,
                    0),
                    1.0f
            )
            .build();
    public static final FoodComponent GLAZED_COOKED_CHICKEN = new FoodComponent.Builder()
            .hunger(FoodComponents.COOKED_CHICKEN.getHunger())
            .saturationModifier(FoodComponents.COOKED_CHICKEN.getSaturationModifier())
            .statusEffect(new StatusEffectInstance(
                    ModEffects.AFFECTIONATE,
                    FoodComponents.COOKED_CHICKEN.getHunger() * 20 * 15,
                    0),
                    1.0f
            )
            .build();
    public static final FoodComponent GLAZED_COOKED_COD = new FoodComponent.Builder()
            .hunger(FoodComponents.COOKED_COD.getHunger())
            .saturationModifier(FoodComponents.COOKED_COD.getSaturationModifier())
            .statusEffect(new StatusEffectInstance(
                    ModEffects.AFFECTIONATE,
                    FoodComponents.COOKED_COD.getHunger() * 20 * 15,
                    0),
                    1.0f
            )
            .build();
    public static final FoodComponent GLAZED_COOKED_MUTTON = new FoodComponent.Builder()
            .hunger(FoodComponents.COOKED_MUTTON.getHunger())
            .saturationModifier(FoodComponents.COOKED_MUTTON.getSaturationModifier())
            .statusEffect(new StatusEffectInstance(
                    ModEffects.AFFECTIONATE,
                    FoodComponents.COOKED_MUTTON.getHunger() * 20 * 15,
                    0),
                    1.0f
            )
            .build();
    public static final FoodComponent GLAZED_COOKED_PORKCHOP = new FoodComponent.Builder()
            .hunger(FoodComponents.COOKED_PORKCHOP.getHunger())
            .saturationModifier(FoodComponents.COOKED_PORKCHOP.getSaturationModifier())
            .statusEffect(new StatusEffectInstance(
                    ModEffects.AFFECTIONATE,
                    FoodComponents.COOKED_PORKCHOP.getHunger() * 20 * 15,
                    0),
                    1.0f
            )
            .build();
    public static final FoodComponent GLAZED_COOKED_RABBIT = new FoodComponent.Builder()
            .hunger(FoodComponents.COOKED_RABBIT.getHunger())
            .saturationModifier(FoodComponents.COOKED_RABBIT.getSaturationModifier())
            .statusEffect(new StatusEffectInstance(
                    ModEffects.AFFECTIONATE,
                    FoodComponents.COOKED_RABBIT.getHunger() * 20 * 15,
                    0),
                    1.0f
            )
            .build();
    public static final FoodComponent GLAZED_COOKED_SALMON = new FoodComponent.Builder()
            .hunger(FoodComponents.COOKED_SALMON.getHunger())
            .saturationModifier(FoodComponents.COOKED_SALMON.getSaturationModifier())
            .statusEffect(new StatusEffectInstance(
                    ModEffects.AFFECTIONATE,
                    FoodComponents.COOKED_SALMON.getHunger() * 20 * 15,
                    0),
                    1.0f
            )
            .build();
    public static final FoodComponent GLAZED_COOKIE = new FoodComponent.Builder()
            .hunger(FoodComponents.COOKIE.getHunger())
            .saturationModifier(FoodComponents.COOKIE.getSaturationModifier())
            .statusEffect(new StatusEffectInstance(
                    ModEffects.AFFECTIONATE,
                    FoodComponents.COOKIE.getHunger() * 20 * 15,
                    0),
                    1.0f
            )
            .build();
    public static final FoodComponent GLAZED_DRIED_KELP = new FoodComponent.Builder()
            .hunger(FoodComponents.DRIED_KELP.getHunger())
            .saturationModifier(FoodComponents.DRIED_KELP.getSaturationModifier())
            .statusEffect(new StatusEffectInstance(
                    ModEffects.AFFECTIONATE,
                    FoodComponents.DRIED_KELP.getHunger() * 20 * 15,
                    0),
                    1.0f
            )
            .build();
    public static final FoodComponent GLAZED_ENCHANTED_GOLDEN_APPLE = new FoodComponent.Builder()
            .hunger(FoodComponents.ENCHANTED_GOLDEN_APPLE.getHunger())
            .saturationModifier(FoodComponents.ENCHANTED_GOLDEN_APPLE.getSaturationModifier())
            .statusEffect(new StatusEffectInstance(
                    ModEffects.AFFECTIONATE,
                    FoodComponents.ENCHANTED_GOLDEN_APPLE.getHunger() * 20 * 15,
                    0),
                    1.0f
            )
            .build();
    public static final FoodComponent GLAZED_GOLDEN_APPLE = new FoodComponent.Builder()
            .hunger(FoodComponents.GOLDEN_APPLE.getHunger())
            .saturationModifier(FoodComponents.GOLDEN_APPLE.getSaturationModifier())
            .statusEffect(new StatusEffectInstance(
                    ModEffects.AFFECTIONATE,
                    FoodComponents.GOLDEN_APPLE.getHunger() * 20 * 15,
                    0),
                    1.0f
            )
            .build();
    public static final FoodComponent GLAZED_GOLDEN_CARROT = new FoodComponent.Builder()
            .hunger(FoodComponents.GOLDEN_CARROT.getHunger())
            .saturationModifier(FoodComponents.GOLDEN_CARROT.getSaturationModifier())
            .statusEffect(new StatusEffectInstance(
                    ModEffects.AFFECTIONATE,
                    FoodComponents.GOLDEN_CARROT.getHunger() * 20 * 15,
                    0),
                    1.0f
            )
            .build();
    public static final FoodComponent GLAZED_HONEY_BOTTLE= new FoodComponent.Builder()
            .hunger(FoodComponents.HONEY_BOTTLE.getHunger())
            .saturationModifier(FoodComponents.HONEY_BOTTLE.getSaturationModifier())
            .statusEffect(new StatusEffectInstance(
                    ModEffects.AFFECTIONATE,
                    FoodComponents.HONEY_BOTTLE.getHunger() * 20 * 15,
                    0),
                    1.0f
            )
            .build();
    public static final FoodComponent GLAZED_MELON_SLICE = new FoodComponent.Builder()
            .hunger(FoodComponents.MELON_SLICE.getHunger())
            .saturationModifier(FoodComponents.MELON_SLICE.getSaturationModifier())
            .statusEffect(new StatusEffectInstance(
                    ModEffects.AFFECTIONATE,
                    FoodComponents.MELON_SLICE.getHunger() * 20 * 15,
                    0),
                    1.0f
            )
            .build();
    public static final FoodComponent GLAZED_MUSHROOM_STEW = new FoodComponent.Builder()
            .hunger(FoodComponents.MUSHROOM_STEW.getHunger())
            .saturationModifier(FoodComponents.MUSHROOM_STEW.getSaturationModifier())
            .statusEffect(new StatusEffectInstance(
                    ModEffects.AFFECTIONATE,
                    FoodComponents.MUSHROOM_STEW.getHunger() * 20 * 15,
                    0),
                    1.0f
            )
            .build();
    public static final FoodComponent GLAZED_MUTTON = new FoodComponent.Builder()
            .hunger(FoodComponents.MUTTON.getHunger())
            .saturationModifier(FoodComponents.MUTTON.getSaturationModifier())
            .statusEffect(new StatusEffectInstance(
                    ModEffects.AFFECTIONATE,
                    FoodComponents.MUTTON.getHunger() * 20 * 15,
                    0),
                    1.0f
            )
            .build();
    public static final FoodComponent GLAZED_POISONOUS_POTATO = new FoodComponent.Builder()
            .hunger(FoodComponents.POISONOUS_POTATO.getHunger())
            .saturationModifier(FoodComponents.POISONOUS_POTATO.getSaturationModifier())
            .statusEffect(new StatusEffectInstance(
                    ModEffects.AFFECTIONATE,
                    FoodComponents.POISONOUS_POTATO.getHunger() * 20 * 15,
                    0),
                    1.0f
            )
            .build();
    public static final FoodComponent GLAZED_PORKCHOP = new FoodComponent.Builder()
            .hunger(FoodComponents.PORKCHOP.getHunger())
            .saturationModifier(FoodComponents.PORKCHOP.getSaturationModifier())
            .statusEffect(new StatusEffectInstance(
                    ModEffects.AFFECTIONATE,
                    FoodComponents.PORKCHOP.getHunger() * 20 * 15,
                    0),
                    1.0f
            )
            .build();
    public static final FoodComponent GLAZED_POTATO = new FoodComponent.Builder()
            .hunger(FoodComponents.POTATO.getHunger())
            .saturationModifier(FoodComponents.POTATO.getSaturationModifier())
            .statusEffect(new StatusEffectInstance(
                    ModEffects.AFFECTIONATE,
                    FoodComponents.POTATO.getHunger() * 20 * 15,
                    0),
                    1.0f
            )
            .build();
    public static final FoodComponent GLAZED_PUFFERFISH = new FoodComponent.Builder()
            .hunger(FoodComponents.PUFFERFISH.getHunger())
            .saturationModifier(FoodComponents.PUFFERFISH.getSaturationModifier())
            .statusEffect(new StatusEffectInstance(
                    ModEffects.AFFECTIONATE,
                    FoodComponents.PUFFERFISH.getHunger() * 20 * 15,
                    0),
                    1.0f
            )
            .build();
    public static final FoodComponent GLAZED_PUMPKIN_PIE = new FoodComponent.Builder()
            .hunger(FoodComponents.PUMPKIN_PIE.getHunger())
            .saturationModifier(FoodComponents.PUMPKIN_PIE.getSaturationModifier())
            .statusEffect(new StatusEffectInstance(
                    ModEffects.AFFECTIONATE,
                    FoodComponents.PUMPKIN_PIE.getHunger() * 20 * 15,
                    0),
                    1.0f
            )
            .build();
    public static final FoodComponent GLAZED_RABBIT = new FoodComponent.Builder()
            .hunger(FoodComponents.RABBIT.getHunger())
            .saturationModifier(FoodComponents.RABBIT.getSaturationModifier())
            .statusEffect(new StatusEffectInstance(
                    ModEffects.AFFECTIONATE,
                    FoodComponents.RABBIT.getHunger() * 20 * 15,
                    0),
                    1.0f
            )
            .build();
    public static final FoodComponent GLAZED_RABBIT_STEW = new FoodComponent.Builder()
            .hunger(FoodComponents.RABBIT_STEW.getHunger())
            .saturationModifier(FoodComponents.RABBIT_STEW.getSaturationModifier())
            .statusEffect(new StatusEffectInstance(
                    ModEffects.AFFECTIONATE,
                    FoodComponents.RABBIT_STEW.getHunger() * 20 * 15,
                    0),
                    1.0f
            )
            .build();
    public static final FoodComponent GLAZED_ROTTEN_FLESH = new FoodComponent.Builder()
            .hunger(FoodComponents.ROTTEN_FLESH.getHunger())
            .saturationModifier(FoodComponents.ROTTEN_FLESH.getSaturationModifier())
            .statusEffect(new StatusEffectInstance(
                    ModEffects.AFFECTIONATE,
                    FoodComponents.ROTTEN_FLESH.getHunger() * 20 * 15,
                    0),
                    1.0f
            )
            .build();
    public static final FoodComponent GLAZED_SALMON = new FoodComponent.Builder()
            .hunger(FoodComponents.SALMON.getHunger())
            .saturationModifier(FoodComponents.SALMON.getSaturationModifier())
            .statusEffect(new StatusEffectInstance(
                    ModEffects.AFFECTIONATE,
                    FoodComponents.SALMON.getHunger() * 20 * 15,
                    0),
                    1.0f
            )
            .build();
    public static final FoodComponent GLAZED_SPIDER_EYE = new FoodComponent.Builder()
            .hunger(FoodComponents.SPIDER_EYE.getHunger())
            .saturationModifier(FoodComponents.SPIDER_EYE.getSaturationModifier())
            .statusEffect(new StatusEffectInstance(
                    ModEffects.AFFECTIONATE,
                    FoodComponents.SPIDER_EYE.getHunger() * 20 * 15,
                    0),
                    1.0f
            )
            .build();
    public static final FoodComponent GLAZED_SUSPICIOUS_STEW = new FoodComponent.Builder()
            .hunger(FoodComponents.SUSPICIOUS_STEW.getHunger())
            .saturationModifier(FoodComponents.SUSPICIOUS_STEW.getSaturationModifier())
            .statusEffect(new StatusEffectInstance(
                    ModEffects.AFFECTIONATE,
                    FoodComponents.SUSPICIOUS_STEW.getHunger() * 20 * 15,
                    0),
                    1.0f
            )
            .build();
    public static final FoodComponent GLAZED_SWEET_BERRIES = new FoodComponent.Builder()
            .hunger(FoodComponents.SWEET_BERRIES.getHunger())
            .saturationModifier(FoodComponents.SWEET_BERRIES.getSaturationModifier())
            .statusEffect(new StatusEffectInstance(
                    ModEffects.AFFECTIONATE,
                    FoodComponents.SWEET_BERRIES.getHunger() * 20 * 15,
                    0),
                    1.0f
            )
            .build();
    public static final FoodComponent GLAZED_GLOW_BERRIES = new FoodComponent.Builder()
            .hunger(FoodComponents.GLOW_BERRIES.getHunger())
            .saturationModifier(FoodComponents.GLOW_BERRIES.getSaturationModifier())
            .statusEffect(new StatusEffectInstance(
                    ModEffects.AFFECTIONATE,
                    FoodComponents.GLOW_BERRIES.getHunger() * 20 * 15,
                    0),
                    1.0f
            )
            .build();
    public static final FoodComponent GLAZED_TROPICAL_FISH = new FoodComponent.Builder()
            .hunger(FoodComponents.TROPICAL_FISH.getHunger())
            .saturationModifier(FoodComponents.TROPICAL_FISH.getSaturationModifier())
            .statusEffect(new StatusEffectInstance(
                    ModEffects.AFFECTIONATE,
                    FoodComponents.TROPICAL_FISH.getHunger() * 20 * 15,
                    0),
                    1.0f
            )
            .build();
    public static final FoodComponent STICKY_BICKY = new FoodComponent.Builder()
            .hunger(FoodComponents.COOKIE.getHunger())
            .saturationModifier(FoodComponents.COOKIE.getSaturationModifier())
            .statusEffect(new StatusEffectInstance(
                    ModEffects.AFFECTIONATE,
                    FoodComponents.COOKIE.getHunger() * 20 * 30,
                    0),
                    1.0f
            )
            .statusEffect(new StatusEffectInstance(
                    StatusEffects.NAUSEA,
                    FoodComponents.COOKIE.getHunger() * 20 * 30,
                    0),
                    1.0f
            )
            .statusEffect(new StatusEffectInstance(
                    StatusEffects.DARKNESS,
                    FoodComponents.COOKIE.getHunger() * 20 * 30,
                    0),
                    1.0f
            )
            .build();
    public static final FoodComponent SOGGY_SEAWEED = new FoodComponent.Builder()
            .hunger(FoodComponents.DRIED_KELP.getHunger())
            .saturationModifier(FoodComponents.DRIED_KELP.getSaturationModifier())
            .statusEffect(new StatusEffectInstance(
                    ModEffects.AFFECTIONATE,
                    FoodComponents.DRIED_KELP.getHunger() * 20 * 30,
                    0),
                    1.0f
            )
            .statusEffect(new StatusEffectInstance(
                    StatusEffects.NAUSEA,
                    FoodComponents.DRIED_KELP.getHunger() * 20 * 30,
                    0),
                    1.0f
            )
            .statusEffect(new StatusEffectInstance(
                    StatusEffects.DARKNESS,
                    FoodComponents.DRIED_KELP.getHunger() * 20 * 30,
                    0),
                    1.0f
            )
            .build();


}
