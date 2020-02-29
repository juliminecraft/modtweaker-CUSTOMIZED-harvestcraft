package com.blamejared.compat.harvestcraft.handlers;

import static com.blamejared.mtlib.helpers.InputHelper.toStack;

import java.util.List;
import java.util.ArrayList;

import com.blamejared.ModTweaker;
import com.blamejared.compat.harvestcraft.HarvestCraftContainerRecipe;
import com.blamejared.mtlib.utils.BaseListAddition;
import com.blamejared.mtlib.utils.BaseListRemoval;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
import com.pam.harvestcraft.item.GrinderRecipes;
import net.minecraft.item.ItemStack;


@ZenClass("mods.harvestcraft.Grinder")
@ModOnly("harvestcraft")
@ZenRegister
public class Grinder extends GrinderRecipes {

    protected static final String name = "HarvestCraft Grinder Recipes";

    @ZenMethod
    public static void addRecipe(IItemStack input, IItemStack outputleft, IItemStack outputright) {
        HarvestCraftContainerRecipe recipe = new HarvestCraftContainerRecipe(toStack(input), toStack(outputleft), toStack(outputright));    
        ModTweaker.LATE_ADDITIONS.add(new Add(createList(), recipe));
    }
    
    @ZenMethod
    public static void removeRecipe(IItemStack input) {
        ModTweaker.LATE_REMOVALS.add(new Remove(createList(), toStack(input)));
    }

    @ZenMethod
    public static void removeAll() {
        ModTweaker.LATE_REMOVALS.add(new RemoveAll(createList()));
    }

    private static class Add extends BaseListAddition<HarvestCraftContainerRecipe>{
        public Add(List<HarvestCraftContainerRecipe> recipeList, HarvestCraftContainerRecipe recipe) {
            super(Grinder.name, recipeList);
            this.recipes.add(recipe);
        }

        @Override
        public void apply() {            
            grindingList.put(recipes.getFirst().getInput(), recipes.getFirst().getOutputs());            
        }
        
        @Override
        public String getRecipeInfo(HarvestCraftContainerRecipe recipe) {
            return recipe.getInput().getDisplayName();
        }
    }

    private static class Remove extends BaseListRemoval<HarvestCraftContainerRecipe> {
        private ItemStack input;
        
        protected Remove(List<HarvestCraftContainerRecipe> recipeList, ItemStack input) {
            super(Grinder.name, recipeList);
            recipes.add(new HarvestCraftContainerRecipe(input, input, input));
        }
        
        @Override
        public void apply() {
            grindingList.remove(recipes.getFirst().getInput());            
        }
        
        @Override
        protected String getRecipeInfo(HarvestCraftContainerRecipe recipe) {
            return recipe.getInput().getDisplayName();
        }
    }

    private static class RemoveAll extends BaseListRemoval<HarvestCraftContainerRecipe> {
        protected RemoveAll(List<HarvestCraftContainerRecipe> recipeList) {
            super(Grinder.name, recipeList);
            this.recipes.addAll(recipeList);
        }

        @Override
        public void apply(){
            grindingList.clear();
            CraftTweakerAPI.getLogger().logInfo("Removed all "+Grinder.name+"recipies");
        } 

        @Override
        protected String getRecipeInfo(HarvestCraftContainerRecipe recipe) {
            return recipe.getInput().getDisplayName();
        }
    }

    private static List<HarvestCraftContainerRecipe> createList()
    {
        List<HarvestCraftContainerRecipe> list = new ArrayList<>();
        grindingList.forEach((key,value) -> list.add(new HarvestCraftContainerRecipe(key, value)));
        return list;
    }
}