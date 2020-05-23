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
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.network.simple.SimpleChannel;

@Mod("plantae")
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
    	eventBus.addListener(this::setup);
    	eventBus.addListener(this::doClientStuff);
    	
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
    
    public void villagerTrades(VillagerTradesEvent event) {
    	Int2ObjectMap<List<ITrade>> trades = event.getTrades();
    	
    	if(event.getType() == ModVillagerProfession.JEWELLER) {
    		trades.get(1).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 9), new ItemStack(ItemInit.SAPPHIRE, 1), 5, 10, 0f));
    		trades.get(1).add((entity, random) -> new MerchantOffer(new ItemStack(ItemInit.SAPPHIRE, 1), new ItemStack(Items.EMERALD, 8), 5, 10, 0f));
    		
    		trades.get(2).add((entity, random) -> new MerchantOffer(new ItemStack(ItemInit.SAPPHIRE, 9), new ItemStack(ItemInit.RUBY, 1), 5, 10, 0f));
    		trades.get(2).add((entity, random) -> new MerchantOffer(new ItemStack(ItemInit.RUBY, 1), new ItemStack(ItemInit.SAPPHIRE, 8), 5, 10, 0f));
    	
    		trades.get(3).add((entity, random) -> new MerchantOffer(new ItemStack(ItemInit.RUBY, 9), new ItemStack(ItemInit.AMETHYST, 1), 5, 10, 0f));
    		trades.get(3).add((entity, random) -> new MerchantOffer(new ItemStack(ItemInit.AMETHYST, 1), new ItemStack(ItemInit.RUBY, 8), 5, 10, 0f));
    		
    		TradeBuilder.forEachLevel((level, tradeBuild) -> trades.get(level.intValue()).add(tradeBuild.build()));
    	}
	}
}
