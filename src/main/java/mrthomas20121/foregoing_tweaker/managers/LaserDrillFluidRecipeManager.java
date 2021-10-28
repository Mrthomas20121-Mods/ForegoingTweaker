package mrthomas20121.foregoing_tweaker.managers;

import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.annotations.ZenRegister;
import com.blamejared.crafttweaker.api.fluid.IFluidStack;
import com.blamejared.crafttweaker.api.item.IIngredient;
import com.blamejared.crafttweaker.api.managers.IRecipeManager;
import com.blamejared.crafttweaker.impl.actions.recipes.ActionAddRecipe;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import com.buuz135.industrial.recipe.LaserDrillFluidRecipe;
import com.buuz135.industrial.recipe.LaserDrillRarity;
import mrthomas20121.foregoing_tweaker.laser_drill.LaserDrillRarityBuilder;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import org.openzen.zencode.java.ZenCodeType;

@Document(value = "mods/ForegoingTweaker/LaserDrill/Fluid")
@ZenCodeType.Name("mods.foregoing_tweaker.LaserDrillFluid")
@ZenRegister
public class LaserDrillFluidRecipeManager implements IRecipeManager {

    @ZenCodeType.Method
    public void addRecipe(String name, IFluidStack output, IIngredient lens, LaserDrillRarityBuilder builder) {
        CraftTweakerAPI.apply(new ActionAddRecipe(this, new LaserDrillFluidRecipe(name, createNBT(output), lens.asVanillaIngredient(), new ResourceLocation("minecraft:empty"), builder.getRarity())));
    }

    @ZenCodeType.Method
    public void addRecipe(String name, IFluidStack output, IIngredient lens, LaserDrillRarityBuilder builder1, LaserDrillRarityBuilder builder2) {
        CraftTweakerAPI.apply(new ActionAddRecipe(this, new LaserDrillFluidRecipe(name, createNBT(output), lens.asVanillaIngredient(), new ResourceLocation("minecraft:empty"), builder1.getRarity(), builder2.getRarity())));
    }

    private CompoundNBT createNBT(IFluidStack fluidStack) {
        return LaserDrillFluidRecipe.createNBT(fluidStack.getFluid().getRegistryName().toString(), fluidStack.getAmount());
    }

    @Override
    public IRecipeType<LaserDrillFluidRecipe> getRecipeType() {
        return LaserDrillFluidRecipe.SERIALIZER.getRecipeType();
    }
}
