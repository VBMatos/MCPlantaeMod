package com.ouroboros.plantae;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ouroboros.plantae.init.ItemInit;
import com.ouroboros.plantae.init.ModEntityType;
import com.ouroboros.plantae.init.ModPointOfInterestType;
import com.ouroboros.plantae.init.ModVillagerProfession;
import com.ouroboros.plantae.util.PlantaeUtility;
import com.ouroboros.plantae.util.TradeBuilder;
import com.ouroboros.plantae.world.gen.ModOreGen;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.entity.merchant.villager.VillagerTrades.ITrade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.MerchantOffer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.network.simple.SimpleChannel;

@Mod("plantae")
@Mod.EventBusSubscriber(modid=Plantae.MOD_ID, bus=Bus.MOD)
public class Plantae {
	
	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MOD_ID = "plantae";
	
	public static Plantae instance;
    public static SimpleChannel channel;
	
    public Plantae() {
    	Plantae.instance = this;
    	
    	final IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
    	eventBus.addListener(this::init);
    	eventBus.addListener(this::villagerTrades);
    	eventBus.addListener(this::loadCompleteEvent);
    	eventBus.addListener(this::setup);
    	eventBus.addListener(this::doClientStuff);

    	LOGGER.trace("Debug:" + eventBus);
    	
        MinecraftForge.EVENT_BUS.register(this);
        ModEntityType.ENTITY_TYPES.register(eventBus);
    }
    
    public void init(FMLCommonSetupEvent event) {
    	PlantaeUtility.fixPOITypeBlockStates(ModPointOfInterestType.JEWELLER_WORKBENCH);
    }
    
    private void setup(final FMLCommonSetupEvent event){
        
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        
    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
    	
    }

    @SubscribeEvent
    public void loadCompleteEvent(FMLLoadCompleteEvent event) {
    	ModOreGen.generateOre();
	}
    
    @SubscribeEvent
    public void villagerTrades(VillagerTradesEvent event) {
    	Int2ObjectMap<List<ITrade>> trades = event.getTrades();
    	
    	if(event.getType() == ModVillagerProfession.JEWELLER) {
    		trades.get(1).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 8), new ItemStack(ItemInit.sapphire_item, 1), 8, 10, 0f));
    		trades.get(1).add((entity, random) -> new MerchantOffer(new ItemStack(Items.IRON_NUGGET, 15), new ItemStack(Items.EMERALD, 1), 16, 10, 0f));
    		trades.get(1).add((entity, random) -> new MerchantOffer(new ItemStack(ItemInit.sapphire_item, 1), new ItemStack(Items.EMERALD, 7), 8, 10, 0f));
    		
    		trades.get(2).add((entity, random) -> new MerchantOffer(new ItemStack(ItemInit.sapphire_item, 8), new ItemStack(ItemInit.ruby_item, 1), 8, 10, 0f));
    		trades.get(2).add((entity, random) -> new MerchantOffer(new ItemStack(Items.GOLD_NUGGET, 15), new ItemStack(ItemInit.sapphire_item, 1), 16, 10, 0f));
    		trades.get(2).add((entity, random) -> new MerchantOffer(new ItemStack(ItemInit.ruby_item, 1), new ItemStack(ItemInit.sapphire_item, 7), 8, 10, 0f));
    	
    		trades.get(3).add((entity, random) -> new MerchantOffer(new ItemStack(ItemInit.ruby_item, 8), new ItemStack(ItemInit.amethyst_item, 1), 8, 10, 0f));
    		trades.get(3).add((entity, random) -> new MerchantOffer(new ItemStack(Items.LAPIS_LAZULI, 15), new ItemStack(ItemInit.ruby_item, 1), 16, 10, 0f));
    		trades.get(3).add((entity, random) -> new MerchantOffer(new ItemStack(ItemInit.amethyst_item, 1), new ItemStack(ItemInit.ruby_item, 7), 8, 10, 0f));

    		trades.get(4).add((entity, random) -> new MerchantOffer(new ItemStack(ItemInit.amethyst_item, 2), new ItemStack(ItemInit.strawberry, 5), 8, 10, 0f));
    		
    		TradeBuilder.forEachLevel((level, tradeBuild) -> trades.get(level.intValue()).add(tradeBuild.build()));
    	}
	}
}
