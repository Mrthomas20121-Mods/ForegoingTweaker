::requiredMod[Industrial Foregoing]{builtIn=false modLink=https://www.curseforge.com/minecraft/mc-mods/industrial-foregoing requiredMod=IndustrialForegoingTweaker requiredModLink=https://www.curseforge.com/minecraft/mc-mods/industrial-foregoing-tweaker}

# Fluid Exractor

The Fluid Extractor is a type of [IRecipeManager](/vanilla/api/managers/IRecipeManager) and implements all the methods that are available to IRecipeManager's, such as `removeRecipe()` and `removeAll()`.

### Add Recipe

Note: the recipe won\'t work if the input and output is not a block. You will get a warning saying the 'IItemStack is not a valid block!'

this example extract 50mb of water from sand and convert it to gravel when the recipe is done.

```zenscript
// <recipetype:industrialforegoing:fluid_extractor>.addRecipe(String name, IIngredient input, IItemStack output, float breakChance, IFluidStack outputFluid);
<recipetype:industrialforegoing:fluid_extractor>.addRecipe("recipe_test", <item:minecraft:sand>, <item:minecraft:gravel>, 0.5, <fluid:water>*50);
```

| Parameter | Type | Description |
|-----------|------|-------------|
| name | string | Recipe Name |
| input | [IIngredient](/vanilla/api/items/IIngredient) | The Input Block |
| output | [IItemStack](/vanilla/api/items/IItemStack) | The output Block |
| breakChance | float | Chance the block have to break |