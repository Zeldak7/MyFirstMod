package net.zeldak7.myfirstmod;

import net.fabricmc.api.ModInitializer;

import net.zeldak7.myfirstmod.item.ModItemGroups;
import net.zeldak7.myfirstmod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyFirstMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID="myfirstmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();

	}
}