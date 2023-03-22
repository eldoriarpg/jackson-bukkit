/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.eldoria.jacksonbukkit.CoreSerializationTest;
import de.eldoria.jacksonbukkit.templates.RGBColorTemplate;
import org.bukkit.Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RGBColorDeserializerTest implements CoreSerializationTest {

    @Test
    void deserializeFromJson() throws JsonProcessingException {
        assertEquals(RGBColorTemplate.SINGLE, fromJson("rgb_color", Color.class));
        assertEquals(RGBColorTemplate.LIST, fromJsonList("rgb_color_list", Color.class));
    }

    @Test
    void deserializeFromYaml() throws JsonProcessingException {
        assertEquals(RGBColorTemplate.SINGLE, fromYaml("rgb_color", Color.class));
        assertEquals(RGBColorTemplate.LIST, fromYamlList("rgb_color_list", Color.class));
    }

    @Test
    void deserializeFromToml() throws JsonProcessingException {
        assertEquals(RGBColorTemplate.SINGLE, fromToml("rgb_color", Color.class));
    }
}
