package com.ouroboros.plantae.init;

import com.ouroboros.plantae.Plantae;
import com.ouroboros.plantae.objects.blocks.JewellerWorkbench;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
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
	public static final Block ruby_block = null;
	public static final Block sapphire_block = null;
	public static final Block amethyst_block = null;

	//Metals
	public static final Block adamantium_block = null;
	public static final Block meteoric_stone = null;
	public static final Block vibranium_ore = null;
	public static final Block vibranium_block = null;
	
	//Custom block model
	public static final Block jeweller_workbench_block = null;
	
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
						.hardnessAndResistance(45.0F, 1500.0F).harvestLevel(4).harvestTool(ToolType.PICKAXE).sound(SoundType.METAL)).setRegistryName("adamantium_block"));
		
		event.getRegistry().register(
				new Block(Block.Properties.create(Material.IRON)
						.hardnessAndResistance(35.0F, 1500.0F).harvestLevel(3).harvestTool(ToolType.PICKAXE).sound(SoundType.METAL)).setRegistryName("meteoric_stone"));
		
		event.getRegistry().register(
				new Block(Block.Properties.create(Material.IRON)
						.hardnessAndResistance(35.0F, 1500.0F).harvestLevel(3).harvestTool(ToolType.PICKAXE).sound(SoundType.METAL)).setRegistryName("vibranium_ore"));
		
		event.getRegistry().register(
				new Block(Block.Properties.create(Material.IRON)
						.hardnessAndResistance(30.0F, 1500.0F).harvestLevel(3).harvestTool(ToolType.PICKAXE).sound(SoundType.METAL)).setRegistryName("vibranium_block"));
		
		//Custom block model
		event.getRegistry().register(
				new JewellerWorkbench(Block.Properties.create(Material.WOOD)
						.hardnessAndResistance(5.0F, 6.0F).harvestLevel(1).harvestTool(ToolType.AXE).sound(SoundType.WOOD)).setRegistryName("jeweller_workbench_block"));
	}

	@SubscribeEvent
	public static void registerBlockItems(final RegistryEvent.Register<Item> event) {
		final ModItemGroup PLANTAE_GROUP = ModItemGroup.PLANTAE_GROUP;
		
		//Gemstones
		event.getRegistry().register(new BlockItem(ruby_block, new Item.Properties().group(PLANTAE_GROUP)).setRegistryName("ruby_block"));
		event.getRegistry().register(new BlockItem(sapphire_block, new Item.Properties().group(PLANTAE_GROUP)).setRegistryName("sapphire_block"));
		event.getRegistry().register(new BlockItem(amethyst_block, new Item.Properties().group(PLANTAE_GROUP)).setRegistryName("amethyst_block"));
		
		//Metals
		event.getRegistry().register(new BlockItem(adamantium_block, new Item.Properties().group(PLANTAE_GROUP)).setRegistryName("adamantium_block"));
		event.getRegistry().register(new BlockItem(meteoric_stone, new Item.Properties().group(PLANTAE_GROUP)).setRegistryName("meteoric_stone"));
		event.getRegistry().register(new BlockItem(vibranium_ore, new Item.Properties().group(PLANTAE_GROUP)).setRegistryName("vibranium_ore"));
		event.getRegistry().register(new BlockItem(vibranium_block, new Item.Properties().group(PLANTAE_GROUP)).setRegistryName("vibranium_block"));
		
		//Custom block models
		event.getRegistry().register(new BlockItem(jeweller_workbench_block, new Item.Properties().group(PLANTAE_GROUP)).setRegistryName("jeweller_workbench_block"));
	}
}
