package mrthomas20121.foregoing_tweaker.managers;

import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.annotations.ZenRegister;
import com.blamejared.crafttweaker.api.item.IItemStack;
import com.blamejared.crafttweaker.api.managers.IRecipeManager;
import com.blamejared.crafttweaker.impl.actions.recipes.ActionAddRecipe;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import com.buuz135.industrial.recipe.StoneWorkGenerateRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;
import org.openzen.zencode.java.ZenCodeType;

@Document("mods/ForegoingTweaker/MaterialStoneworkFactory/StoneworkGenerate")
@ZenCodeType.Name("mods.foregoing_tweaker.DissolutionChamberRecipe")
@ZenRegister
public class StoneworkGenerateRecipeManager implements IRecipeManager {

    @ZenCodeType.Method
    public void addRecipe(String name, IItemStack output, int waterNeed, int lavaNeed, int waterConsume, int lavaConsume) {
        StoneWorkGenerateRecipe recipe = new StoneWorkGenerateRecipe(new ResourceLocation("crafttweaker", name), output.getInternal(), waterNeed, lavaNeed, waterConsume, lavaConsume);
        CraftTweakerAPI.apply(new ActionAddRecipe(this, recipe, ""));
    }

    @ZenCodeType.Method
    public void addRecipe(String name, IItemStack output, int waterNeed, int lavaNeed) {
        StoneWorkGenerateRecipe recipe = new StoneWorkGenerateRecipe(new ResourceLocation("crafttweaker", name), output.getInternal(), waterNeed, lavaNeed, 0, 0);
        CraftTweakerAPI.apply(new ActionAddRecipe(this, recipe, ""));
    }

    @Override
    public IRecipeType<StoneWorkGenerateRecipe> getRecipeType() {
        return StoneWorkGenerateRecipe.SERIALIZER.getRecipeType();
    }
}
