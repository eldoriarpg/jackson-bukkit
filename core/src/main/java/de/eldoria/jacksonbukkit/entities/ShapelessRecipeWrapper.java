/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.entities;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;

import java.util.List;

/**
 * Class for wrapping a {@link ShapelessRecipe}.
 */
public record ShapelessRecipeWrapper(NamespacedKey key, ItemStack result, String group,
                                     List<? extends RecipeChoiceWrapper<?>> choiceList) {
    /**
     * Create a new {@link ShapelessRecipeWrapper} based on a {@link ShapelessRecipe}.
     *
     * @param recipe recipe instance
     * @return new {@link ShapelessRecipeWrapper} instance
     */
    public static ShapelessRecipeWrapper of(ShapelessRecipe recipe) {
        List<? extends RecipeChoiceWrapper<?>> choiceList = recipe.getChoiceList().stream().map(RecipeChoiceWrapper::of).toList();
        String group = recipe.getGroup();
        NamespacedKey key = recipe.getKey();
        ItemStack result = recipe.getResult();
        return new ShapelessRecipeWrapper(key, result, group, choiceList);
    }

    /**
     * Constructs a new {@link ShapelessRecipe} based on wrapper values.
     *
     * @return new {@link ShapelessRecipe} instance
     */
    public ShapelessRecipe toBukkitShapelessRecipe() {
        ShapelessRecipe shapelessRecipe = new ShapelessRecipe(key, result);
        shapelessRecipe.setGroup(group);
        for (RecipeChoiceWrapper<?> recipeChoice : choiceList) {
            shapelessRecipe.addIngredient(recipeChoice.toBukkitRecipeChoice());
        }
        return shapelessRecipe;
    }
}
