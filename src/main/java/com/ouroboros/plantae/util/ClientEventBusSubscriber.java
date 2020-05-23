package com.ouroboros.plantae.util;

import com.ouroboros.plantae.Plantae;
import com.ouroboros.plantae.client.entity.render.UnicornEntityRender;
import com.ouroboros.plantae.init.ModEntityType;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid=Plantae.MOD_ID, bus=Bus.MOD, value=Dist.CLIENT)
public class ClientEventBusSubscriber {

	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(ModEntityType.UNICORN_ENTITY.get(), UnicornEntityRender::new);
	}
}
