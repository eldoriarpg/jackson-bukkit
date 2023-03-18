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
import de.eldoria.jacksonbukkit.templates.BukkitColorTemplate;
import de.eldoria.jacksonbukkit.templates.PaperColorTemplate;
import org.bukkit.Color;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HexBukkitColorDeserializerTest implements SerializationTest {
    @Override
    public Module buildModule() {
        return new JacksonBukkit(true);
    }

    @Test
    void deserializeFromJson() throws JsonProcessingException {
        assertEquals(BukkitColorTemplate.SINGLE, fromJson("bukkit_color_hex", Color.class));
        assertEquals(BukkitColorTemplate.LIST, fromJsonList("bukkit_color_hex_list", Color.class));
    }

    @Test
    void deserializeFromYaml() throws JsonProcessingException {
        assertEquals(BukkitColorTemplate.SINGLE, fromYaml("bukkit_color_hex", Color.class));
        assertEquals(BukkitColorTemplate.LIST, fromYamlList("bukkit_color_hex_list", Color.class));
    }

    // toml can't c:
    @Test
    @Disabled
    void deserializeFromToml() throws JsonProcessingException {
        assertEquals(BukkitColorTemplate.SINGLE, fromToml("bukkit_color_hex", Color.class));
    }
}
