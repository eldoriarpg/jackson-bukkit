package de.eldoria.jacksonbukkit.entities;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

import java.util.Map;

/**
 * Class for wrapping a {@link ShapedRecipe}.
 */
public record ShapedRecipeWrapper(NamespacedKey key, ItemStack result, String[] shape, String group,
                                  Map<Character, RecipeChoice> ingredients) {
    /**
     * Create a new {@link ShapedRecipeWrapper} based on a {@link ShapedRecipe}.
     *
     * @param recipe recipe instance
     * @return new {@link ShapedRecipeWrapper} instance
     */
    public static ShapedRecipeWrapper of(ShapedRecipe recipe) {
        NamespacedKey key = recipe.getKey();
        ItemStack result = recipe.getResult();
        String[] shape = recipe.getShape();
        String group = recipe.getGroup();
        Map<Character, RecipeChoice> choiceMap = recipe.getChoiceMap();
        return new ShapedRecipeWrapper(key, result, shape, group, choiceMap);
    }

    /**
     * Constructs a new {@link ShapedRecipe} based on wrapper values.
     *
     * @return new {@link ShapedRecipe} instance
     */
    public ShapedRecipe toBukkitShapedRecipe() {
        ShapedRecipe shapedRecipe = new ShapedRecipe(key, result);
        shapedRecipe.shape(shape);
        shapedRecipe.setGroup(group);
        for (var entry : ingredients.entrySet()) {
            shapedRecipe.setIngredient(entry.getKey(), entry.getValue());
        }
        return shapedRecipe;
    }
}
