package mrthomas20121.foregoing_tweaker.managers;

import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.action.recipe.ActionAddRecipe;
import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker.api.fluid.IFluidStack;
import com.blamejared.crafttweaker.api.ingredient.IIngredient;
import com.blamejared.crafttweaker.api.item.IItemStack;
import com.blamejared.crafttweaker.api.recipe.manager.base.IRecipeManager;
import com.buuz135.industrial.module.ModuleCore;
import com.buuz135.industrial.recipe.CrusherRecipe;
import com.buuz135.industrial.recipe.FluidExtractorRecipe;
import mrthomas20121.foregoing_tweaker.util.StackValue;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.RecipeType;
import org.openzen.zencode.java.ZenCodeType;

@ZenCodeType.Name("mods.foregoing_tweaker.FluidExtractor")
@ZenRegister
public class FluidExtractorRecipeManager implements IRecipeManager<FluidExtractorRecipe> {

    @ZenCodeType.Method
    public void addRecipe(String name, IIngredient input, IItemStack block, float breakChance, IFluidStack output, boolean defaultRecipe) {
        StackValue list = new StackValue(input.asVanillaIngredient().getItems());
        Item internal = block.getInternal().getItem();
        if(internal instanceof BlockItem internal_block) {
            CraftTweakerAPI.apply(new ActionAddRecipe<>(this, new FluidExtractorRecipe(new ResourceLocation("crafttweaker", name), list, internal_block.getBlock(), breakChance, output.getInternal(), defaultRecipe)));
        }
        else {
            CraftTweakerAPI.LOGGER.info(output.getRegistryName().toString()+" is not a valid block!");
        }
    }

    @ZenCodeType.Method
    public void addRecipe(String name, IItemStack input, IItemStack block, float breakChance, IFluidStack output) {
        this.addRecipe(name, input, block, breakChance, output, false);
    }

    @Override
    public RecipeType<FluidExtractorRecipe> getRecipeType() {
        return (RecipeType<FluidExtractorRecipe>) ModuleCore.FLUID_EXTRACTOR_TYPE.get();
    }
}
