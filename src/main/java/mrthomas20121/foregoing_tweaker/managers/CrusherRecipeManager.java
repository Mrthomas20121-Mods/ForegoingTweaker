package mrthomas20121.foregoing_tweaker.managers;

import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.annotations.ZenRegister;
import com.blamejared.crafttweaker.api.item.IIngredient;
import com.blamejared.crafttweaker.api.managers.IRecipeManager;
import com.blamejared.crafttweaker.impl.actions.recipes.ActionAddRecipe;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import com.buuz135.industrial.recipe.CrusherRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;
import org.openzen.zencode.java.ZenCodeType;

@Document("mods/ForegoingTweaker/MaterialStoneworkFactory/Crusher")
@ZenCodeType.Name("mods.foregoing_tweaker.LaserDrill.Crusher")
@ZenRegister
public class CrusherRecipeManager implements IRecipeManager {

    @ZenCodeType.Method
    public void addRecipe(String name, IIngredient output, IIngredient ingredient) {
        ResourceLocation registryName = new ResourceLocation("crafttweaker", name);
        CrusherRecipe recipe = new CrusherRecipe(registryName, ingredient.asVanillaIngredient(), output.asVanillaIngredient());
        CraftTweakerAPI.apply(new ActionAddRecipe(this, recipe, ""));
    }

    @Override
    public IRecipeType<CrusherRecipe> getRecipeType() {
        return CrusherRecipe.SERIALIZER.getRecipeType();
    }
}
