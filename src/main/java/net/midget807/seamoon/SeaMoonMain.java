package net.midget807.seamoon;

import net.fabricmc.api.ModInitializer;
import net.midget807.seamoon.block.ModBlocks;
import net.midget807.seamoon.effect.seamoon.potion.ModPotions;
import net.midget807.seamoon.item.ModItemGroups;
import net.midget807.seamoon.item.ModItems;
import net.midget807.seamoon.network.ModMessages;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionUtil;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SeaMoonMain implements ModInitializer {
	public static Identifier id(String path){
		return new Identifier("seamoon", path);
	}
    public static final Logger LOGGER = LoggerFactory.getLogger("seamoon");
	public static final ItemStack SEAMOON_BOTTLE = PotionUtil.setPotion(ModItems.SEAMOON_BOTTLE.getDefaultStack(), ModPotions.AFFECTION);
	public static final ItemStack SPLASH_SEAMOON_BOTTLE = PotionUtil.setPotion(ModItems.SPLASH_SEAMOON_BOTTLE.getDefaultStack(), ModPotions.AFFECTION);
	public static final ItemStack LINGERING_SEAMOON_BOTTLE = PotionUtil.setPotion(ModItems.LINGERING_SEAMOON_BOTTLE.getDefaultStack(), ModPotions.AFFECTION);
	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModItemGroups.registerModItemGroups();
		ModMessages.registerC2SPackets();
		ModPotions.registerModPotionRecipes();
		LOGGER.info("Hello Fabric world!");
	}
}