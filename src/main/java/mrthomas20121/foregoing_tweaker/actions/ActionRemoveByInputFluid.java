package mrthomas20121.foregoing_tweaker.actions;

import com.blamejared.crafttweaker.api.action.recipe.ActionRecipeBase;
import com.blamejared.crafttweaker.api.fluid.IFluidStack;
import com.blamejared.crafttweaker.api.recipe.manager.base.IRecipeManager;
import com.buuz135.industrial.recipe.DissolutionChamberRecipe;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;

import java.util.Iterator;
import java.util.Map;

public class ActionRemoveByInputFluid extends ActionRecipeBase<DissolutionChamberRecipe> {

    private final IFluidStack input;

    public ActionRemoveByInputFluid(IRecipeManager<DissolutionChamberRecipe> manager, IFluidStack input) {
        super(manager);
        this.input = input;
    }

    @Override
    public void apply() {
        Iterator<Map.Entry<ResourceLocation, DissolutionChamberRecipe>> iterator = getRecipes().entrySet().iterator();
        while(iterator.hasNext()) {
            DissolutionChamberRecipe recipe = (DissolutionChamberRecipe) iterator.next().getValue();

            if(recipe.inputFluid.isFluidEqual(input.getInternal())) {
                iterator.remove();
            }
        }
    }

    @Override
    public String describe() {
        return "Removing \"" + Registry.RECIPE_TYPE.getKey(getManager().getRecipeType()) + "\" recipes with output" + input.getRegistryName().toString();
    }
}