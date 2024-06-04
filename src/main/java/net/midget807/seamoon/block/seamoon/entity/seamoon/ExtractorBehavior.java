package net.midget807.seamoon.block.seamoon.entity.seamoon;

import com.mojang.logging.LogUtils;
import net.midget807.seamoon.block.seamoon.ExtractorBlock;
import net.minecraft.block.dispenser.DispenserBehavior;
import net.minecraft.item.Items;
import org.slf4j.Logger;

public interface ExtractorBehavior {
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final DispenserBehavior NOOP = (pointer, stack) -> stack;

    public static void registerDefaults() {
        ExtractorBlock.registerBehavior(Items.GLASS_BOTTLE.asItem(), new BottleDispenserBehavior());
    }
}
