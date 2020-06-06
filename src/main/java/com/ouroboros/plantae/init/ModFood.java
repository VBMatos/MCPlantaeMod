package com.ouroboros.plantae.init;

import com.ouroboros.plantae.Plantae;

import net.minecraft.item.Food;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid=Plantae.MOD_ID, bus=Bus.MOD)
@ObjectHolder(Plantae.MOD_ID)
public class ModFood{
	
	public static Food STRAWBERRY = (new Food.Builder()).hunger(10).saturation(2f).effect(new EffectInstance(Effects.RESISTANCE, 6000, 5), 0.75f).build();
	public static Food GRAPE = (new Food.Builder()).hunger(10).saturation(2f).effect(new EffectInstance(Effects.REGENERATION, 6000, 5), 0.75f).build();
}