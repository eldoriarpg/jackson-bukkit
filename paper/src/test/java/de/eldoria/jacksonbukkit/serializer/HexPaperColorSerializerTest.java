/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import tools.jackson.core.JacksonException;
import tools.jackson.databind.JacksonModule;
import de.eldoria.jacksonbukkit.JacksonPaper;
import de.eldoria.jacksonbukkit.PaperSerializationTest;
import de.eldoria.jacksonbukkit.templates.RGBAColorTemplate;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HexPaperColorSerializerTest implements PaperSerializationTest {
    @Override
    public JacksonModule buildModule() {
        return JacksonPaper.builder().colorAsHex().build();
    }

    @Test
    void serializeToJson() throws JacksonException {
        assertEquals(json("rgba_color_hex"), toJson(RGBAColorTemplate.SINGLE));
        assertEquals(json("rgba_color_hex_list"), toJson(RGBAColorTemplate.LIST));
    }

    @Test
    void serializeToYaml() throws JacksonException {
        assertEquals(yaml("rgba_color_hex"), toYaml(RGBAColorTemplate.SINGLE));
        assertEquals(yaml("rgba_color_hex_list"), toYaml(RGBAColorTemplate.LIST));
    }

    // toml can't c:
    @Test
    @Disabled
    void serializeToToml() throws JacksonException {
        assertEquals(toml("rgba_color_hex"), toToml(RGBAColorTemplate.SINGLE));
    }
}
