/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import tools.jackson.core.JacksonException;
import de.eldoria.jacksonbukkit.CoreSerializationTest;
import de.eldoria.jacksonbukkit.templates.RGBColorTemplate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RGBColorSerializerTest implements CoreSerializationTest {
    @Test
    void serializeToJson() throws JacksonException {
        assertEquals(json("rgb_color"), toJson(RGBColorTemplate.SINGLE));
        assertEquals(json("rgb_color_list"), toJson(RGBColorTemplate.LIST));
    }

    @Test
    void serializeToYaml() throws JacksonException {
        assertEquals(yaml("rgb_color"), toYaml(RGBColorTemplate.SINGLE));
        assertEquals(yaml("rgb_color_list"), toYaml(RGBColorTemplate.LIST));
    }

    @Test
    void serializeToToml() throws JacksonException {
        assertEquals(toml("rgb_color"), toToml(RGBColorTemplate.SINGLE));
    }
}
