import mods.industrial_foregoing.Generators;

// Generators.addSludgeEntry(IItemStack item, int weight);
Generators.addSludgeEntry(<item:minecraft:stone>, 10);

// Generators.addBioReactorEntry(IItemStack stack);
Generators.addBioReactorEntry(<item:minecraft:stone>);

// Generators.addProteinReactorEntry(IItemStack stack);
Generators.addProteinReactorEntry(<item:minecraft:stone>);

// Generators.addFluidDictionaryEntry(String fluid1, String fluid2, double ratio);
// ratio is the conversion rate between the two fluids
Generators.addFluidDictionaryEntry("minecraft:milk", "harvestcraft:milk", 1);