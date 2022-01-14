// <recipetype:industrialforegoing:stonework_generate>.addRecipe(String name, IItemStack output, int waterNeed, int lavaNeed, int waterConsume, int lavaConsume);
// recipe name, output ItemStack, how much water it need to run, how much lava it need to run, how much water it will consume, how much lava it will consume
// no need to set the 3rd and 4th parametter if you want the recipe to not consume any lava and water
<recipetype:industrialforegoing:stonework_generate>.addRecipe("example_recipe", <item:minecraft:dirt>, 300, 300);
<recipetype:industrialforegoing:stonework_generate>.addRecipe("example_recipe_2", <item:minecraft:clay>, 100, 400, 100, 0);