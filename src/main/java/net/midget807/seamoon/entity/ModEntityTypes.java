package net.midget807.seamoon.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.midget807.seamoon.SeaMoonMain;
import net.midget807.seamoon.entity.seamoon.SeaMoonBottleEntity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModEntityTypes {
    public static final EntityType<SeaMoonBottleEntity> SPLASH_SEAMOON_BOTTLE_ENTITY_TYPE = Registry.register(
            Registries.ENTITY_TYPE, SeaMoonMain.id("splash_seamoon_bottle"),
            FabricEntityTypeBuilder.<SeaMoonBottleEntity>create(SpawnGroup.MISC, SeaMoonBottleEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());

}
