package net.midget807.seamoon.block.seamoon;

import com.mojang.logging.LogUtils;
import net.midget807.seamoon.block.seamoon.entity.ExtractorBehavior;
import net.midget807.seamoon.block.seamoon.entity.seamoon.ExtractorBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.dispenser.DispenserBehavior;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.math.BlockPointer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.event.GameEvent;
import org.slf4j.Logger;

import java.util.Map;

public class ExtractorBlock extends DispenserBlock {

    private static final Logger LOGGER = LogUtils.getLogger();
    public static DirectionProperty FACING;
    public static BooleanProperty TRIGGERED;
    private static Map<Item, DispenserBehavior> BEHAVIORS;
    private static final int SCHEDULED_TICK_DELAY = 4;

    public ExtractorBlock(Settings settings) {
        super(settings);
    }
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new ExtractorBlockEntity(pos, state);
    }

    @Override
    protected void dispense(ServerWorld world, BlockState state, BlockPos pos) {
        ExtractorBlockEntity extractorBlockEntity = (ExtractorBlockEntity) world.getBlockEntity(pos, BlockEntityType.DISPENSER).orElse((Object)null);
        if (extractorBlockEntity == null) {
            LOGGER.warn("Ignoring dispensing attempt for Dispenser without matching block entity at {}", pos);
        } else {
            BlockPointer blockPointer = new BlockPointer(world, pos, state, dispenserBlockEntity);
            int i = dispenserBlockEntity.chooseNonEmptySlot(world.random);
            if (i < 0) {
                world.syncWorldEvent(1001, pos, 0);
                world.emitGameEvent(GameEvent.BLOCK_ACTIVATE, pos, GameEvent.Emitter.of(dispenserBlockEntity.getCachedState()));
            } else {
                ItemStack itemStack = dispenserBlockEntity.getStack(i);
                DispenserBehavior dispenserBehavior = this.getBehaviorForItem(itemStack);
                if (dispenserBehavior != DispenserBehavior.NOOP) {
                    dispenserBlockEntity.setStack(i, dispenserBehavior.dispense(blockPointer, itemStack));
                }

            }
        }
    }
}
