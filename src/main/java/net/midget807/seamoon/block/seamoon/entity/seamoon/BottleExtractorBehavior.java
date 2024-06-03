package net.midget807.seamoon.block.seamoon.entity.seamoon;

import net.midget807.seamoon.block.seamoon.ExtractorBlock;
import net.midget807.seamoon.event.ModEvents;
import net.midget807.seamoon.util.Extractable;
import net.minecraft.block.dispenser.FallibleItemDispenserBehavior;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPointer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;

import java.util.Iterator;
import java.util.List;

public class BottleExtractorBehavior extends FallibleItemDispenserBehavior {
    public BottleExtractorBehavior() {}

    @Override
    protected ItemStack dispenseSilently(BlockPointer pointer, ItemStack stack) {
        ServerWorld serverWorld = pointer.world();
        if (!serverWorld.isClient()) {
            BlockPos blockPos = pointer.pos().offset(pointer.state().get(ExtractorBlock.FACING));
            this.setSuccess(tryExtractEntity(serverWorld, blockPos));
            if (this.isSuccess() && stack.damage(1, serverWorld.getRandom(), (ServerPlayerEntity) null)) {
                stack.setCount(0);
            }
        }
        return stack;
    }

    private boolean tryExtractEntity(ServerWorld serverWorld, BlockPos blockPos) {
        List<LivingEntity> list = serverWorld.getEntitiesByClass(LivingEntity.class, new Box(blockPos), EntityPredicates.EXCEPT_SPECTATOR);
        Iterator var3 = list.iterator();
        while (var3.hasNext()) {
            LivingEntity livingEntity = ((LivingEntity) var3.next());
            if (livingEntity instanceof Extractable extractable) {
                if (extractable.isExtractable()) {
                    extractable.extracted(SoundCategory.BLOCKS);
                    serverWorld.emitGameEvent(((Entity) null), ModEvents.EXTRACT, blockPos);
                    return true;
                }
            }
        }
        return false;
    }
}
