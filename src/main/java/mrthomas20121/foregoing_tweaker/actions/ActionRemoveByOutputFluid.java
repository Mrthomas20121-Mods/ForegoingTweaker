package mrthomas20121.foregoing_tweaker.actions;

import com.blamejared.crafttweaker.api.action.recipe.ActionRecipeBase;
import com.blamejared.crafttweaker.api.fluid.IFluidStack;
import com.blamejared.crafttweaker.api.recipe.manager.base.IRecipeManager;
import com.buuz135.industrial.recipe.DissolutionChamberRecipe;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;

import java.util.Iterator;
import java.util.Map;

public class ActionRemoveByOutputFluid extends ActionRecipeBase<DissolutionChamberRecipe> {

    private final IFluidStack output;

    public ActionRemoveByOutputFluid(IRecipeManager manager, IFluidStack output) {
        super(manager);
        this.output = output;
    }

    @Override
    public void apply() {
        Iterator<Map.Entry<ResourceLocation, DissolutionChamberRecipe>> iterator = getRecipes().entrySet().iterator();
        while(iterator.hasNext()) {
            DissolutionChamberRecipe recipe = iterator.next().getValue();

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
