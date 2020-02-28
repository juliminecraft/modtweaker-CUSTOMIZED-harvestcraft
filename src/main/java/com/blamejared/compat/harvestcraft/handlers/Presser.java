package com.blamejared.compat.harvestcraft.handlers;

import static com.blamejared.mtlib.helpers.InputHelper.toStack;

import java.util.List;
import java.util.ArrayList;

import com.blamejared.ModTweaker;
import com.blamejared.compat.harvestcraft.HarvestCraftContainerRecipe;
import com.blamejared.mtlib.helpers.LogHelper;
import com.blamejared.mtlib.utils.BaseListAddition;
import com.blamejared.mtlib.utils.BaseListRemoval;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
import com.pam.harvestcraft.item.PresserRecipes;
import net.minecraft.item.ItemStack;


@ZenClass("mods.harvestcraft.Presser")
@ModOnly("harvestcraft")
@ZenRegister
public class Presser extends PresserRecipes {

    protected static final String name = "HarvestCraft Presser Recipes";

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
            super(Presser.name, recipeList);
            this.recipes.add(recipe);
        }

        @Override
        public void apply() {            
            pressingList.put(recipes.getFirst().getInput(), recipes.getFirst().getOutputs());
        }
        
        @Override
        public String getRecipeInfo(HarvestCraftContainerRecipe recipe) {
            return LogHelper.getStackDescription(recipe.getInput());
        }
    }

    private static class Remove extends BaseListRemoval<HarvestCraftContainerRecipe> {
        private ItemStack input;
        
        protected Remove(List<HarvestCraftContainerRecipe> recipeList, ItemStack input) {
            super(Presser.name, recipeList);
            this.input = input;
        }
        
        @Override
        public void apply() {
            for(HarvestCraftContainerRecipe recipe : this.list) {
                if(recipe.getInput().equals(input)) {
                    recipes.add(recipe);
                    pressingList.remove(recipe.getInput());
                }
            }
        }
        
        @Override
        protected String getRecipeInfo(HarvestCraftContainerRecipe recipe) {
            return LogHelper.getStackDescription(recipe.getInput());
        }
    }

    private static class RemoveAll extends BaseListRemoval<HarvestCraftContainerRecipe> {
        protected RemoveAll(List<HarvestCraftContainerRecipe> recipeList) {
            super(Presser.name, recipeList);
            this.recipes.addAll(recipeList);
        }

        @Override
        public void apply(){
            pressingList.clear();
            CraftTweakerAPI.getLogger().logInfo("Removed all "+Presser.name+"recipies");
        } 

        @Override
        protected String getRecipeInfo(HarvestCraftContainerRecipe recipe) {
            return LogHelper.getStackDescription(recipe.getInput());
        }
    }

    private static List<HarvestCraftContainerRecipe> createList()
    {
        List<HarvestCraftContainerRecipe> list = new ArrayList<>();
        pressingList.forEach((key,value) -> list.add(new HarvestCraftContainerRecipe(key, value)));
        return list;
    }
}