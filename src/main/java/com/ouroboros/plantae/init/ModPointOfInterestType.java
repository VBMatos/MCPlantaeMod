package com.ouroboros.plantae.init;

import com.ouroboros.plantae.Plantae;
import com.ouroboros.plantae.util.PlantaeUtility;

import net.minecraft.village.PointOfInterestType;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@EventBusSubscriber(modid = Plantae.MOD_ID, bus = Bus.MOD)
@ObjectHolder(Plantae.MOD_ID)
public class ModPointOfInterestType {
	
	public static final PointOfInterestType JEWELLER_WORKBENCH = null;
	
	@SubscribeEvent
	public static void registerPointOfInterestTypes(Register<PointOfInterestType> event) {
		event.getRegistry().register(PlantaeUtility.pointOfInterestType(
				"jeweller_workbench", PlantaeUtility.getAllStates(BlockInit.jeweller_workbench_block), 1, 1).setRegistryName(Plantae.MOD_ID, "jeweller_workbench"));
	}
}
