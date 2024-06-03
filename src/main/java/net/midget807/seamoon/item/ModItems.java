package net.midget807.seamoon.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.midget807.seamoon.SeaMoonMain;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModItems {
    public static final Item SEAMOON_BOTTLE = registerItem("seamoon_bottle", new Item(new FabricItemSettings().maxCount(16)));
    public static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, SeaMoonMain.id(name), item);
    }
    public static void registerModItems() {
        SeaMoonMain.LOGGER.info("Registering Sea Moon Items");
    }
}
