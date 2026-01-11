/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import tools.jackson.core.JacksonException;
import tools.jackson.databind.JacksonModule;
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
    public JacksonModule buildModule() {
        return new JacksonBukkit(true, NamespacedKeySerializer.Format.FULL);
    }

    @Test
    void deserializeFromJson() throws JacksonException {
        assertEquals(RGBColorTemplate.SINGLE, fromJson("rgb_color_hex", Color.class));
        assertEquals(RGBColorTemplate.LIST, fromJsonList("rgb_color_hex_list", Color.class));
    }

    @Test
    void deserializeFromYaml() throws JacksonException {
        assertEquals(RGBColorTemplate.SINGLE, fromYaml("rgb_color_hex", Color.class));
        assertEquals(RGBColorTemplate.LIST, fromYamlList("rgb_color_hex_list", Color.class));
    }

    // toml can't c:
    @Test
    @Disabled
    void deserializeFromToml() throws JacksonException {
        assertEquals(RGBColorTemplate.SINGLE, fromToml("rgb_color_hex", Color.class));
    }
}
