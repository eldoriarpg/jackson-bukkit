/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.eldoria.jacksonbukkit.SerializationTest;
import org.junit.jupiter.api.Test;

import static de.eldoria.jacksonbukkit.templates.ColorTemplate.LIST;
import static de.eldoria.jacksonbukkit.templates.ColorTemplate.SINGLE;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ColorSerializerTest implements SerializationTest {


    @Test
    void serializeToJson() throws JsonProcessingException {
        assertEquals(json("color"), toJson(SINGLE));
        assertEquals(json("color_list"), toJson(LIST));
    }

    @Test
    void serializeToYaml() throws JsonProcessingException {
        assertEquals(yaml("color"), toYaml(SINGLE));
        assertEquals(yaml("color_list"), toYaml(LIST));
    }

    @Test
    void serializeoToml() throws JsonProcessingException {
        assertEquals(toml("color"), toToml(SINGLE));
    }
}
