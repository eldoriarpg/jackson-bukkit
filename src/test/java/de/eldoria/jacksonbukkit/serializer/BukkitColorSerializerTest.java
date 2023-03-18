/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.eldoria.jacksonbukkit.SerializationTest;
import org.junit.jupiter.api.Test;

import static de.eldoria.jacksonbukkit.templates.PaperColorTemplate.LIST;
import static de.eldoria.jacksonbukkit.templates.PaperColorTemplate.SINGLE;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BukkitColorSerializerTest implements SerializationTest {


    @Test
    void serializeToJson() throws JsonProcessingException {
        assertEquals(json("bukkit_color"), toJson(SINGLE));
        assertEquals(json("bukkit_color_list"), toJson(LIST));
    }

    @Test
    void serializeToYaml() throws JsonProcessingException {
        assertEquals(yaml("bukkit_color"), toYaml(SINGLE));
        assertEquals(yaml("bukkit_color_list"), toYaml(LIST));
    }

    @Test
    void serializeToToml() throws JsonProcessingException {
        assertEquals(toml("bukkit_color"), toToml(SINGLE));
    }
}
