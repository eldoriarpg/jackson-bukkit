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
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PaperColorSerializerTest implements PaperSerializationTest {

    @Override
    public JacksonModule buildModule() {
        return JacksonPaper.builder().build();
    }

    @Test
    void serializeToJson() throws JacksonException {
        assertEquals(json("rgba_color"), toJson(RGBAColorTemplate.SINGLE));
        assertEquals(json("rgba_color_list"), toJson(RGBAColorTemplate.LIST));
    }

    @Test
    void serializeToYaml() throws JacksonException {
        assertEquals(yaml("rgba_color"), toYaml(RGBAColorTemplate.SINGLE));
        assertEquals(yaml("rgba_color_list"), toYaml(RGBAColorTemplate.LIST));
    }

    @Test
    void serializeToToml() throws JacksonException {
        assertEquals(toml("rgba_color"), toToml(RGBAColorTemplate.SINGLE));
    }
}
