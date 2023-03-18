/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.Module;
import de.eldoria.jacksonbukkit.JacksonBukkit;
import de.eldoria.jacksonbukkit.SerializationTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static de.eldoria.jacksonbukkit.templates.PaperColorTemplate.LIST;
import static de.eldoria.jacksonbukkit.templates.PaperColorTemplate.SINGLE;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HexBukkitColorSerializerTest implements SerializationTest {
    @Override
    public Module buildModule() {
        return new JacksonBukkit(true);
    }

    @Test
    void serializeToJson() throws JsonProcessingException {
        assertEquals(json("bukkit_color_hex"), toJson(SINGLE));
        assertEquals(json("bukkit_color_hex_list"), toJson(LIST));
    }

    @Test
    void serializeToYaml() throws JsonProcessingException {
        assertEquals(yaml("bukkit_color_hex"), toYaml(SINGLE));
        assertEquals(yaml("bukkit_color_hex_list"), toYaml(LIST));
    }

    // toml can't c:
    @Test
    @Disabled
    void serializeToToml() throws JsonProcessingException {
        assertEquals(toml("bukkit_color_hex"), toToml(SINGLE));
    }
}
