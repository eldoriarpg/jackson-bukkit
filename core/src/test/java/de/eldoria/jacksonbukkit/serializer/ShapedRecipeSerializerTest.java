/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import be.seeseemelk.mockbukkit.MockBukkit;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.Module;
import de.eldoria.jacksonbukkit.CoreSerializationTest;
import de.eldoria.jacksonbukkit.JacksonBukkit;
import de.eldoria.jacksonbukkit.templates.ShapedRecipeTemplate;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShapedRecipeSerializerTest implements CoreSerializationTest {
    @Override
    public Module buildModule() {
        return new JacksonBukkit(false, NamespacedKeySerializer.Format.OBJECT);
    }

    @BeforeAll
    static void beforeAll() {
        MockBukkit.mock();
    }

    @Test
    void serializeToJson() throws JsonProcessingException {
        assertEquals(json("shaped_recipe"), toJson(ShapedRecipeTemplate.SINGLE));
        assertEquals(json("shaped_recipe_list"), toJson(ShapedRecipeTemplate.LIST));
    }

    @Test
    void serializeToYaml() throws JsonProcessingException {
        assertEquals(yaml("shaped_recipe"), toYaml(ShapedRecipeTemplate.SINGLE));
        assertEquals(yaml("shaped_recipe_list"), toYaml(ShapedRecipeTemplate.LIST));
    }

    @Test
    void serializeToToml() throws JsonProcessingException {
        assertEquals(toml("shaped_recipe"), toToml(ShapedRecipeTemplate.SINGLE));
    }

    @AfterAll
    static void afterAll() {
        MockBukkit.unmock();
    }
}
