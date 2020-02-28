package com.blamejared.compat.harvestcraft.handlers;

import static com.blamejared.mtlib.helpers.InputHelper.toStack;

import java.util.List;

import com.blamejared.ModTweaker;
import com.blamejared.mtlib.helpers.LogHelper;
import com.blamejared.mtlib.utils.BaseListAddition;
import com.blamejared.mtlib.utils.BaseListRemoval;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;
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

    @ZenMethod
    public static void add(IItemStack input, IItemStack currency, int price) {
        MarketData recipe = new MarketData(toStack(input), toStack(currency), price);
        ModTweaker.LATE_ADDITIONS.add(new Add(items, recipe));
    }
    
    @ZenMethod
    public static void removeRecipe(IItemStack input) {
        ModTweaker.LATE_REMOVALS.add(new Remove(items, toStack(input)));
    }

    @ZenMethod
    public static void removeAll() {
        ModTweaker.LATE_REMOVALS.add(new RemoveAll(items));
    }

    private static class Add extends BaseListAddition<MarketData>{
        public Add(List<MarketData> recipeList, MarketData recipe) {
            super(Market.name, recipeList);
            this.recipes.add(recipe);
        }

        @Override
        public void apply() {            
            items.add(recipes.getFirst());
            CraftTweakerAPI.getLogger().logInfo(this.describe());
        }
        
        @Override
        public String getRecipeInfo(MarketData recipe) {
            return LogHelper.getStackDescription(recipe.getItem());
        }
    }

    private static class Remove extends BaseListRemoval<MarketData> {
        private ItemStack input;
        
        protected Remove(List<MarketData> recipeList, ItemStack input) {
            super(Market.name, recipeList);
            this.input = input;
        }
        
        @Override
        public void apply() {
            for(MarketData recipe : this.list) {
                if(recipe.getItem().equals(input)) {
                    recipes.add(recipe);
                    items.remove(recipe);
                }
            }
            CraftTweakerAPI.getLogger().logInfo(this.describe());
        }
        
        @Override
        protected String getRecipeInfo(MarketData recipe) {
            return LogHelper.getStackDescription(recipe.getItem());
        }
    }

    private static class RemoveAll extends BaseListRemoval<MarketData> {
        protected RemoveAll(List<MarketData> recipeList) {
            super(Market.name, recipeList);
            this.recipes.addAll(recipeList);
        }

        @Override
        public void apply(){
            items.clear();
            CraftTweakerAPI.getLogger().logInfo("Removed all "+Market.name+"recipies");
        } 

        @Override
        protected String getRecipeInfo(MarketData recipe) {
            return LogHelper.getStackDescription(recipe.getItem());
        }
    }
}