package net.midget807.seamoon;

import net.fabricmc.api.ModInitializer;
import net.midget807.seamoon.block.ModBlocks;
import net.midget807.seamoon.block.seamoon.entity.ModBlockEntities;
import net.midget807.seamoon.item.ModItemGroups;
import net.midget807.seamoon.item.ModItems;
import net.midget807.seamoon.network.ModMessages;
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
		ModItemGroups.registerModItemGroups();
		ModMessages.registerC2SPackets();
		LOGGER.info("Hello Fabric world!");
	}
}