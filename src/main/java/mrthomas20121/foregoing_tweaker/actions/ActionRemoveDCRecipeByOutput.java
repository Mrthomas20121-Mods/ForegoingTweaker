package mrthomas20121.foregoing_tweaker.actions;

import com.blamejared.crafttweaker.api.fluid.IFluidStack;
import com.blamejared.crafttweaker.api.managers.IRecipeManager;
import com.blamejared.crafttweaker.impl.actions.recipes.ActionRecipeBase;
import com.buuz135.industrial.recipe.DissolutionChamberRecipe;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;

import java.util.Iterator;
import java.util.Map;

public class ActionRemoveDCRecipeByOutput extends ActionRecipeBase {

    private final IFluidStack output;

    public ActionRemoveDCRecipeByOutput(IRecipeManager manager, IFluidStack output) {
        super(manager);
        this.output = output;
    }

    @Override
    public void apply() {
        Iterator<Map.Entry<ResourceLocation, IRecipe<?>>> iterator = getRecipes().entrySet().iterator();
        while(iterator.hasNext()) {
            DissolutionChamberRecipe recipe = (DissolutionChamberRecipe) iterator.next().getValue();

            if(recipe.outputFluid.isFluidEqual(output.getInternal())) {
                iterator.remove();
            }
        }
    }

    @Override
    public String describe() {
        return "Removing \"" + Registry.RECIPE_TYPE.getKey(getManager().getRecipeType()) + "\" recipes with output" + output.getRegistryName().toString();
    }
}
