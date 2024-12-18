package net.remclean.oregalore;

import net.fabricmc.api.ModInitializer;

import net.remclean.oregalore.block.ModBlocks;
import net.remclean.oregalore.item.ModItemGroups;
import net.remclean.oregalore.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OreGalore implements ModInitializer {
	public static final String MOD_ID = "oregalore";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
		ModBlocks.registerModBlocks();
	}
}