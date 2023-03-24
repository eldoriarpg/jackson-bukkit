/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.eldoria.jacksonbukkit.CoreSerializationTest;
import de.eldoria.jacksonbukkit.templates.RGBColorTemplate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RGBColorSerializerTest implements CoreSerializationTest {


    @Test
    void serializeToJson() throws JsonProcessingException {
        assertEquals(json("rgb_color"), toJson(RGBColorTemplate.SINGLE));
        assertEquals(json("rgb_color_list"), toJson(RGBColorTemplate.LIST));
    }

    @Test
    void serializeToYaml() throws JsonProcessingException {
        assertEquals(yaml("rgb_color"), toYaml(RGBColorTemplate.SINGLE));
        assertEquals(yaml("rgb_color_list"), toYaml(RGBColorTemplate.LIST));
    }

    @Test
    void serializeToToml() throws JsonProcessingException {
        assertEquals(toml("rgb_color"), toToml(RGBColorTemplate.SINGLE));
    }
}
