package mrthomas20121.foregoing_tweaker.managers;

import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.annotations.ZenRegister;
import com.blamejared.crafttweaker.api.fluid.IFluidStack;
import com.blamejared.crafttweaker.api.item.IItemStack;
import com.blamejared.crafttweaker.api.managers.IRecipeManager;
import com.blamejared.crafttweaker.impl.actions.recipes.ActionAddRecipe;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import com.buuz135.industrial.recipe.FluidExtractorRecipe;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import org.openzen.zencode.java.ZenCodeType;

@Document(value = "mods/ForegoingTweaker/FluidExtractor")
@ZenCodeType.Name("mods.foregoing_tweaker.FluidExtractor")
@ZenRegister
public class FluidExtractorRecipeManager implements IRecipeManager {

    @ZenCodeType.Method
    public void addRecipe(String name, IItemStack input, IItemStack block, float breakChance, IFluidStack output, boolean defaultRecipe) {
        Ingredient.IItemList list = new Ingredient.SingleItemList(input.getInternal());
        Item internal = block.getInternal().getItem();
        if(internal instanceof BlockItem) {
            BlockItem internal_block = (BlockItem)internal;
            CraftTweakerAPI.apply(new ActionAddRecipe(this, new FluidExtractorRecipe(new ResourceLocation("crafttweaker", name), list, internal_block.getBlock(), breakChance, output.getInternal(), defaultRecipe)));
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
