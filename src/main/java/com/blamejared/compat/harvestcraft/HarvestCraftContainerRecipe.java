package com.blamejared.compat.harvestcraft;

import net.minecraft.item.ItemStack;

public class HarvestCraftContainerRecipe {
    private final ItemStack input;
    private final ItemStack[] outputs;

    public HarvestCraftContainerRecipe(ItemStack input, ItemStack[] outputs){
        this.input = input;
        this.outputs = outputs;
    }

    public HarvestCraftContainerRecipe(ItemStack input, ItemStack outputLeft, ItemStack outputRight){        
        this.input = input;
        this.outputs = new ItemStack[] { outputLeft, outputRight };
    }

    public ItemStack getInput() {
        return input;
    }

    public ItemStack[] getOutputs() {
        return outputs;
    }
}