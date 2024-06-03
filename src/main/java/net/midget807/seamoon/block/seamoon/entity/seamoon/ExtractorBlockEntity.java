package net.midget807.seamoon.block.seamoon.entity.seamoon;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.LootableContainerBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.Generic3x3ContainerScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;

public class ExtractorBlockEntity extends LootableContainerBlockEntity {
    private static final int INVENTORY_SIZE = 9;
    private DefaultedList<ItemStack> inventory;
    protected ExtractorBlockEntity(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
        this.inventory = DefaultedList.ofSize(INVENTORY_SIZE, ItemStack.EMPTY);
    }
    public ExtractorBlockEntity(BlockPos pos, BlockState state) {
        this(BlockEntityType.DISPENSER, pos, state);
    }
    public int chooseNonEmptySlot(Random random) {
        this.checkLootInteraction((PlayerEntity)null);
        int i = -1;
        int j = 1;

        for(int k = 0; k < this.inventory.size(); ++k) {
            if (!((ItemStack)this.inventory.get(k)).isEmpty() && random.nextInt(j++) == 0) {
                i = k;
            }
        }

        return i;
    }

    @Override
    protected DefaultedList<ItemStack> getInvStackList() {
        return this.inventory;
    }

    @Override
    protected void setInvStackList(DefaultedList<ItemStack> list) {
        this.inventory = list;
    }

    @Override
    protected Text getContainerName() {
        return Text.translatable("seamoon:container.extractor");
    }

    @Override
    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return new Generic3x3ContainerScreenHandler(syncId, playerInventory, this);
    }
    public int addToFirstFreeSlot(ItemStack stack) {
        for(int i = 0; i < this.inventory.size(); ++i) {
            if (((ItemStack)this.inventory.get(i)).isEmpty()) {
                this.setStack(i, stack);
                return i;
            }
        }

        return -1;
    }
    @Override
    public int size() {
        return 9;
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        this.inventory = DefaultedList.ofSize(this.size(), ItemStack.EMPTY);
        if (!this.deserializeLootTable(nbt)) {
            Inventories.readNbt(nbt, this.inventory);
        }
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        if (!this.serializeLootTable(nbt)) {
            Inventories.writeNbt(nbt, this.inventory);
        }
    }
}
