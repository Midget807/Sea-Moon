package net.midget807.seamoon.block.seamoon.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.midget807.seamoon.SeaMoonMain;
import net.midget807.seamoon.block.ModBlocks;
import net.midget807.seamoon.block.seamoon.entity.seamoon.ExtractorBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModBlockEntities {
    public static final BlockEntityType<ExtractorBlockEntity> EXTRACTOR_BLOCK_ENTITY_TYPE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, SeaMoonMain.id("extractor_block_entity"),
                    FabricBlockEntityTypeBuilder.create(ExtractorBlockEntity::new,
                            ModBlocks.EXTRACTOR).build());

    public static void registerModBlockEntities() {
        SeaMoonMain.LOGGER.info("Registering Sea Moon Block Entities");
    }

}
