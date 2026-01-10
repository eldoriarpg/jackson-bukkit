/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import tools.jackson.core.JacksonException;
import tools.jackson.databind.JacksonModule;
import de.eldoria.jacksonbukkit.JacksonBukkit;
import de.eldoria.jacksonbukkit.CoreSerializationTest;
import de.eldoria.jacksonbukkit.templates.RGBColorTemplate;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HexRGBColorSerializerTest implements CoreSerializationTest {
    @Override
    public JacksonModule buildModule() {
        return new JacksonBukkit(true, NamespacedKeySerializer.Format.FULL);
    }

    @Test
    void serializeToJson() throws JacksonException {
        assertEquals(json("rgb_color_hex"), toJson(RGBColorTemplate.SINGLE));
        assertEquals(json("rgb_color_hex_list"), toJson(RGBColorTemplate.LIST));
    }

    @Test
    void serializeToYaml() throws JacksonException {
        assertEquals(yaml("rgb_color_hex"), toYaml(RGBColorTemplate.SINGLE));
        assertEquals(yaml("rgb_color_hex_list"), toYaml(RGBColorTemplate.LIST));
    }

    // toml can't c:
    @Test
    @Disabled
    void serializeToToml() throws JacksonException {
        assertEquals(toml("rgb_color_hex"), toToml(RGBColorTemplate.SINGLE));
    }
}
