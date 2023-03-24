/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.Module;
import de.eldoria.jacksonbukkit.JacksonPaper;
import de.eldoria.jacksonbukkit.PaperSerializationTest;
import de.eldoria.jacksonbukkit.templates.RGBAColorTemplate;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HexPaperColorSerializerTest implements PaperSerializationTest {
    @Override
    public Module buildModule() {
        return JacksonPaper.builder().colorAsHex().build();
    }

    @Test
    void serializeToJson() throws JsonProcessingException {
        assertEquals(json("rgba_color_hex"), toJson(RGBAColorTemplate.SINGLE));
        assertEquals(json("rgba_color_hex_list"), toJson(RGBAColorTemplate.LIST));
    }

    @Test
    void serializeToYaml() throws JsonProcessingException {
        assertEquals(yaml("rgba_color_hex"), toYaml(RGBAColorTemplate.SINGLE));
        assertEquals(yaml("rgba_color_hex_list"), toYaml(RGBAColorTemplate.LIST));
    }

    // toml can't c:
    @Test
    @Disabled
    void serializeToToml() throws JsonProcessingException {
        assertEquals(toml("rgba_color_hex"), toToml(RGBAColorTemplate.SINGLE));
    }
}
