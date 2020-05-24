package com.ouroboros.plantae.init;

import com.ouroboros.plantae.Plantae;
import com.ouroboros.plantae.enums.ModItemTier;

import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid=Plantae.MOD_ID, bus=Bus.MOD)
@ObjectHolder(Plantae.MOD_ID)
public class ItemInit {
	
	//Gemstones
	public static final Item ruby_item = null;
	public static final Item sapphire_item = null;
	public static final Item amethyst_item = null;
	
	//Other
	public static final Item carbon_dust = null;
	public static final Item crumb_resin = null;
	
	//Ingots
	public static final Item steel_ingot = null;
	public static final Item adamantium_ingot = null;
	public static final Item vibranium_alloy_ingot = null;
	public static final Item vibranium_ingot = null;

	//Adamantium Tools
	public static final Item adamantium_sword = null;
	public static final Item adamantium_pickaxe = null;
	public static final Item adamantium_shovel = null;
	public static final Item adamantium_axe = null;
	
	//Food
	public static final Item strawberry = null;
	
	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event) {
		final ModItemGroup PLANTAE_GROUP = ModItemGroup.PLANTAE_GROUP;
		
		//Gemstones
		event.getRegistry().register(new Item(new Item.Properties().group(PLANTAE_GROUP)).setRegistryName("ruby_item"));
		event.getRegistry().register(new Item(new Item.Properties().group(PLANTAE_GROUP)).setRegistryName("sapphire_item"));
		event.getRegistry().register(new Item(new Item.Properties().group(PLANTAE_GROUP)).setRegistryName("amethyst_item"));
		
		//Other
		event.getRegistry().register(new Item(new Item.Properties().group(PLANTAE_GROUP)).setRegistryName("carbon_dust"));
		event.getRegistry().register(new Item(new Item.Properties().group(PLANTAE_GROUP)).setRegistryName("crumb_resin"));
		
		//Ingots
		event.getRegistry().register(new Item(new Item.Properties().group(PLANTAE_GROUP)).setRegistryName("steel_ingot"));
		event.getRegistry().register(new Item(new Item.Properties().group(PLANTAE_GROUP)).setRegistryName("adamantium_ingot"));
		event.getRegistry().register(new Item(new Item.Properties().group(PLANTAE_GROUP)).setRegistryName("vibranium_alloy_ingot"));
		event.getRegistry().register(new Item(new Item.Properties().group(PLANTAE_GROUP)).setRegistryName("vibranium_ingot"));
		
		//Adamantium Tools
		event.getRegistry().register(new SwordItem(ModItemTier.ADAMANTIUM_TOOL, 7, 5.0f, new Item.Properties().group(PLANTAE_GROUP)).setRegistryName("adamantium_sword"));
		event.getRegistry().register(new PickaxeItem(ModItemTier.ADAMANTIUM_TOOL, 4, 5.0f, new Item.Properties().group(PLANTAE_GROUP)).setRegistryName("adamantium_pickaxe"));
		event.getRegistry().register(new ShovelItem(ModItemTier.ADAMANTIUM_TOOL, 2, 5.0f, new Item.Properties().group(PLANTAE_GROUP)).setRegistryName("adamantium_shovel"));
		event.getRegistry().register(new AxeItem(ModItemTier.ADAMANTIUM_TOOL, 11, 3.0f, new Item.Properties().group(PLANTAE_GROUP)).setRegistryName("adamantium_axe"));
		
		//Food
		event.getRegistry().register(new Item(new Item.Properties().group(PLANTAE_GROUP).food(ModFood.strawberry)).setRegistryName("strawberry"));
	}
}






