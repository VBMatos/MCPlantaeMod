package com.ouroboros.plantae.init;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup extends ItemGroup{

	public static final ModItemGroup PLANTAE_GROUP = new ModItemGroup(ItemGroup.GROUPS.length, "plantae_tab");
	
	private ModItemGroup(int index, String label) {
		super(index, label);
	}

	@Override
	public ItemStack createIcon() {
		return new ItemStack(BlockInit.jeweller_workbench_block);
	}
}
