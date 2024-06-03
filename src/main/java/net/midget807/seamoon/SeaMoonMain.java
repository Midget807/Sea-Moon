package net.midget807.seamoon;

import net.fabricmc.api.ModInitializer;
import net.midget807.seamoon.block.ModBlocks;
import net.midget807.seamoon.block.seamoon.entity.ModBlockEntities;
import net.midget807.seamoon.item.ModItems;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SeaMoonMain implements ModInitializer {
	public static Identifier id(String path){
		return new Identifier("seamoon", path);
	}
    public static final Logger LOGGER = LoggerFactory.getLogger("seamoon");

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModBlockEntities.registerModBlockEntities();
		LOGGER.info("Hello Fabric world!");
	}
}