/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import tools.jackson.core.JacksonException;
import tools.jackson.databind.JacksonModule;
import de.eldoria.jacksonbukkit.JacksonPaper;
import de.eldoria.jacksonbukkit.PaperSerializationTest;
import de.eldoria.jacksonbukkit.templates.RGBAColorMigrationTemplate;
import org.bukkit.Color;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HexRGBToRGBAColorDeserializer implements PaperSerializationTest {

    @Override
    public JacksonModule buildModule() {
        return JacksonPaper.builder().colorAsHex().build();
    }

    @Test
    void deserializeFromJson() throws JacksonException {
        assertEquals(RGBAColorMigrationTemplate.SINGLE, fromJson("rgb_color_hex", Color.class));
        assertEquals(RGBAColorMigrationTemplate.LIST, fromJsonList("rgb_color_hex_list", Color.class));
    }

    @Test
    void deserializeFromYaml() throws JacksonException {
        assertEquals(RGBAColorMigrationTemplate.SINGLE, fromYaml("rgb_color_hex", Color.class));
        assertEquals(RGBAColorMigrationTemplate.LIST, fromYamlList("rgb_color_hex_list", Color.class));
    }

    // toml can't c:
    @Test
    @Disabled
    void deserializeFromToml() throws JacksonException {
        assertEquals(RGBAColorMigrationTemplate.SINGLE, fromToml("rgb_color_hex", Color.class));
    }
}
