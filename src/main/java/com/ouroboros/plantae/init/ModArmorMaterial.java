package com.ouroboros.plantae.init;

import java.util.function.Supplier;

import com.ouroboros.plantae.Plantae;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public enum ModArmorMaterial implements IArmorMaterial{

	ADAMANTIUM(Plantae.MOD_ID + ":adamantium", 8, new int[] {12, 14, 16, 12}, 700, SoundEvents.BLOCK_ANVIL_PLACE, 8.0f,
		() -> { return Ingredient.fromItems(ItemInit.adamantium_ingot); });
	
	private static final int[] MAX_DAMAGE_ARRAY = new int[] {20, 20, 20, 20};
	
	private final String name;
	private final int maxDamageFactor;
	private final int[] arDamageReductionAmount;
	private final int enchatability;
	private final SoundEvent soundEvent;
	private final float toughness;
	private final LazyValue<Ingredient> repairMaterial;
	
	
	private ModArmorMaterial(String name, int maxDamageFactor, int[] arDamageReductionAmount, int enchatability, 
		SoundEvent soundEvent, float toughness, Supplier<Ingredient> repairMaterial) {
		
		this.name = name;
		this.maxDamageFactor = maxDamageFactor;
		this.arDamageReductionAmount = arDamageReductionAmount;
		this.enchatability = enchatability;
		this.soundEvent = soundEvent;
		this.toughness = toughness;
		this.repairMaterial = new LazyValue<Ingredient>(repairMaterial);
	}
	
	@Override
	public int getDurability(EquipmentSlotType slotIn) {
		return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
	}

	@Override
	public int getDamageReductionAmount(EquipmentSlotType slotIn) {
		return this.arDamageReductionAmount[slotIn.getIndex()];
	}

	@Override
	public int getEnchantability() {
		return this.enchatability;
	}

	@Override
	public SoundEvent getSoundEvent() {
		return this.soundEvent;
	}

	@Override
	public Ingredient getRepairMaterial() {
		return this.repairMaterial.getValue();
	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public float getToughness() {
		return this.toughness;
	}
}
