package mrthomas20121.foregoing_tweaker.managers;

import com.blamejared.crafttweaker.api.annotations.ZenRegister;
import com.blamejared.crafttweaker.api.item.IItemStack;
import com.buuz135.industrial.api.recipe.BioReactorEntry;
import com.buuz135.industrial.api.recipe.FluidDictionaryEntry;
import com.buuz135.industrial.api.recipe.ProteinReactorEntry;
import com.buuz135.industrial.api.recipe.SludgeEntry;
import org.openzen.zencode.java.ZenCodeType;

@ZenCodeType.Name("mods.industrial_foregoing.Generators")
@ZenRegister
public class Generators {
    public void addSludgeEntry(IItemStack stack, int weight) {
        SludgeEntry.SLUDGE_RECIPES.add(new SludgeEntry(stack.getInternal(), weight));
    }

    public void addBioReactorEntry(IItemStack stack) {
        BioReactorEntry.BIO_REACTOR_ENTRIES.add(new BioReactorEntry(stack.getInternal()));
    }

    public void addProteinReactorEntry(IItemStack stack) {
        ProteinReactorEntry.PROTEIN_REACTOR_ENTRIES.add(new ProteinReactorEntry(stack.getInternal()));
    }

    public void addFluidDictionaryEntry(String fluid1, String fluid2, double ratio) {
        FluidDictionaryEntry.FLUID_DICTIONARY_RECIPES.add(new FluidDictionaryEntry(fluid1, fluid2, ratio));
    }
}
