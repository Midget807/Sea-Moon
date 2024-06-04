package net.midget807.seamoon.block.seamoon.entity.seamoon;

import net.minecraft.block.DispenserBlock;
import net.minecraft.block.dispenser.ShearsDispenserBehavior;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Shearable;
import net.minecraft.item.ItemStack;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPointer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.event.GameEvent;

import java.util.List;

public class BottleDispenserBehavior extends ShearsDispenserBehavior {
    @Override
    protected ItemStack dispenseSilently(BlockPointer pointer, ItemStack stack) {
        ServerWorld serverWorld = pointer.world();
        if (!serverWorld.isClient()) {
            BlockPos blockPos = pointer.pos().offset(pointer.state().get(DispenserBlock.FACING));
            this.setSuccess(BottleDispenserBehavior.tryExtractEntity(serverWorld, blockPos));
            if (this.isSuccess() && stack.damage(1, serverWorld.getRandom(), null)) {
                stack.setCount(0);
            }
        }
        return stack;
    }
    private static boolean tryExtractEntity(ServerWorld world, BlockPos pos) {
        List<LivingEntity> list = world.getEntitiesByClass(LivingEntity.class, new Box(pos), EntityPredicates.EXCEPT_SPECTATOR);
        for (LivingEntity livingEntity : list) {
            Shearable shearable;
            if (!(livingEntity instanceof Shearable) || !(shearable = (Shearable)((Object)livingEntity)).isShearable()) continue;
            shearable.sheared(SoundCategory.BLOCKS);
            world.emitGameEvent(null, GameEvent.SHEAR, pos);
            return true;
        }
        return false;
    }
}
