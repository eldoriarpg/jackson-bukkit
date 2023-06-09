/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import be.seeseemelk.mockbukkit.MockBukkit;
import com.fasterxml.jackson.core.JsonProcessingException;
import de.eldoria.jacksonbukkit.CoreSerializationTest;
import de.eldoria.jacksonbukkit.entities.ShapedRecipeWrapper;
import de.eldoria.jacksonbukkit.entities.ShapelessRecipeWrapper;
import de.eldoria.jacksonbukkit.templates.RGBColorTemplate;
import de.eldoria.jacksonbukkit.templates.ShapedRecipeTemplate;
import org.bukkit.Color;
import org.bukkit.inventory.ShapedRecipe;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShapedRecipeDeserializerTest implements CoreSerializationTest {
       @BeforeAll
    static void beforeAll() {
        MockBukkit.mock();
    }

 @Test
    void deserializeFromJson() throws JsonProcessingException {
        assertEquals(ShapedRecipeWrapper.of(ShapedRecipeTemplate.SINGLE), ShapedRecipeWrapper.of(fromJson("shaped_recipe", ShapedRecipe.class)));
        assertEquals(ShapedRecipeTemplate.LIST.stream().map(ShapedRecipeWrapper::of).toList(), fromJsonList("shaped_recipe_list", ShapedRecipe.class).stream().map(ShapedRecipeWrapper::of).toList());
    }

    @Test
    void deserializeFromYaml() throws JsonProcessingException {
        assertEquals(ShapedRecipeWrapper.of(ShapedRecipeTemplate.SINGLE), ShapedRecipeWrapper.of(fromYaml("shaped_recipe", ShapedRecipe.class)));
        assertEquals(ShapedRecipeTemplate.LIST.stream().map(ShapedRecipeWrapper::of).toList(), fromYamlList("shaped_recipe_list", ShapedRecipe.class).stream().map(ShapedRecipeWrapper::of).toList());
    }

    @Test
    void deserializeFromToml() throws JsonProcessingException {
        assertEquals(ShapedRecipeWrapper.of(ShapedRecipeTemplate.SINGLE), ShapedRecipeWrapper.of(fromToml("shaped_recipe", ShapedRecipe.class)));
    }
    @AfterAll
    static void afterAll() {
        MockBukkit.unmock();
    }

}
