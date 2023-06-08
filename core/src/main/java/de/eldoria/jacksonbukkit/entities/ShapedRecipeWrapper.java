/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.entities;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Class for wrapping a {@link ShapedRecipe}.
 */
public record ShapedRecipeWrapper(NamespacedKey key, ItemStack result, List<String> shape, String group,
                                  Map<Character, RecipeChoiceWrapper<?>> ingredients) {
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
        Map<Character, RecipeChoiceWrapper<?>> choiceMap = new HashMap<>();
        for (var entry : recipe.getChoiceMap().entrySet()) {
            choiceMap.put(entry.getKey(), RecipeChoiceWrapper.of(entry.getValue()));
        }
        return new ShapedRecipeWrapper(key, result, List.of(shape), group, choiceMap);
    }

    /**
     * Constructs a new {@link ShapedRecipe} based on wrapper values.
     *
     * @return new {@link ShapedRecipe} instance
     */
    public ShapedRecipe toBukkitShapedRecipe() {
        ShapedRecipe shapedRecipe = new ShapedRecipe(key, result);
        shapedRecipe.shape(shape.toArray(new String[0]));
        shapedRecipe.setGroup(group);
        for (var entry : ingredients.entrySet()) {
            shapedRecipe.setIngredient(entry.getKey(), entry.getValue() != null ? entry.getValue().toBukkitRecipeChoice() : null);
        }
        return shapedRecipe;
    }
}
