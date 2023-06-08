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
import org.bukkit.inventory.ShapedRecipe;

import java.util.List;

public class ShapedRecipeTemplate implements CoreSerializationTest {
    public static final ShapedRecipe SINGLE = new ShapedRecipe(NamespacedKey.minecraft("test"), new ItemStack(Material.STONE, 32))
            .shape("aaa",
                    " b ",
                    " b ")
            .setIngredient('a', new RecipeChoice.MaterialChoice(Material.STONE, Material.COBBLED_DEEPSLATE))
            .setIngredient('b', Material.STICK);

    public static final List<ShapedRecipe> LIST = List.of(SINGLE,
            new ShapedRecipe(NamespacedKey.minecraft("test2"), new ItemStack(Material.BONE, 1))
                    .shape(" a ", " a ", " a ")
                    .setIngredient('a', new RecipeChoice.ExactChoice(new ItemStack(Material.DIAMOND, 2))),
            new ShapedRecipe(NamespacedKey.minecraft("test3"), new ItemStack(Material.CHEST, 9))
                    .shape(" a ", " a ", " a ")
                    .setIngredient('a', new RecipeChoice.MaterialChoice(Material.BONE_MEAL,Material.GOLD_BLOCK)));
}
