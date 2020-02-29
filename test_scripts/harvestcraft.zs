#priority 100

#Grinder:
mods.harvestcraft.Grinder.removeRecipe(<minecraft:chicken>);
mods.harvestcraft.Grinder.removeAll();
mods.harvestcraft.Grinder.addRecipe(<minecraft:chicken>, <harvestcraft:groundchickenitem>, <harvestcraft:groundchickenitem>);
mods.harvestcraft.Grinder.addRecipe(<minecraft:iron_pickaxe>, <minecraft:stick>, <minecraft:iron_ingot>);

#Presser:
mods.harvestcraft.Presser.removeRecipe(<minecraft:apple>);
mods.harvestcraft.Presser.removeAll();
mods.harvestcraft.Presser.addRecipe(<minecraft:apple>, <harvestcraft:applejuiceitem>, <harvestcraft:fruitbaititem>);
mods.harvestcraft.Presser.addRecipe(<minecraft:log>, <minecraft:coal>, <minecraft:coal>);


#WaterFilter:
mods.harvestcraft.WaterFilter.removeRecipe(<harvestcraft:wovencottonitem>);
mods.harvestcraft.WaterFilter.removeAll();
mods.harvestcraft.WaterFilter.addRecipe(<harvestcraft:wovencottonitem>, <harvestcraft:freshwateritem>, <harvestcraft:saltitem>);
mods.harvestcraft.WaterFilter.addRecipe(<minecraft:log>, <minecraft:paper>, <minecraft:paper>);


#Market:
mods.harvestcraft.Market.remove(<minecraft:pumpkin_seeds>);
mods.harvestcraft.Market.removeAll();
mods.harvestcraft.Market.add(<harvestcraft:presser>, <minecraft:gold_ingot>, 20);
mods.harvestcraft.Market.add(<minecraft:pumpkin_seeds>, <minecraft:gold_ingot>, 13);
mods.harvestcraft.Market.add(<botania:pool>, <botania:manaresource>, 1);


#ShippingBin:
mods.harvestcraft.ShippingBin.remove(<harvestcraft:catfishrawitem>);
mods.harvestcraft.ShippingBin.removeAll();
mods.harvestcraft.ShippingBin.add(<harvestcraft:catfishrawitem>, <minecraft:iron_ingot>, 2);
mods.harvestcraft.ShippingBin.add(<minecraft:diamond_sword>, <minecraft:gold_ingot>, 16);
