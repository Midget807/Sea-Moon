package net.midget807.seamoon.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.midget807.seamoon.block.ModBlocks;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.SEAMOON_BLOCK);
        addDrop(ModBlocks.SEAMOON_STAIR);
        addDrop(ModBlocks.SEAMOON_FENCE);
        addDrop(ModBlocks.SEAMOON_FENCE_GATE);
        addDrop(ModBlocks.SEAMOON_WALL);
        addDrop(ModBlocks.SEAMOON_BUTTON);
        addDrop(ModBlocks.SEAMOON_PRESSURE_PLATE);
        addDrop(ModBlocks.SEAMOON_TRAPDOOR);
        addDrop(ModBlocks.SEAMOON_DOOR, doorDrops(ModBlocks.SEAMOON_DOOR));
        addDrop(ModBlocks.SEAMOON_SLAB, slabDrops(ModBlocks.SEAMOON_SLAB));
    }
}
