package com.ouroboros.plantae.init;

import com.google.common.collect.ImmutableSet;
import com.ouroboros.plantae.Plantae;
import com.ouroboros.plantae.util.PlantaeUtility;

import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@EventBusSubscriber(modid = Plantae.MOD_ID, bus = Bus.MOD)
@ObjectHolder(Plantae.MOD_ID)
public class ModVillagerProfession {
	
	public static final VillagerProfession JEWELLER = null;
	
	@SubscribeEvent
	public static void registerVillagerProfessions(Register<VillagerProfession> event) {
		event.getRegistry().register(PlantaeUtility.villagerProfession(
				"jeweller", ModPointOfInterestType.JEWELLER_WORKBENCH, ImmutableSet.of(), ImmutableSet.of(), null).setRegistryName(Plantae.MOD_ID, "jeweller"));
	}
}
