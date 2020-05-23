package com.ouroboros.plantae.init;

import com.ouroboros.plantae.Plantae;
import com.ouroboros.plantae.objects.blocks.JewellerWorkbench;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid=Plantae.MOD_ID, bus=Bus.MOD)
@ObjectHolder(Plantae.MOD_ID)
public class BlockInit {
	
	//Gemstones
	public static final Block RUBY_BLOCK = null;
	public static final Block SAPPHIRE_BLOCK = null;
	public static final Block AMETHYST_BLOCK = null;

	//Metals
	public static final Block ADAMANTIUM_BLOCK = null;
	public static final Block METEORIC_STONE = null;
	public static final Block VIBRANIUM_ORE = null;
	
	//Custom block model
	public static final Block JEWELLER_WORKBENCH_BLOCK = null;
	
	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event) {
		//Gemstones
		event.getRegistry().register(
				new Block(Block.Properties.create(Material.IRON)
						.hardnessAndResistance(5.0F, 6.0F).harvestLevel(2).harvestTool(ToolType.PICKAXE).sound(SoundType.METAL)).setRegistryName("ruby_block"));

		event.getRegistry().register(
				new Block(Block.Properties.create(Material.IRON)
						.hardnessAndResistance(5.0F, 6.0F).harvestLevel(2).harvestTool(ToolType.PICKAXE).sound(SoundType.METAL)).setRegistryName("sapphire_block"));
		
		event.getRegistry().register(
				new Block(Block.Properties.create(Material.IRON)
						.hardnessAndResistance(5.0F, 6.0F).harvestLevel(2).harvestTool(ToolType.PICKAXE).sound(SoundType.METAL)).setRegistryName("amethyst_block"));

		//Metals
		event.getRegistry().register(
				new Block(Block.Properties.create(Material.IRON)
						.hardnessAndResistance(7.0F, 6.0F).harvestLevel(4).harvestTool(ToolType.PICKAXE).sound(SoundType.METAL)).setRegistryName("adamantium_block"));
		
		event.getRegistry().register(
				new Block(Block.Properties.create(Material.IRON)
						.hardnessAndResistance(7.0F, 6.0F).harvestLevel(4).harvestTool(ToolType.PICKAXE).sound(SoundType.METAL)).setRegistryName("meteoric_stone"));
		
		event.getRegistry().register(
				new Block(Block.Properties.create(Material.IRON)
						.hardnessAndResistance(7.0F, 6.0F).harvestLevel(4).harvestTool(ToolType.PICKAXE).sound(SoundType.METAL)).setRegistryName("vibranium_ore"));
		
		//Custom block model
		event.getRegistry().register(
				new JewellerWorkbench(Block.Properties.create(Material.WOOD)
						.hardnessAndResistance(5.0F, 6.0F).harvestLevel(1).harvestTool(ToolType.AXE).sound(SoundType.WOOD)).setRegistryName("jeweller_workbench_block"));
	}

	@SubscribeEvent
	public static void registerBlockItems(final RegistryEvent.Register<Item> event) {
		//Gemstones
		event.getRegistry().register(new BlockItem(RUBY_BLOCK, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName("ruby_block"));
		event.getRegistry().register(new BlockItem(SAPPHIRE_BLOCK, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName("sapphire_block"));
		event.getRegistry().register(new BlockItem(AMETHYST_BLOCK, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName("amethyst_block"));
		
		//Metals
		event.getRegistry().register(new BlockItem(ADAMANTIUM_BLOCK, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName("adamantium_block"));
		event.getRegistry().register(new BlockItem(METEORIC_STONE, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName("meteoric_stone"));
		event.getRegistry().register(new BlockItem(VIBRANIUM_ORE, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName("vibranium_ore"));
		
		//Custom block models
		event.getRegistry().register(new BlockItem(JEWELLER_WORKBENCH_BLOCK, new Item.Properties().group(ItemGroup.DECORATIONS)).setRegistryName("jeweller_workbench_block"));
	}
}
