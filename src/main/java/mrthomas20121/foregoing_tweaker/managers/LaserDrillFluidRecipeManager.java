package mrthomas20121.foregoing_tweaker.managers;

import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.action.recipe.ActionAddRecipe;
import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker.api.fluid.IFluidStack;
import com.blamejared.crafttweaker.api.ingredient.IIngredient;
import com.blamejared.crafttweaker.api.recipe.manager.base.IRecipeManager;
import com.buuz135.industrial.recipe.LaserDrillFluidRecipe;
import com.buuz135.industrial.recipe.LaserDrillRarity;
import mrthomas20121.foregoing_tweaker.laser_drill.LaserDrillRarityInterface;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeType;
import org.openzen.zencode.java.ZenCodeType;

import java.util.Arrays;
import java.util.stream.Collectors;

@ZenCodeType.Name("mods.foregoing_tweaker.LaserDrillFluid")
@ZenRegister
public class LaserDrillFluidRecipeManager implements IRecipeManager<LaserDrillFluidRecipe> {

    @ZenCodeType.Method
    public void addRecipe(String name, IFluidStack output, IIngredient lens, LaserDrillRarityInterface...rarities) {
        LaserDrillRarity[] laserDrillRarities = Arrays.stream(rarities).map(LaserDrillRarityInterface::getInternal).collect(Collectors.toList()).toArray(new LaserDrillRarity[] {});
        CraftTweakerAPI.apply(new ActionAddRecipe(this, new LaserDrillFluidRecipe(name, createNBT(output), lens.asVanillaIngredient(), new ResourceLocation("minecraft:empty"), laserDrillRarities)));
    }

    private CompoundTag createNBT(IFluidStack fluidStack) {
        return LaserDrillFluidRecipe.createNBT(fluidStack.getFluid().getRegistryName().toString(), fluidStack.getAmount());
    }

    @Override
    public RecipeType<LaserDrillFluidRecipe> getRecipeType() {
        return LaserDrillFluidRecipe.SERIALIZER.getRecipeType();
    }
}
