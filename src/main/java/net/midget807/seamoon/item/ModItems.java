package net.midget807.seamoon.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.midget807.seamoon.SeaMoonMain;
import net.midget807.seamoon.block.seamoon.ModFluids;
import net.midget807.seamoon.item.seamoon.ModFoodComponents;
import net.midget807.seamoon.item.seamoon.SeaMoonBucket;
import net.minecraft.item.BucketItem;
import net.minecraft.item.GlassBottleItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModItems {
    public static final Item SEAMOON_BUCKET = registerItem("seamoon_bucket", new SeaMoonBucket(ModFluids.SEAMOON_FLUID, new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1)));
    public static final Item SEAMOON_BOTTLE = registerItem("seamoon_bottle", new Item(new FabricItemSettings().maxCount(16).food(ModFoodComponents.SEAMOON)));
    public static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, SeaMoonMain.id(name), item);
    }
    public static void registerModItems() {
        SeaMoonMain.LOGGER.info("Registering Sea Moon Items");
    }
}
