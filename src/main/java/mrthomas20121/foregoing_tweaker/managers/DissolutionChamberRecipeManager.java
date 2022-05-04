package mrthomas20121.foregoing_tweaker.managers;

import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.annotations.ZenRegister;
import com.blamejared.crafttweaker.api.fluid.IFluidStack;
import com.blamejared.crafttweaker.api.item.IIngredient;
import com.blamejared.crafttweaker.api.item.IItemStack;
import com.blamejared.crafttweaker.api.managers.IRecipeManager;
import com.blamejared.crafttweaker.impl.actions.recipes.ActionAddRecipe;
import com.blamejared.crafttweaker.impl.fluid.MCFluidStack;
import com.buuz135.industrial.recipe.DissolutionChamberRecipe;
import mrthomas20121.foregoing_tweaker.actions.ActionRemoveByOutputFluid;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.StackList;
import net.minecraftforge.fluids.FluidStack;
import org.openzen.zencode.java.ZenCodeType;

import java.util.Arrays;
import java.util.stream.Collectors;

@ZenCodeType.Name("mods.foregoing_tweaker.DissolutionChamber")
@ZenRegister
public class DissolutionChamberRecipeManager implements IRecipeManager {

    @ZenCodeType.Method
    public void addRecipe(String name, IIngredient[] inputs, IFluidStack inputFluid, int processingTime, IItemStack output, IFluidStack outputFluid) {

        FluidStack outputFluidInternal = outputFluid == null ? FluidStack.EMPTY: outputFluid.getInternal();
        FluidStack inputFluidInternal = inputFluid == null ? FluidStack.EMPTY: inputFluid.getInternal();
        Ingredient.IItemList[] list = new Ingredient.IItemList[inputs.length];
        for(int i = 0; i<list.length; i++) {
            list[i] = new StackList(Arrays.stream(inputs[i].getItems()).map(IItemStack::getInternal).collect(Collectors.toList()));
        }
        DissolutionChamberRecipe recipe = new DissolutionChamberRecipe(new ResourceLocation("crafttweaker", name), list, inputFluidInternal, processingTime, output.getInternal(), outputFluidInternal);
        CraftTweakerAPI.apply(new ActionAddRecipe(this, recipe, ""));
    }

    @ZenCodeType.Method
    public void addRecipe(String name, IIngredient[] inputs, IFluidStack inputFluid, int processingTime, IItemStack output) {
        addRecipe(name, inputs, inputFluid, processingTime, output, new MCFluidStack(FluidStack.EMPTY));
    }

    @ZenCodeType.Method
    public void addRecipe(String name, IIngredient[] inputs, int processingTime, IItemStack output, IFluidStack outputFluid) {
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
    public IRecipeType<DissolutionChamberRecipe> getRecipeType() {
        return DissolutionChamberRecipe.SERIALIZER.getRecipeType();
    }
}
