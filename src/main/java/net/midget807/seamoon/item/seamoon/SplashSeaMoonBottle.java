package net.midget807.seamoon.item.seamoon;

import net.midget807.seamoon.effect.seamoon.potion.ModPotions;
import net.midget807.seamoon.entity.seamoon.SeaMoonBottleEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.PotionEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ThrowablePotionItem;
import net.minecraft.potion.PotionUtil;
import net.minecraft.potion.Potions;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class SplashSeaMoonBottle extends ThrowablePotionItem {

    public SplashSeaMoonBottle(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if (!world.isClient) {
            SeaMoonBottleEntity seaMoonBottleEntity = new SeaMoonBottleEntity(world, user);
            seaMoonBottleEntity.setItem(itemStack);
            seaMoonBottleEntity.setVelocity(user, user.getPitch(), user.getYaw(), -20.0f, 0.5f, 1.0f);
            world.spawnEntity(seaMoonBottleEntity);
        }
        user.incrementStat(Stats.USED.getOrCreateStat(this));
        if (!user.getAbilities().creativeMode) {
            itemStack.decrement(1);
        }
        return TypedActionResult.success(itemStack, world.isClient());
    }
}
