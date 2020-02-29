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
import crafttweaker.api.oredict.IOreDictEntry;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
import com.pam.harvestcraft.tileentities.ShippingBinData;
import com.pam.harvestcraft.tileentities.ShippingBinItems;
import net.minecraft.item.ItemStack;


@ZenClass("mods.harvestcraft.ShippingBin")
@ModOnly("harvestcraft")
@ZenRegister
public class ShippingBin extends ShippingBinItems {

    protected static final String name = "HarvestCraft ShippingBin";

    @ZenMethod
    public static void addAll(IOreDictEntry oredictentry, IItemStack currency, int price){
        oredictentry.getItems().forEach(i -> add(i, currency, price));
    }

    @ZenMethod
    public static void add(IItemStack output, IItemStack currency, int price) {
        ShippingBinData recipe = new ShippingBinData(toStack(output), toStack(currency), price);
        ModTweaker.LATE_ADDITIONS.add(new Add(items, recipe));
    }
    
    @ZenMethod
    public static void remove(IItemStack output) {
        ModTweaker.LATE_REMOVALS.add(new Remove(items, toStack(output)));
    }

    @ZenMethod
    public static void removeAll() {
        ModTweaker.LATE_REMOVALS.add(new RemoveAll(items));
    }

    private static class Add extends BaseListAddition<ShippingBinData>{
        public Add(List<ShippingBinData> recipeList, ShippingBinData shippingBinData) {
            super(ShippingBin.name, recipeList);
            this.recipes.add(shippingBinData);
        }

        @Override
        public void apply() {            
            items.add(recipes.getFirst());
        }
        
        @Override
        public String getRecipeInfo(ShippingBinData recipe) {
            return recipe.getItem().getDisplayName();
        }
    }

    private static class Remove extends BaseListRemoval<ShippingBinData> {
        private ItemStack output;
        
        protected Remove(List<ShippingBinData> recipeList, ItemStack output) {
            super(ShippingBin.name, recipeList);
            this.recipes.add(new ShippingBinData(output, output, 1));
            this.output = output;
        }
        
        @Override
        public void apply() {
            for(ShippingBinData shippingBinData : this.list) {
                if(shippingBinData.getItem().equals(output)) {
                    items.remove(shippingBinData);
                }
            }
        }
        
        @Override
        protected String getRecipeInfo(ShippingBinData shippingBinData) {
            return shippingBinData.getItem().getDisplayName();
        }
    }

    private static class RemoveAll extends BaseListRemoval<ShippingBinData> {
        protected RemoveAll(List<ShippingBinData> recipeList) {
            super(ShippingBin.name, recipeList);
            this.recipes.addAll(recipeList);
        }

        @Override
        public void apply(){
            items.clear();
            CraftTweakerAPI.getLogger().logInfo("Removed all "+ShippingBin.name+"recipies");
        }
                
        @Override 
        public String describe() {
            return "Removed all "+ShippingBin.name+"recipies";
        }

        @Override
        protected String getRecipeInfo(ShippingBinData shippingBinData) {
            return shippingBinData.getItem().getDisplayName();
        }
    }
}