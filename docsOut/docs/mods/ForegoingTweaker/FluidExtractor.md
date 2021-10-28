# FluidExtractor

This class was added by a mod with mod-id `foregoing_tweaker`. So you need to have this mod installed if you want to use this feature.

## Importing the class

It might be required for you to import the package if you encounter any issues (like casting an Array), so better be safe than sorry and add the import at the very top of the file.
```zenscript
import mods.foregoing_tweaker.FluidExtractor;
```


## Implemented Interfaces
FluidExtractor implements the following interfaces. That means all methods defined in these interfaces are also available in FluidExtractor

- [IRecipeManager](/vanilla/api/managers/IRecipeManager)

## Methods

:::group{name=addJSONRecipe}

Return Type: void

```zenscript
FluidExtractor.addJSONRecipe(name as string, data as IData) as void
```

| Parameter | Type | Description |
|-----------|------|-------------|
| name | string | No Description Provided |
| data | [IData](/vanilla/api/data/IData) | No Description Provided |


:::

:::group{name=addRecipe}

Return Type: void

```zenscript
FluidExtractor.addRecipe(name as string, input as IItemStack, block as IItemStack, breakChance as float, output as IFluidStack) as void
```

| Parameter | Type | Description |
|-----------|------|-------------|
| name | string | No Description Provided |
| input | [IItemStack](/vanilla/api/items/IItemStack) | No Description Provided |
| block | [IItemStack](/vanilla/api/items/IItemStack) | No Description Provided |
| breakChance | float | No Description Provided |
| output | [IFluidStack](/vanilla/api/fluid/IFluidStack) | No Description Provided |


:::

:::group{name=addRecipe}

Return Type: void

```zenscript
FluidExtractor.addRecipe(name as string, input as IItemStack, block as IItemStack, breakChance as float, output as IFluidStack, defaultRecipe as boolean) as void
```

| Parameter | Type | Description |
|-----------|------|-------------|
| name | string | No Description Provided |
| input | [IItemStack](/vanilla/api/items/IItemStack) | No Description Provided |
| block | [IItemStack](/vanilla/api/items/IItemStack) | No Description Provided |
| breakChance | float | No Description Provided |
| output | [IFluidStack](/vanilla/api/fluid/IFluidStack) | No Description Provided |
| defaultRecipe | boolean | No Description Provided |


:::

:::group{name=getAllRecipes}

Return Type: stdlib.List&lt;[WrapperRecipe](/vanilla/api/recipe/WrapperRecipe)&gt;

```zenscript
// FluidExtractor.getAllRecipes() as stdlib.List<WrapperRecipe>

myFluidExtractor.getAllRecipes();
```

:::

:::group{name=getRecipeByName}

Return Type: [WrapperRecipe](/vanilla/api/recipe/WrapperRecipe)

```zenscript
FluidExtractor.getRecipeByName(name as string) as WrapperRecipe
```

| Parameter | Type | Description |
|-----------|------|-------------|
| name | string | No Description Provided |


:::

:::group{name=getRecipeMap}

Return Type: [WrapperRecipe](/vanilla/api/recipe/WrapperRecipe)[[MCResourceLocation](/vanilla/api/util/MCResourceLocation)]

```zenscript
// FluidExtractor.getRecipeMap() as WrapperRecipe[MCResourceLocation]

myFluidExtractor.getRecipeMap();
```

:::

:::group{name=getRecipesByOutput}

Return Type: stdlib.List&lt;[WrapperRecipe](/vanilla/api/recipe/WrapperRecipe)&gt;

```zenscript
FluidExtractor.getRecipesByOutput(output as IIngredient) as stdlib.List<WrapperRecipe>
```

| Parameter | Type | Description |
|-----------|------|-------------|
| output | [IIngredient](/vanilla/api/items/IIngredient) | No Description Provided |


:::

:::group{name=removeAll}

Return Type: void

```zenscript
// FluidExtractor.removeAll() as void

myFluidExtractor.removeAll();
```

:::

:::group{name=removeByModid}

Return Type: void

```zenscript
FluidExtractor.removeByModid(modid as string) as void
```

| Parameter | Type | Description |
|-----------|------|-------------|
| modid | string | No Description Provided |


:::

:::group{name=removeByModid}

Return Type: void

```zenscript
FluidExtractor.removeByModid(modid as string, exclude as RecipeFilter) as void
```

| Parameter | Type | Description |
|-----------|------|-------------|
| modid | string | No Description Provided |
| exclude | [RecipeFilter](/vanilla/api/recipe/RecipeFilter) | No Description Provided |


:::

:::group{name=removeByName}

Return Type: void

```zenscript
FluidExtractor.removeByName(name as string) as void
```

| Parameter | Type | Description |
|-----------|------|-------------|
| name | string | No Description Provided |


:::

:::group{name=removeByRegex}

Return Type: void

```zenscript
FluidExtractor.removeByRegex(regex as string) as void
```

| Parameter | Type | Description |
|-----------|------|-------------|
| regex | string | No Description Provided |


:::

:::group{name=removeByRegex}

Return Type: void

```zenscript
FluidExtractor.removeByRegex(regex as string, exclude as RecipeFilter) as void
```

| Parameter | Type | Description |
|-----------|------|-------------|
| regex | string | No Description Provided |
| exclude | [RecipeFilter](/vanilla/api/recipe/RecipeFilter) | No Description Provided |


:::

:::group{name=removeRecipe}

Return Type: void

```zenscript
FluidExtractor.removeRecipe(output as IIngredient) as void
```

| Parameter | Type | Description |
|-----------|------|-------------|
| output | [IIngredient](/vanilla/api/items/IIngredient) | No Description Provided |


:::

:::group{name=removeRecipe}

Return Type: void

```zenscript
FluidExtractor.removeRecipe(output as IItemStack) as void
```

| Parameter | Type | Description |
|-----------|------|-------------|
| output | [IItemStack](/vanilla/api/items/IItemStack) | No Description Provided |


:::

:::group{name=removeRecipeByInput}

Return Type: void

```zenscript
FluidExtractor.removeRecipeByInput(input as IItemStack) as void
```

| Parameter | Type | Description |
|-----------|------|-------------|
| input | [IItemStack](/vanilla/api/items/IItemStack) | No Description Provided |


:::


## Properties

| Name | Type | Has Getter | Has Setter | Description |
|------|------|------------|------------|-------------|
| allRecipes | stdlib.List&lt;[WrapperRecipe](/vanilla/api/recipe/WrapperRecipe)&gt; | true | false | No Description Provided |
| recipeMap | [WrapperRecipe](/vanilla/api/recipe/WrapperRecipe)[[MCResourceLocation](/vanilla/api/util/MCResourceLocation)] | true | false | No Description Provided |

