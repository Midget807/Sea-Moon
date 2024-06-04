package net.midget807.seamoon.damage;

import net.midget807.seamoon.SeaMoonMain;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.World;

public class ModDamageTypes {
    public static final RegistryKey<DamageType> SEAMOON_BUCKET_KILL =
            RegistryKey.of(RegistryKeys.DAMAGE_TYPE, SeaMoonMain.id("seamoon_bucket_kill"));

    public static DamageSource of(World world, RegistryKey<DamageType> key) {
        return new DamageSource(world.getRegistryManager().get(RegistryKeys.DAMAGE_TYPE).entryOf(key));
    }
}
