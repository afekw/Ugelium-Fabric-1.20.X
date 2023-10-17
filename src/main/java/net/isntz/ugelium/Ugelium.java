package net.isntz.ugelium;

import net.fabricmc.api.ModInitializer;

import net.isntz.ugelium.block.ModBlocks;
import net.isntz.ugelium.block.entity.ModBlockEntities;
import net.isntz.ugelium.item.ModItem;
import net.isntz.ugelium.item.ModItemGroups;
import net.isntz.ugelium.recipe.ModRecipes;
import net.isntz.ugelium.screen.ModScreenHandlers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Ugelium implements ModInitializer {
	public static final String MOD_ID = "ugelium";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItem.RegisterModItems();
		ModItemGroups.registerItemGroups();
		ModBlocks.RegisterModBlocks();

		ModRecipes.registerRecipes();

		ModBlockEntities.registerBlockEntities();
		ModScreenHandlers.registerScreenHandler();
	}
}