package com.ouroboros.plantae.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

import net.minecraft.entity.merchant.villager.VillagerTrades.ITrade;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.MerchantOffer;

public class TradeBuilder
{
    //Trades Levels
    private static final List<List<TradeBuilder>> TRADES_LIST = new ArrayList<>();
    
    static {
        for(int i = 0; i <= 6; ++i) {
            TradeBuilder.TRADES_LIST.add(new ArrayList<TradeBuilder>());
        }
    }
    
    private static List<TradeBuilder> getList(int i) {
        return TradeBuilder.TRADES_LIST.get(i);
    }
    
    private static void register(int i, TradeBuilder tradeBuilder) {
        TradeBuilder.getList(i).add(tradeBuilder);
    }
    
    public static void forEachLevel(BiConsumer<Integer, TradeBuilder> consumer) {
        List<TradeBuilder> list;
        
        for(int i = 1; i <= 5; ++i) {
            list = TradeBuilder.TRADES_LIST.get(i - 1);
            
            for(TradeBuilder tradeBuilder : list) {
                consumer.accept(i, tradeBuilder);
            }
        }
    }
    
    public static void forEachLevel(Consumer<TradeBuilder> consumer) {
        TradeBuilder.forEachLevel((level, tradeBuilder) -> consumer.accept(tradeBuilder));
    }
    
    public static void forEachWanderer(Consumer<TradeBuilder> consumer) {
        List<TradeBuilder> list = TradeBuilder.TRADES_LIST.get(5);
        
        for(TradeBuilder tradeBuilder : list) {
            consumer.accept(tradeBuilder);
        }
    }
    
    public static void forEachWandererRare(Consumer<TradeBuilder> consumer) {
        List<TradeBuilder> list = TradeBuilder.TRADES_LIST.get(6);
        
        for(TradeBuilder tradeBuilder : list) {
            consumer.accept(tradeBuilder);
        }
    }
    
    protected Function<Random, ItemStack> price;
    protected Function<Random, ItemStack> price2;
    protected Function<Random, ItemStack> forSale;
    
    protected final int maxTrades;
    protected final int xp;
    protected final float priceMult;
    
    protected boolean rare;
    
    public TradeBuilder(int maxTrades, int xp, float priceMult) {
        this.price = null;
        this.price2 = (random) -> ItemStack.EMPTY;
        this.forSale = null;
        this.maxTrades = maxTrades;
        this.xp = xp;
        this.priceMult = priceMult;
        this.rare = false;
    }
    
    public TradeBuilder setPrice(Function<Random, ItemStack> price) {
        this.price = price;
        return this;
    }
    
    public TradeBuilder setPrice(Item item, int min, int max) {
        return this.setPrice(TradeBuilder.createFunction(item, min, max));
    }
    
    public TradeBuilder setPrice2(Function<Random, ItemStack> price2) {
        this.price2 = price2;
        return this;
    }
    
    public TradeBuilder setPrice2(Item item, int min, int max) {
        return this.setPrice2(TradeBuilder.createFunction(item, min, max));
    }
    
    public TradeBuilder setForSale(Function<Random, ItemStack> forSale) {
        this.forSale = forSale;
        return this;
    }
    
    public TradeBuilder setForSale(Item item, int min, int max) {
        return this.setForSale(TradeBuilder.createFunction(item, min, max));
    }
    
    public TradeBuilder setEmeraldPrice(int emeralds) {
        return this.setPrice((random) -> new ItemStack(Items.EMERALD, emeralds));
    }
    
    public TradeBuilder setEmeraldPriceFor(int emeralds, Item item, int amt) {
        this.setEmeraldPrice(emeralds);
        return this.setForSale((random) -> new ItemStack(item, amt));
    }
    
    public TradeBuilder setEmeraldPriceFor(int emeralds, Item item) {
        return this.setEmeraldPriceFor(emeralds, item, 1);
    }
    
    public TradeBuilder setEmeraldPrice(int min, int max) {
        return this.setPrice(Items.EMERALD, min, max);
    }
    
    public TradeBuilder setEmeraldPriceFor(int min, int max, Item item, int amt) {
        this.setEmeraldPrice(min, max);
        return this.setForSale((random) -> new ItemStack(item, amt));
    }
    
    public TradeBuilder setEmeraldPriceFor(int min, int max, Item item) {
        return this.setEmeraldPriceFor(min, max, item, 1);
    }
    
    public TradeBuilder setRare() {
        this.rare = true;
        return this;
    }
    
    public boolean canBuild() {
        return this.price != null && this.forSale != null;
    }
    
    public ITrade build() {
        return (entity, random) -> !this.canBuild() ? null : new MerchantOffer(this.price.apply(random), this.price2.apply(random), this.forSale.apply(random), this.maxTrades, this.xp, this.priceMult);
    }
    
    public static Function<Random, ItemStack> createFunction(Item item, int min, int max) {
        return (random) -> new ItemStack(item, random.nextInt(max) + min);
    }
    
    // --- registering stuff ---
    
    protected TradeBuilder register(int index) {
        TradeBuilder.register(index, this);
        return this;
    }
    
    /**
     * @param level 1-5
     */
    public TradeBuilder registerLevel(int level) {
        return this.register(level - 1);
    }
    
    public TradeBuilder registerWanderer(boolean rare) {
        return this.register(rare ? 6 : 5);
    }
}
