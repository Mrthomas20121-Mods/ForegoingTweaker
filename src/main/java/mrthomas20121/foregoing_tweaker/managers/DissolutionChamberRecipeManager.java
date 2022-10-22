package mrthomas20121.foregoing_tweaker.managers;

import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.action.recipe.ActionAddRecipe;
import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker.api.fluid.IFluidStack;
import com.blamejared.crafttweaker.api.fluid.MCFluidStack;
import com.blamejared.crafttweaker.api.ingredient.IIngredient;
import com.blamejared.crafttweaker.api.item.IItemStack;
import com.blamejared.crafttweaker.api.recipe.manager.base.IRecipeManager;
import com.buuz135.industrial.module.ModuleCore;
import com.buuz135.industrial.recipe.CrusherRecipe;
import com.buuz135.industrial.recipe.DissolutionChamberRecipe;
import mrthomas20121.foregoing_tweaker.actions.ActionRemoveByOutputFluid;
import mrthomas20121.foregoing_tweaker.util.IIngredientUtil;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.fluids.FluidStack;
import org.openzen.zencode.java.ZenCodeType;

@ZenCodeType.Name("mods.foregoing_tweaker.DissolutionChamber")
@ZenRegister
public class DissolutionChamberRecipeManager implements IRecipeManager<DissolutionChamberRecipe> {

    @ZenCodeType.Method
    public void addRecipe(String name, IIngredient[] inputs, IFluidStack inputFluid, int processingTime, IItemStack output, IFluidStack outputFluid) {

        FluidStack outputFluidInternal = outputFluid == null ? FluidStack.EMPTY: outputFluid.getInternal();
        FluidStack inputFluidInternal = inputFluid == null ? FluidStack.EMPTY: inputFluid.getInternal();
        DissolutionChamberRecipe recipe = new DissolutionChamberRecipe(new ResourceLocation("crafttweaker", name), IIngredientUtil.IIngredientArrayToValueArray(inputs), inputFluidInternal, processingTime, output.getInternal(), outputFluidInternal);
        CraftTweakerAPI.apply(new ActionAddRecipe<>(this, recipe, ""));
    }

    @ZenCodeType.Method
    public void addRecipe(String name, IItemStack[] inputs, IFluidStack inputFluid, int processingTime, IItemStack output) {
        addRecipe(name, inputs, inputFluid, processingTime, output, new MCFluidStack(FluidStack.EMPTY));
    }

    @ZenCodeType.Method
    public void addRecipe(String name, IItemStack[] inputs, int processingTime, IItemStack output, IFluidStack outputFluid) {
        addRecipe(name, inputs, new MCFluidStack(FluidStack.EMPTY), processingTime, output, outputFluid);
    }

    @ZenCodeType.Method
    public void removeRecipeByInput(IFluidStack output) {
        CraftTweakerAPI.apply(new ActionRemoveByOutputFluid(this, output));
    }

    @ZenCodeType.Method
    public void removeRecipeByOutput(IFluidStack output) {
        CraftTweakerAPI.apply(new ActionRemoveByOutputFluid(this, output));
    }

    @Override
    public RecipeType<DissolutionChamberRecipe> getRecipeType() {
        return (RecipeType<DissolutionChamberRecipe>) ModuleCore.DISSOLUTION_TYPE.get();
    }
}
