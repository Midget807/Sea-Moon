package net.midget807.seamoon.entity;

import net.midget807.seamoon.entity.seamoon.SeaMoonBottleEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.resource.featuretoggle.ToggleableFeature;
import net.minecraft.util.TypeFilter;
import org.jetbrains.annotations.Nullable;

public class ModEntityTypes<T extends Entity> implements ToggleableFeature, TypeFilter<Entity, T> {
    public static final EntityType<SeaMoonBottleEntity> SEA_MOON_BOTTLE_ENTITY_TYPE = registerEntityType("seamoon_bottle", EntityType.Builder.create(SeaMoonBottleEntity::new, SpawnGroup.MISC).setDimensions(0.25f, 0.25f).maxTrackingRange(4).trackingTickInterval(10));
    private static <T extends Entity>EntityType<T> registerEntityType(String name, EntityType.Builder<T> type) {
        return Registry.register(Registries.ENTITY_TYPE, name, type.build(name));
    }

    @Override
    public FeatureSet getRequiredFeatures() {
        return null;
    }

    @Nullable
    @Override
    public T downcast(Entity obj) {
        return null;
    }

    @Override
    public Class<? extends Entity> getBaseClass() {
        return null;
    }
}
