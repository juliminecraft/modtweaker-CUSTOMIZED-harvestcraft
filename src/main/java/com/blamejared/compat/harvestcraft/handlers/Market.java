package com.blamejared.compat.harvestcraft.handlers;

import static com.blamejared.mtlib.helpers.InputHelper.toStack;

import java.util.List;
import java.util.ArrayList;

import com.blamejared.ModTweaker;
import com.blamejared.mtlib.utils.BaseListAddition;
import com.blamejared.mtlib.utils.BaseListRemoval;

import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.oredict.IOreDictEntry;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
import com.pam.harvestcraft.tileentities.MarketData;
import com.pam.harvestcraft.tileentities.MarketItems;
import net.minecraft.item.ItemStack;


@ZenClass("mods.harvestcraft.Market")
@ModOnly("harvestcraft")
@ZenRegister
public class Market extends MarketItems {

    protected static final String name = "HarvestCraft Market";
    private ArrayList<MarketData> additions = new ArrayList<MarketData>();
    private ArrayList<MarketData> removals = new ArrayList<MarketData>();
    
    @ZenMethod
    public static void addAll(IOreDictEntry oredictentry, IItemStack currency, int price){
        oredictentry.getItems().forEach(i -> add(i, currency, price));
    }

    @ZenMethod
    public static void add(IItemStack output, IItemStack currency, int price) {
        MarketData recipe = new MarketData(toStack(output), toStack(currency), price);
        ModTweaker.LATE_ADDITIONS.add(new Add(createList(), recipe));
    }
    
    @ZenMethod
    public static void remove(IItemStack output) {
        ModTweaker.LATE_REMOVALS.add(new Remove(createList(), toStack(output)));
    }

    @ZenMethod
    public static void removeAll() {
        ModTweaker.LATE_REMOVALS.add(new RemoveAll(createList()));
    }

    private static class Add extends BaseListAddition<MarketData>{
        public Add(List<MarketData> recipeList, MarketData recipe) {
            super(Market.name, recipeList);
            this.recipes.add(recipe);
        }

        @Override
        public void apply() {            
            items.add(recipes.getFirst());
        }
        
        @Override
        public String getRecipeInfo(MarketData marketData) {
            return marketData.getItem().getDisplayName();
        }
    }

    private static class Remove extends BaseListRemoval<MarketData> {
        private ItemStack output;

        protected Remove(List<MarketData> recipeList, ItemStack output) {
            super(Market.name, recipeList);
            this.recipes.add(new MarketData(output, output, 1));
            this.output = output;
        }
        
        @Override
        public void apply() {
            for(MarketData marketData : this.list) {
                if(!marketData.getItem().getItem().equals(output.getItem())) {
                    items.remove(marketData);
                }
            }
        }
        
        @Override
        protected String getRecipeInfo(MarketData marketData) {
            return marketData.getItem().getDisplayName();
        }
    }

    private static class RemoveAll extends BaseListRemoval<MarketData> {
        protected RemoveAll(List<MarketData> recipeList) {
            super(Market.name, recipeList);
        }

        @Override
        public void apply(){
            items.clear();
        }


        @Override 
        public String describe() {
            return "Removed all "+Market.name+"recipies";
        }

        @Override
        protected String getRecipeInfo(MarketData marketData) {
            return marketData.getItem().getDisplayName();
        }
    }

    
    private static List<MarketData> createList()
    {
        List<MarketData> list = new ArrayList<>();
        items.forEach(m -> list.add(m));
        return list;
    }
}