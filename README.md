ModTweaker2
==========
ModTweaker is an addon for MineTweaker 3. Minetweaker lets you adjust recipes, remove them entirely, or add new recipes. While it has decent mod support, there are many mods that use custom crafting handlers that are not supported natively. ModTweaker plans to provide additional support for as many of these mods over time as possible.


Stable Releases on Curse
----------
https://minecraft.curseforge.com/projects/modtweaker

Development build on jenkins
----------
http://ci.blamejared.com/job/Modtweaker/


Guidelines for Bugreporting
----------
https://github.com/jaredlll08/ModTweaker2/wiki/Bug-Reporting-Guidelines


Supported Mods
----------
- Actually Additions
- Applied Energistics 2
- Auracascade
- Blood Magic
- Botania
- Chisel
- ExNihilo
- ExtendedWorkbench
- Factorization (0.8.95+)
- Forestry (3.6.0+)
- Flaxbeard's Steam Power
- Mariculture
- Mekanism 8
- Metallurgy
- PneumaticCraft
- Railcraft
- Tinkers Construct
- Terrafirmacraft
- Thaumcraft
- Thermal Expansion

ModTweaker2 Customized Harvestcraft
==========
This is a customized ModTweaker version to allow manipulating Pam's Harvestcraft Machine Recipies (Grinder, Presser, WaterFilter, Market, ShippingBin)

Added ZenScript Methods (see test_scripts/harvestcraft.zs for examples):
----------
Grinder:
mods.harvestcraft.Grinder.addRecipe(IItemStack input, IItemStack outputleft, IItemStack outputright);
mods.harvestcraft.Grinder.removeRecipe(IItemStack input);
mods.harvestcraft.Grinder.removeAll();

Presser:
mods.harvestcraft.Presser.addRecipe(IItemStack input, IItemStack outputleft, IItemStack outputright);
mods.harvestcraft.Presser.removeRecipe(IItemStack input);
mods.harvestcraft.Presser.removeAll();

WaterFilter:
mods.harvestcraft.WaterFilter.addRecipe(IItemStack input, IItemStack outputleft, IItemStack outputright);
mods.harvestcraft.WaterFilter.removeRecipe(IItemStack input);
mods.harvestcraft.WaterFilter.removeAll();

Market:
mods.harvestcraft.Market.add(IItemStack input, IItemStack currency, int price) 
mods.harvestcraft.Market.remove(IItemStack input);
mods.harvestcraft.Market.removeAll();

ShippingBin:
mods.harvestcraft.ShippingBin.add(IItemStack input, IItemStack currency, int price) 
mods.harvestcraft.ShippingBin.remove(IItemStack input);
mods.harvestcraft.ShippingBin.removeAll();



Link to original mod on Curse
----------
https://minecraft.curseforge.com/projects/modtweaker

