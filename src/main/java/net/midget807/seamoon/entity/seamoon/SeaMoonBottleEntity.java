package net.midget807.seamoon.entity.seamoon;

import net.midget807.seamoon.block.ModBlocks;
import net.midget807.seamoon.block.seamoon.SeaMoonSplatterBlock;
import net.midget807.seamoon.effect.ModEffects;
import net.midget807.seamoon.entity.ModEntityTypes;
import net.midget807.seamoon.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.PotionItem;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionUtil;
import net.minecraft.potion.Potions;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SeaMoonBottleEntity extends ThrownItemEntity implements FlyingItemEntity {
    public SeaMoonBottleEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public SeaMoonBottleEntity(double x, double y, double z, World world) {
        super(ModEntityTypes.SPLASH_SEAMOON_BOTTLE_ENTITY_TYPE, x, y, z, world);
    }

    public SeaMoonBottleEntity(LivingEntity owner, World world) {
        super(ModEntityTypes.SPLASH_SEAMOON_BOTTLE_ENTITY_TYPE, owner, world);
    }

    @Override
    public Item getDefaultItem() {
        return ModItems.SPLASH_SEAMOON_BOTTLE;
    }

    @Override
    protected float getGravity() {
        return 0.05f;
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        super.onBlockHit(blockHitResult);
        if (this.getWorld().isClient) {
            return;
        }
        ItemStack itemStack = this.getStack();
        Direction direction = blockHitResult.getSide();
        BlockPos blockPos = blockHitResult.getBlockPos();
        this.getWorld().setBlockState(blockPos, ModBlocks.SEAMOON_SPLATTER.getDefaultState());
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        boolean bl;
        super.onCollision(hitResult);
        if (this.getWorld().isClient) {
            return;
        }
        ItemStack itemStack = this.getStack();
        Potion potion = Potions.SLOW_FALLING;
        if (this.isLingering()) {
            this.applyLingeringPotion(itemStack, potion);
        } else {
            this.applySplashPotion((List<StatusEffectInstance>) ModEffects.AFFECTIONATE, hitResult.getType() == HitResult.Type.ENTITY ? ((EntityHitResult) hitResult).getEntity() : null);
        }
        int i = potion.hasInstantEffect() ? WorldEvents.INSTANT_SPLASH_POTION_SPLASHED : WorldEvents.SPLASH_POTION_SPLASHED;
        this.getWorld().syncWorldEvent(i, this.getBlockPos(), PotionUtil.getColor(itemStack));
    }

    private void applySplashPotion(List<StatusEffectInstance> statusEffects, @Nullable Entity entity) {
        Box box = this.getBoundingBox().expand(4.0, 2.0, 4.0);
        List<LivingEntity> list = this.getWorld().getNonSpectatingEntities(LivingEntity.class, box);
        if (!list.isEmpty()) {
            Entity entity2 = this.getEffectCause();
            for (LivingEntity livingEntity : list) {
                double d;
                if (!livingEntity.isAffectedBySplashPotions() || !((d = this.squaredDistanceTo(livingEntity)) < 16.0)) continue;
                double e = livingEntity == entity ? 1.0 : 1.0 - Math.sqrt(d) / 4;
                for (StatusEffectInstance statusEffectInstance : statusEffects) {
                    StatusEffect statusEffect = ModEffects.AFFECTIONATE;
                    if (statusEffect.isInstant()) {
                        statusEffect.applyInstantEffect(this, this.getOwner(), livingEntity, statusEffectInstance.getAmplifier(), e);
                        continue;
                    }
                    int i2 = statusEffectInstance.mapDuration(i -> (int) (e * (double) i + 0.5));
                    StatusEffectInstance statusEffectInstance2 = new StatusEffectInstance(statusEffect);
                    if (statusEffectInstance2.isDurationBelow(20)) continue;
                    livingEntity.addStatusEffect(statusEffectInstance2, entity2);
                }
            }
        }
    }

    private void applyLingeringPotion(ItemStack itemStack, Potion potion) {
        AreaEffectCloudEntity areaEffectCloudEntity = new AreaEffectCloudEntity(this.getWorld(), this.getX(), this.getY(), this.getZ());
        Entity entity = this.getOwner();
        if (entity instanceof LivingEntity) {
            areaEffectCloudEntity.setOwner((LivingEntity) entity);
        }
        areaEffectCloudEntity.setRadius(3.0f);
        areaEffectCloudEntity.setRadiusOnUse(-0.5f);
        areaEffectCloudEntity.setWaitTime(10);
        areaEffectCloudEntity.setPotion(potion);
        areaEffectCloudEntity.setRadiusGrowth(-areaEffectCloudEntity.getRadius() / (float)areaEffectCloudEntity.getDuration());
        areaEffectCloudEntity.addEffect(new StatusEffectInstance(ModEffects.AFFECTIONATE, 10, 0));
    }

    private boolean isLingering() {
        return this.getStack().isOf(ModItems.LINGERING_SEAMOON_BOTTLE);
    }
}
