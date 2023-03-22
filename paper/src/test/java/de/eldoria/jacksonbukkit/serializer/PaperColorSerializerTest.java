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
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PaperColorSerializerTest implements PaperSerializationTest {

    @Override
    public Module buildModule() {
        return JacksonPaper.builder().build();
    }

    @Test
    void serializeToJson() throws JsonProcessingException {
        assertEquals(json("rgba_color"), toJson(RGBAColorTemplate.SINGLE));
        assertEquals(json("rgba_color_list"), toJson(RGBAColorTemplate.LIST));
    }

    @Test
    void serializeToYaml() throws JsonProcessingException {
        assertEquals(yaml("rgba_color"), toYaml(RGBAColorTemplate.SINGLE));
        assertEquals(yaml("rgba_color_list"), toYaml(RGBAColorTemplate.LIST));
    }

    @Test
    void serializeToToml() throws JsonProcessingException {
        assertEquals(toml("rgba_color"), toToml(RGBAColorTemplate.SINGLE));
    }
}
