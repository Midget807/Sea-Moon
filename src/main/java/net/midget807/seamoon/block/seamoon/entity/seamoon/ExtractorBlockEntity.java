package net.midget807.seamoon.block.seamoon.entity.seamoon;

import net.midget807.seamoon.block.seamoon.entity.ModBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.DispenserBlockEntity;
import net.minecraft.block.entity.LootableContainerBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.Generic3x3ContainerScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;

public class ExtractorBlockEntity extends DispenserBlockEntity {
    private DefaultedList<ItemStack> inventory = DefaultedList.ofSize(9, ItemStack.EMPTY);
    protected ExtractorBlockEntity(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
    }

    public ExtractorBlockEntity(BlockPos pos, BlockState state) {
        this(ModBlockEntities.EXTRACTOR_BLOCK_ENTITY_TYPE, pos, state);
    }

    @Override
    protected Text getContainerName() {
        return Text.translatable("container.seamoon.extractor");

    }

    @Override
    public int chooseNonEmptySlot(Random random) {
        this.checkLootInteraction(null);
        int i = -1;
        int j = 1;
        for (int k = 0; k < this.inventory.size(); ++k) {
            if (this.inventory.get(k).isEmpty() || random.nextInt(j++) != 0) continue;
            i = k;
        }
        return i;
    }

    @Override
    public int addToFirstFreeSlot(ItemStack stack) {
        for (int i = 0; i < this.inventory.size(); ++i) {
            if (!this.inventory.get(i).isEmpty()) continue;
            this.setStack(i, stack);
            return i;
        }
        return -1;
    }

}
