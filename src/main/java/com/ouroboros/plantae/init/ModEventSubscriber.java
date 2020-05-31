package com.ouroboros.plantae.init;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ouroboros.plantae.Plantae;

import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.config.ModConfig;

/**
 * Subscribe to events from the MOD EventBus that should be handled on both PHYSICAL sides in this class
 *
 * @author Cadiboo
 */
@EventBusSubscriber(modid = Plantae.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public final class ModEventSubscriber {

	private static final Logger LOGGER = LogManager.getLogger(Plantae.MOD_ID + " Mod Event Subscriber");

	/**
	 * This method will be called by Forge when it is time for the mod to register its Items.
	 * This method will always be called after the Block registry method.
	 */
	@SubscribeEvent
	public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
		//final IForgeRegistry<Item> registry = event.getRegistry();
	}

	/**
	 * This method will be called by Forge when a config changes.
	 */
	@SubscribeEvent
	public static void onModConfigEvent(final ModConfig.ModConfigEvent event) {
		//final ModConfig config = event.getConfig();
	}

	/**
	 * Exists to work around a limitation with Spawn Eggs:
	 * Spawn Eggs require an EntityType, but EntityTypes are created AFTER Items.
	 * Therefore it is "impossible" for modded spawn eggs to exist.
	 * To get around this we have our own custom SpawnEggItem, but it needs
	 * some extra setup after Item and EntityType registration completes.
	 */
	@SubscribeEvent(priority = EventPriority.LOWEST)
	public static void onPostRegisterEntities(final RegistryEvent.Register<EntityType<?>> event) {
		ModSpawnEggItem.initUnaddedEggs();
	}
}