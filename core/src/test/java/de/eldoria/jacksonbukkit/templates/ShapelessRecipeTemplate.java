/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.templates;

import de.eldoria.jacksonbukkit.CoreSerializationTest;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapelessRecipe;

import java.util.List;

public class ShapelessRecipeTemplate implements CoreSerializationTest {
    public static final ShapelessRecipe SINGLE = new ShapelessRecipe(NamespacedKey.minecraft("test1"), new ItemStack(Material.STRING))
            .addIngredient(new RecipeChoice.ExactChoice(new ItemStack(Material.CHEST, 2)))
            .addIngredient(Material.STICK);

    public static final List<ShapelessRecipe> LIST = List.of(SINGLE,
            new ShapelessRecipe(NamespacedKey.minecraft("test2"), new ItemStack(Material.GOLD_BLOCK))
                    .addIngredient(new RecipeChoice.ExactChoice(new ItemStack(Material.CHEST, 2)))
                    .addIngredient(Material.STICK),
            new ShapelessRecipe(NamespacedKey.minecraft("test3"), new ItemStack(Material.ANVIL))
                    .addIngredient(new RecipeChoice.MaterialChoice(Material.ICE, Material.GRAVEL))
                    .addIngredient(Material.STICK));
}
