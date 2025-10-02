/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.Module;
import de.eldoria.jacksonbukkit.JacksonBukkit;
import de.eldoria.jacksonbukkit.CoreSerializationTest;
import de.eldoria.jacksonbukkit.templates.RGBColorTemplate;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HexRGBColorSerializerTest implements CoreSerializationTest {
    @Override
    public Module buildModule() {
        return new JacksonBukkit(true, NamespacedKeySerializer.Format.FULL);
    }

    @Test
    void serializeToJson() throws JsonProcessingException {
        assertEquals(json("rgb_color_hex"), toJson(RGBColorTemplate.SINGLE));
        assertEquals(json("rgb_color_hex_list"), toJson(RGBColorTemplate.LIST));
    }

    @Test
    void serializeToYaml() throws JsonProcessingException {
        assertEquals(yaml("rgb_color_hex"), toYaml(RGBColorTemplate.SINGLE));
        assertEquals(yaml("rgb_color_hex_list"), toYaml(RGBColorTemplate.LIST));
    }

    // toml can't c:
    @Test
    @Disabled
    void serializeToToml() throws JsonProcessingException {
        assertEquals(toml("rgb_color_hex"), toToml(RGBColorTemplate.SINGLE));
    }
}
