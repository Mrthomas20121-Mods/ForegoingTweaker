// <recipetype:industrialforegoing:dissolution_chamber>.addRecipe(name as string, ingredients as IIngredient[], inputFluid as IFluidStack, int processingTime, output as IItemStack, outputFluid as IFluidStack);
<recipetype:industrialforegoing:dissolution_chamber>.addRecipe("example_1", [<item:minecraft:cobblestone>, <item:minecraft:stone>, <item:minecraft:cobblestone>], <fluid:minecraft:lava> * 250, 30, <item:minecraft:dirt>, <fluid:minecraft:lava> * 1000);

// <recipetype:industrialforegoing:dissolution_chamber>.addRecipe(name as string, ingredients as IIngredient[], inputFluid as IFluidStack, int processingTime, output as IItemStack);
<recipetype:industrialforegoing:dissolution_chamber>.addRecipe("example_2", [<item:minecraft:cobblestone>, <item:minecraft:cobblestone>], <fluid:minecraft:water> * 1000, 5, <item:minecraft:dirt> * 2);

// <recipetype:industrialforegoing:dissolution_chamber>.addRecipe(name as string, ingredients as IIngredient[], int processingTime, output as IItemStack, outputFluid as IFluidStack);
<recipetype:industrialforegoing:dissolution_chamber>.addRecipe("example_3", [<item:minecraft:cobblestone>, <item:minecraft:cobblestone>], 5, <item:minecraft:dirt>, <fluid:minecraft:water> * 250);
