/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.eldoria.jacksonbukkit.SerializationTest;
import de.eldoria.jacksonbukkit.templates.ColorTemplate;
import org.bukkit.Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ColorDeserializerTest implements SerializationTest {

    @Test
    void deserializeFromJson() throws JsonProcessingException {
        assertEquals(ColorTemplate.SINGLE, fromJson("color", Color.class));
        assertEquals(ColorTemplate.LIST, fromJsonList("color_list", Color.class));
    }

    @Test
    void deserializeFromYaml() throws JsonProcessingException {
        assertEquals(ColorTemplate.SINGLE, fromYaml("color", Color.class));
        assertEquals(ColorTemplate.LIST, fromYamlList("color_list", Color.class));
    }

    @Test
    void deserializeFromToml() throws JsonProcessingException {
        assertEquals(ColorTemplate.SINGLE, fromToml("color", Color.class));
    }
}
