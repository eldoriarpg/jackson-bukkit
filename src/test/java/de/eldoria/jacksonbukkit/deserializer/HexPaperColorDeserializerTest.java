/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.Module;
import de.eldoria.jacksonbukkit.JacksonBukkit;
import de.eldoria.jacksonbukkit.SerializationTest;
import de.eldoria.jacksonbukkit.templates.PaperColorTemplate;
import org.bukkit.Color;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HexPaperColorDeserializerTest implements SerializationTest {
    @Override
    public Module buildModule() {
        return JacksonBukkit.paper().colorAsHex().build();
    }

    @Test
    void deserializeFromJson() throws JsonProcessingException {
        assertEquals(PaperColorTemplate.SINGLE, fromJson("paper_color_hex", Color.class));
        assertEquals(PaperColorTemplate.LIST, fromJsonList("paper_color_hex_list", Color.class));
    }

    @Test
    void deserializeFromYaml() throws JsonProcessingException {
        assertEquals(PaperColorTemplate.SINGLE, fromYaml("paper_color_hex", Color.class));
        assertEquals(PaperColorTemplate.LIST, fromYamlList("paper_color_hex_list", Color.class));
    }

    // toml can't c:
    @Test
    @Disabled
    void deserializeFromToml() throws JsonProcessingException {
        assertEquals(PaperColorTemplate.SINGLE, fromToml("paper_color_hex", Color.class));
    }
}
