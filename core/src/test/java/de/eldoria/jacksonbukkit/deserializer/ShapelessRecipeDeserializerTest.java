/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import be.seeseemelk.mockbukkit.MockBukkit;
import com.fasterxml.jackson.core.JsonProcessingException;
import de.eldoria.jacksonbukkit.CoreSerializationTest;
import de.eldoria.jacksonbukkit.entities.ShapelessRecipeWrapper;
import de.eldoria.jacksonbukkit.templates.ShapelessRecipeTemplate;
import org.bukkit.inventory.ShapelessRecipe;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShapelessRecipeDeserializerTest implements CoreSerializationTest {
    @BeforeAll
    static void beforeAll() {
        MockBukkit.mock();
    }

    @Test
    void deserializeFromJson() throws JsonProcessingException {
        assertEquals(ShapelessRecipeWrapper.of(ShapelessRecipeTemplate.SINGLE), ShapelessRecipeWrapper.of(fromJson("shapeless_recipe", ShapelessRecipe.class)));
        assertEquals(ShapelessRecipeTemplate.LIST.stream().map(ShapelessRecipeWrapper::of).toList(), fromJsonList("shapeless_recipe_list", ShapelessRecipe.class).stream().map(ShapelessRecipeWrapper::of).toList());
    }

    @Test
    void deserializeFromYaml() throws JsonProcessingException {
        assertEquals(ShapelessRecipeWrapper.of(ShapelessRecipeTemplate.SINGLE), ShapelessRecipeWrapper.of(fromYaml("shapeless_recipe", ShapelessRecipe.class)));
        assertEquals(ShapelessRecipeTemplate.LIST.stream().map(ShapelessRecipeWrapper::of).toList(), fromYamlList("shapeless_recipe_list", ShapelessRecipe.class).stream().map(ShapelessRecipeWrapper::of).toList());
    }

    @Test
    void deserializeFromToml() throws JsonProcessingException {
        assertEquals(ShapelessRecipeWrapper.of(ShapelessRecipeTemplate.SINGLE), ShapelessRecipeWrapper.of(fromToml("shapeless_recipe", ShapelessRecipe.class)));
    }

    @AfterAll
    static void afterAll() {
        MockBukkit.unmock();
    }

}
