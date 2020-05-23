package com.ouroboros.plantae.init;

import com.ouroboros.plantae.Plantae;
import com.ouroboros.plantae.enums.ModItemTier;

import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
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
	public static final Item RUBY = null;
	public static final Item SAPPHIRE = null;
	public static final Item AMETHYST = null;
	
	//Other
	public static final Item CARBON_DUST = null;
	public static final Item CRUMB_RESIN = null;
	
	//Ingots
	public static final Item STEEL_INGOT = null;
	public static final Item ADAMANTIUM_INGOT = null;
	public static final Item VIBRANIUM_ALLOY_INGOT = null;
	public static final Item VIBRANIUM_INGOT = null;

	//Adamantium Tools
	public static final Item ADAMANTIUM_SHOVEL = null;
	public static final Item ADAMANTIUM_PICKAXE = null;
	public static final Item ADAMANTIUM_AXE = null;
	public static final Item ADAMANTIUM_SWORD = null;
	
	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event) {
		//Gemstones
		event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName("ruby_item"));
		event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName("sapphire_item"));
		event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName("amethyst_item"));
		
		//Other
		event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName("carbon_dust"));
		event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName("crumb_resin"));
		
		//Ingots
		event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName("steel_ingot"));
		event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName("adamantium_ingot"));
		event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName("vibranium_alloy_ingot"));
		event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName("vibranium_ingot"));
		
		//Adamantium Tools
		event.getRegistry().register(new SwordItem(ModItemTier.ADAMANTIUM_TOOL, 7, 5.0f, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("adamantium_sword"));
		event.getRegistry().register(new PickaxeItem(ModItemTier.ADAMANTIUM_TOOL, 4, 5.0f, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("adamantium_pickaxe"));
		event.getRegistry().register(new ShovelItem(ModItemTier.ADAMANTIUM_TOOL, 2, 5.0f, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("adamantium_shovel"));
		event.getRegistry().register(new AxeItem(ModItemTier.ADAMANTIUM_TOOL, 11, 3.0f, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("adamantium_axe"));
	}
}






