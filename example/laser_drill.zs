import mods.foregoing_tweaker.laser_drill.LaserDrillRarityBuilder;

var rarity1 = new LaserDrillRarityBuilder().addBiomeDictToBlacklist("HOT").setDepthMax(255).setDepthMin(0).setWeight(0).build();
var rarity2 = new LaserDrillRarityBuilder().addBiomeDictToWhitelist("WATER").addBiomeDictToBlacklist("END").addBiomeDictToBlacklist("NETHER").setDepthMax(255).setDepthMin(0).setWeight(0).build();
var rarity3 = new LaserDrillRarityBuilder().addBiomeDictToWhitelist("DESERT").setDepthMax(40).setDepthMin(0).setWeight(3).build();

// recipe name, input, lens to use, a rarity to use(you can have as much rarities as you want)
<recipetype:industrialforegoing:laser_drill_ore>.addRecipe('test_recipe', <item:minecraft:dirt>, <item:industrialforegoing:laser_lens0>, rarity1, rarity2, rarity3);
<recipetype:industrialforegoing:laser_drill_fluid>.addRecipe('test_recipe', <fluid:water>*1000, <item:industrialforegoing:laser_lens11>, rarity2);