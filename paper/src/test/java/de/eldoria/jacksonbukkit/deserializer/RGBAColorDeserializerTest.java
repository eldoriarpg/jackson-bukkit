/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.Module;
import de.eldoria.jacksonbukkit.JacksonPaper;
import de.eldoria.jacksonbukkit.PaperSerializationTest;
import de.eldoria.jacksonbukkit.templates.RGBAColorTemplate;
import org.bukkit.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RGBAColorDeserializerTest implements PaperSerializationTest {
    @Override
    public Module buildModule() {
        return JacksonPaper.builder().build();
    }

    @Test
    void deserializeFromJson() throws JsonProcessingException {
        Assertions.assertEquals(RGBAColorTemplate.SINGLE, fromJson("rgba_color", Color.class));
        assertEquals(RGBAColorTemplate.LIST, fromJsonList("rgba_color_list", Color.class));
    }

    @Test
    void deserializeFromYaml() throws JsonProcessingException {
        Assertions.assertEquals(RGBAColorTemplate.SINGLE, fromYaml("rgba_color", Color.class));
        assertEquals(RGBAColorTemplate.LIST, fromYamlList("rgba_color_list", Color.class));
    }

    @Test
    void deserializeFromToml() throws JsonProcessingException {
        Assertions.assertEquals(RGBAColorTemplate.SINGLE, fromToml("rgba_color", Color.class));
    }
}
