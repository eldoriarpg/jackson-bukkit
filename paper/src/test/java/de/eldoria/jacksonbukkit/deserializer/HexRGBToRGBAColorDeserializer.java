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
import de.eldoria.jacksonbukkit.templates.RGBAColorMigrationTemplate;
import org.bukkit.Color;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HexRGBToRGBAColorDeserializer implements PaperSerializationTest {

    @Override
    public Module buildModule() {
        return JacksonPaper.builder().colorAsHex().build();
    }

    @Test
    void deserializeFromJson() throws JsonProcessingException {
        assertEquals(RGBAColorMigrationTemplate.SINGLE, fromJson("rgb_color_hex", Color.class));
        assertEquals(RGBAColorMigrationTemplate.LIST, fromJsonList("rgb_color_hex_list", Color.class));
    }

    @Test
    void deserializeFromYaml() throws JsonProcessingException {
        assertEquals(RGBAColorMigrationTemplate.SINGLE, fromYaml("rgb_color_hex", Color.class));
        assertEquals(RGBAColorMigrationTemplate.LIST, fromYamlList("rgb_color_hex_list", Color.class));
    }

    // toml can't c:
    @Test
    @Disabled
    void deserializeFromToml() throws JsonProcessingException {
        assertEquals(RGBAColorMigrationTemplate.SINGLE, fromToml("rgb_color_hex", Color.class));
    }
}
