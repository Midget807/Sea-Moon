package net.midget807.seamoon.mixin.server;

import net.midget807.seamoon.effect.ModEffects;
import net.midget807.seamoon.item.ModItems;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MobEntity.class)
public class MobEntityMixin {

    @Unique
    private static double affectionStat;
    @Inject(method = "interactMob", at = @At(value = "HEAD"), cancellable = true)
    public void incrementAffectionStat(PlayerEntity player, Hand hand, CallbackInfoReturnable<ActionResult> cir) {
        if (player.isSneaking()) {
            World world = player.getWorld();
            ItemStack stack = player.getStackInHand(hand);
            if (affectionStat < 20.0 && !world.isClient && stack.isEmpty()) {
                affectionStat = affectionStat + 1;

            }
            if (!world.isClient) {
                if ((affectionStat >= 20.0 && !player.hasStatusEffect(ModEffects.AFFECTIONATE)) || (affectionStat >= 10 && player.hasStatusEffect(ModEffects.AFFECTIONATE))) {
                    world.addParticle(ParticleTypes.HEART, player.getParticleX(1.0), player.getRandomBodyY() + 1, player.getParticleZ(1.0), 0.5, 0.5, 0.5);
                }
                if (affectionStat >= 20.0 && !player.hasStatusEffect(ModEffects.AFFECTIONATE) && stack.isOf(Items.GLASS_BOTTLE)) {
                    affectionStat = 0;
                    if (!player.isCreative()) {
                        stack.decrement(1);
                    }
                    ItemEntity itemEntity = new ItemEntity(world, player.getX(), player.getY(), player.getZ(), new ItemStack(ModItems.SEAMOON_BOTTLE));
                    world.spawnEntity(itemEntity);
                } else if (affectionStat >= 10.0 && player.hasStatusEffect(ModEffects.AFFECTIONATE) && stack.isOf(Items.GLASS_BOTTLE)) {
                    affectionStat = 0;
                    if (!player.isCreative()) {
                        stack.decrement(1);
                    }
                    ItemEntity itemEntity = new ItemEntity(world, player.getX(), player.getY(), player.getZ(), new ItemStack(ModItems.SEAMOON_BOTTLE));
                    world.spawnEntity(itemEntity);
                }
            }
            cir.setReturnValue(ActionResult.PASS);
        }
    }

}
