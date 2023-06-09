/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import be.seeseemelk.mockbukkit.MockBukkit;
import com.fasterxml.jackson.core.JsonProcessingException;
import de.eldoria.jacksonbukkit.CoreSerializationTest;
import de.eldoria.jacksonbukkit.templates.ShapelessRecipeTemplate;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShapelessRecipeSerializerTest implements CoreSerializationTest {
    @BeforeAll
    static void beforeAll() {
        MockBukkit.mock();
    }

    @Test
    void serializeToJson() throws JsonProcessingException {
        assertEquals(json("shapeless_recipe"), toJson(ShapelessRecipeTemplate.SINGLE));
        assertEquals(json("shapeless_recipe_list"), toJson(ShapelessRecipeTemplate.LIST));
    }

    @Test
    void serializeToYaml() throws JsonProcessingException {
        assertEquals(yaml("shapeless_recipe"), toYaml(ShapelessRecipeTemplate.SINGLE));
        assertEquals(yaml("shapeless_recipe_list"), toYaml(ShapelessRecipeTemplate.LIST));
    }

    @Test
    void serializeToToml() throws JsonProcessingException {
        assertEquals(toml("shapeless_recipe"), toToml(ShapelessRecipeTemplate.SINGLE));
    }

    @AfterAll
    static void afterAll() {
        MockBukkit.unmock();
    }
}
