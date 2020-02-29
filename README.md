
ModTweaker2 Customized Harvestcraft
==========
This is a customized ModTweaker version to allow manipulating Pam's Harvestcraft Machine Recipies (Grinder, Presser, WaterFilter, Market, ShippingBin)

Added ZenScript Methods (see test_scripts/harvestcraft.zs for examples):
----------
Grinder:
----------
- mods.harvestcraft.Grinder.addAll(IOreDictEntry input, IItemStack outputleft, IItemStack outputright);
- mods.harvestcraft.Grinder.addRecipe(IItemStack input, IItemStack outputleft, IItemStack outputright);
- mods.harvestcraft.Grinder.removeRecipe(IItemStack input);
- mods.harvestcraft.Grinder.removeAll();

Presser:
----------
- mods.harvestcraft.Presser.addAll(IOreDictEntry input, IItemStack outputleft, IItemStack outputright);
- mods.harvestcraft.Presser.addRecipe(IItemStack input, IItemStack outputleft, IItemStack outputright);
- mods.harvestcraft.Presser.removeRecipe(IItemStack input);
- mods.harvestcraft.Presser.removeAll();

WaterFilter:
----------
- mods.harvestcraft.WaterFilter.addAll(IOreDictEntry input, IItemStack outputleft, IItemStack outputright);
- mods.harvestcraft.WaterFilter.addRecipe(IItemStack input, IItemStack outputleft, IItemStack outputright);
- mods.harvestcraft.WaterFilter.removeRecipe(IItemStack input);
- mods.harvestcraft.WaterFilter.removeAll();

Market:
----------
- mods.harvestcraft.Market.addAll(IOreDictEntry output, IItemStack currency, int price) 
- mods.harvestcraft.Market.add(IItemStack output, IItemStack currency, int price) 
- mods.harvestcraft.Market.remove(IItemStack output);
- mods.harvestcraft.Market.removeAll();

ShippingBin:
----------
- mods.harvestcraft.ShippingBin.addAll(IOreDictEntry output, IItemStack currency, int price) 
- mods.harvestcraft.ShippingBin.add(IItemStack output, IItemStack currency, int price) 
- mods.harvestcraft.ShippingBin.remove(IItemStack output);
- mods.harvestcraft.ShippingBin.removeAll();


Link to original mod on Curse
----------
https://minecraft.curseforge.com/projects/modtweaker

