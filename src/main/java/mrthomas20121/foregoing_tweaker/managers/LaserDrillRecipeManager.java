package mrthomas20121.foregoing_tweaker.managers;

import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.annotations.ZenRegister;
import com.blamejared.crafttweaker.api.item.IIngredient;
import com.blamejared.crafttweaker.api.managers.IRecipeManager;
import com.blamejared.crafttweaker.impl.actions.recipes.ActionAddRecipe;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import com.buuz135.industrial.recipe.LaserDrillOreRecipe;
import com.buuz135.industrial.recipe.LaserDrillRarity;
import mrthomas20121.foregoing_tweaker.laser_drill.LaserDrillRarityInterface;
import net.minecraft.item.crafting.IRecipeType;
import org.openzen.zencode.java.ZenCodeType;

import java.util.Arrays;
import java.util.stream.Collectors;

@ZenCodeType.Name("mods.foregoing_tweaker.LaserDrillRecipe")
@ZenRegister
public class LaserDrillRecipeManager implements IRecipeManager {

    @ZenCodeType.Method
    public void addRecipe(String name, IIngredient output, IIngredient lens, LaserDrillRarityInterface...rarities) {
        LaserDrillRarity[] laserDrillRarities = Arrays.stream(rarities).map(LaserDrillRarityInterface::getInternal).collect(Collectors.toList()).toArray(new LaserDrillRarity[] {});
        CraftTweakerAPI.apply(new ActionAddRecipe(this, new LaserDrillOreRecipe(name, output.asVanillaIngredient(), lens.asVanillaIngredient(), null, laserDrillRarities), ""));
    }

    @Override
    public IRecipeType<LaserDrillOreRecipe> getRecipeType() {
        return LaserDrillOreRecipe.SERIALIZER.getRecipeType();
    }
}
