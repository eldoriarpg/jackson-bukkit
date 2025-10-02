/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.Module;
import de.eldoria.jacksonbukkit.JacksonBukkit;
import de.eldoria.jacksonbukkit.CoreSerializationTest;
import de.eldoria.jacksonbukkit.serializer.NamespacedKeySerializer;
import de.eldoria.jacksonbukkit.templates.RGBColorTemplate;
import org.bukkit.Color;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HexRGBColorDeserializerTest implements CoreSerializationTest {
    @Override
    public Module buildModule() {
        return new JacksonBukkit(true, NamespacedKeySerializer.Format.FULL);
    }

    @Test
    void deserializeFromJson() throws JsonProcessingException {
        assertEquals(RGBColorTemplate.SINGLE, fromJson("rgb_color_hex", Color.class));
        assertEquals(RGBColorTemplate.LIST, fromJsonList("rgb_color_hex_list", Color.class));
    }

    @Test
    void deserializeFromYaml() throws JsonProcessingException {
        assertEquals(RGBColorTemplate.SINGLE, fromYaml("rgb_color_hex", Color.class));
        assertEquals(RGBColorTemplate.LIST, fromYamlList("rgb_color_hex_list", Color.class));
    }

    // toml can't c:
    @Test
    @Disabled
    void deserializeFromToml() throws JsonProcessingException {
        assertEquals(RGBColorTemplate.SINGLE, fromToml("rgb_color_hex", Color.class));
    }
}
