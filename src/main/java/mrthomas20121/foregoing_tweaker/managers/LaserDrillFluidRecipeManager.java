package mrthomas20121.foregoing_tweaker.managers;

import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.annotations.ZenRegister;
import com.blamejared.crafttweaker.api.fluid.IFluidStack;
import com.blamejared.crafttweaker.api.managers.IRecipeManager;
import com.blamejared.crafttweaker.impl.actions.recipes.ActionAddRecipe;
import com.blamejared.crafttweaker.impl.fluid.MCFluidStack;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import com.buuz135.industrial.recipe.LaserDrillFluidRecipe;
import com.buuz135.industrial.recipe.LaserDrillRarity;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;
import org.openzen.zencode.java.ZenCodeType;

@Document("mods/ForegoingTweaker/LaserDrill/Fluid")
@ZenCodeType.Name("mods.foregoing_tweaker.LaserDrillFluidRecipe")
@ZenRegister
public class LaserDrillFluidRecipeManager implements IRecipeManager {

    @ZenCodeType.Method
    public void addRecipe(IFluidStack output, int color, int depth_min, int depth_max, int weight) {
        LaserDrillRarity rarity = new LaserDrillRarity(null, null, depth_min, depth_max, weight);
        CraftTweakerAPI.apply(new ActionAddRecipe(this, new LaserDrillFluidRecipe(output.getInternal(), color, new ResourceLocation("minecraft:empty"), rarity)));
    }

    @Override
    public IRecipeType<LaserDrillFluidRecipe> getRecipeType() {
        return LaserDrillFluidRecipe.SERIALIZER.getRecipeType();
    }
}
