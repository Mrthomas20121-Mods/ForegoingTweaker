package mrthomas20121.foregoing_tweaker.managers;

import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.action.recipe.ActionAddRecipe;
import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker.api.ingredient.IIngredient;
import com.blamejared.crafttweaker.api.recipe.manager.base.IRecipeManager;
import com.buuz135.industrial.module.ModuleCore;
import com.buuz135.industrial.recipe.CrusherRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeType;
import org.openzen.zencode.java.ZenCodeType;

@ZenCodeType.Name("mods.foregoing_tweaker.LaserDrill.Crusher")
@ZenRegister
public class CrusherRecipeManager implements IRecipeManager<CrusherRecipe> {

    @ZenCodeType.Method
    public void addRecipe(String name, IIngredient output, IIngredient ingredient) {
        ResourceLocation registryName = new ResourceLocation("crafttweaker", name);
        CrusherRecipe recipe = new CrusherRecipe(registryName, ingredient.asVanillaIngredient(), output.asVanillaIngredient());
        CraftTweakerAPI.apply(new ActionAddRecipe<>(this, recipe));
    }

    @Override
    public RecipeType<CrusherRecipe> getRecipeType() {
        return (RecipeType<CrusherRecipe>) ModuleCore.CRUSHER_TYPE.get();
    }
}
