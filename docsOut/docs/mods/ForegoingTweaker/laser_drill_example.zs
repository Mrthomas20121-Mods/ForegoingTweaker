import mods.foregoing_tweaker.laser_drill.LaserDrillRarityBuilder;

// by default depth min is 0, depth max is 255 and weight is 0.
var rarityBuilder = new LaserDrillRarityBuilder().addBiomeToBlacklist('minecraft:desert').setDepthMax(255).setDepthMin(0).setWeight(0).build();
<recipetype:industrialforegoing:laser_drill_ore>.addRecipe('test_recipe', <item:minecraft:dirt>, <item:industrialforegoing:laser_lens0>, rarityBuilder);
<recipetype:industrialforegoing:laser_drill_fluid>.addRecipe('test_recipe', <fluid:water>*1000, <item:industrialforegoing:laser_lens0>, rarityBuilder);