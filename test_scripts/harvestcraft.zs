#Grinder:
mods.harvestcraft.Grinder.removeAll();
mods.harvestcraft.Grinder.addRecipe(<minecraft:chicken>, <harvestcraft:groundchickenItem>, <harvestcraft:groundchickenItem>);
mods.harvestcraft.Grinder.addRecipe(<minecraft:iron_pickaxe>, <minecraft:stick>, <minecraft:iron_ingot>);
mods.harvestcraft.Grinder.removeRecipe(<minecraft:chicken>);

#Presser:
mods.harvestcraft.Presser.removeAll();
mods.harvestcraft.Presser.addRecipe(<minecraft:apple>, <harvestcraft:applejuiceitem>, <harvestcraft:fruitbaititem>);
mods.harvestcraft.Presser.addRecipe(<minecraft:log>, <minecraft:coal>, <minecraft:coal>);
mods.harvestcraft.Presser.removeRecipe(<minecraft:apple>);


#WaterFilter:
mods.harvestcraft.WaterFilter.removeAll();
mods.harvestcraft.WaterFilter.addRecipe(<harvestcraft:wovencottonItem>, <harvestcraft:freshwaterItem>, <harvestcraft:saltItem>);
mods.harvestcraft.WaterFilter.addRecipe(<minecraft:log>, <minecraft:paper>, <minecraft:paper>);
mods.harvestcraft.WaterFilter.removeRecipe(<harvestcraft:wovencottonItem>);


#Market:
mods.harvestcraft.Market.removeAll();
mods.harvestcraft.Market.add(<harvestcraft:presser>, <minecraft:gold_ingot>, 20);
mods.harvestcraft.Market.add(<minecraft:pumpkin_seeds>, <minecraft:gold_ingot>, 13);
mods.harvestcraft.Market.remove(<minecraft:pumpkin_seeds>);


#ShippingBin:
mods.harvestcraft.ShippingBin.removeAll();
mods.harvestcraft.ShippingBin.add(<harvestcraft:catfishrawItem>, <minecraft:iron_ingot>, int 2);
mods.harvestcraft.ShippingBin.add(<minecraft:diamond_sword>, <minecraft:gold_ingot>, int 16);
mods.harvestcraft.ShippingBin.remove(IItemStack input);
