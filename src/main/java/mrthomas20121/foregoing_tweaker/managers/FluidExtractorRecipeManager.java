package mrthomas20121.foregoing_tweaker.managers;

import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.annotations.ZenRegister;
import com.blamejared.crafttweaker.api.fluid.IFluidStack;
import com.blamejared.crafttweaker.api.item.IIngredient;
import com.blamejared.crafttweaker.api.item.IItemStack;
import com.blamejared.crafttweaker.api.managers.IRecipeManager;
import com.blamejared.crafttweaker.impl.actions.recipes.ActionAddRecipe;
import com.buuz135.industrial.recipe.FluidExtractorRecipe;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.StackList;
import org.openzen.zencode.java.ZenCodeType;

import java.util.Arrays;

@ZenCodeType.Name("mods.foregoing_tweaker.FluidExtractor")
@ZenRegister
public class FluidExtractorRecipeManager implements IRecipeManager {

    @ZenCodeType.Method
    public void addRecipe(String name, IIngredient input, IItemStack block, float breakChance, IFluidStack output, boolean defaultRecipe) {
        Ingredient.IItemList list = new StackList(Arrays.asList(input.asVanillaIngredient().getItems()));
        Item internal = block.getInternal().getItem();
        if(internal instanceof BlockItem) {
            BlockItem internal_block = (BlockItem)internal;
            CraftTweakerAPI.apply(new ActionAddRecipe(this, new FluidExtractorRecipe(new ResourceLocation("crafttweaker", name), list, internal_block.getBlock(), breakChance, output.getInternal(), defaultRecipe)));
        }
        else {
            CraftTweakerAPI.logInfo("%s is not a valid block!", output.getRegistryName().toString());
        }
    }

    @ZenCodeType.Method
    public void addRecipe(String name, IItemStack input, IItemStack block, float breakChance, IFluidStack output) {
        this.addRecipe(name, input, block, breakChance, output, false);
    }

    @Override
    public IRecipeType<FluidExtractorRecipe> getRecipeType() {
        return FluidExtractorRecipe.SERIALIZER.getRecipeType();
    }
}
