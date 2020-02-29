package com.blamejared.compat.harvestcraft.handlers;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.item.ItemStack;

public class Helper {
    public static Map<ItemStack, ItemStack[]> createNewListExcept(Map<ItemStack, ItemStack[]> list, ItemStack except) {
        Map<ItemStack, ItemStack[]> newList = new HashMap<ItemStack, ItemStack[]>();
        list.entrySet().forEach(entry -> {
            if(entry.getKey().getItem() != except.getItem()){
                newList.put(entry.getKey(), entry.getValue());
            }
        });
        return newList;
    }
}