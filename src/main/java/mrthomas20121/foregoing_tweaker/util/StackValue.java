package mrthomas20121.foregoing_tweaker.util;

import com.google.gson.JsonObject;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

import javax.annotation.Nonnull;
import java.util.*;

public class StackValue implements Ingredient.Value {

    private final Collection<ItemStack> items = new ArrayList<>();

    public StackValue(ItemStack[] stacks) {
        items.addAll(Arrays.asList(stacks));
    }

    public StackValue(List<ItemStack> stacks) {
        items.addAll(stacks);
    }

    @Nonnull
    @Override
    public Collection<ItemStack> getItems() {
        return this.items;
    }

    @Nonnull
    @Override
    public JsonObject serialize() {
        return new JsonObject();
    }
}
