package mrthomas20121.foregoing_tweaker.util;

import com.blamejared.crafttweaker.api.ingredient.IIngredient;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IIngredientUtil {

    public static Ingredient.Value[] IIngredientArrayToValueArray(IIngredient[] inputs) {
        List<Ingredient> ingredients = Arrays.stream(inputs).map(IIngredient::asVanillaIngredient).toList();
        List<Ingredient.Value> values = new ArrayList<>();
        ingredients.forEach(ingredient -> {
            ItemStack[] stacks = ingredient.getItems();
            if(stacks.length == 1) {
                values.add(new Ingredient.ItemValue(stacks[0]));
            }
            else if(stacks.length > 1) {
                values.add(new StackValue(stacks));
            }
        });
        return values.toArray(new Ingredient.Value[0]);
    }
}
