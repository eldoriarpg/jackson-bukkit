/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.eldoria.jacksonbukkit.SerializationTest;
import org.junit.jupiter.api.Test;

import static de.eldoria.jacksonbukkit.templates.BoundingBoxTemplate.LIST;
import static de.eldoria.jacksonbukkit.templates.BoundingBoxTemplate.SINGLE;
import static org.junit.jupiter.api.Assertions.assertEquals;


class BoundingBoxSerializerTest implements SerializationTest {

    @Test
    void serializeToJson() throws JsonProcessingException {
        assertEquals(json("bounding_box"), toJson(SINGLE));
        assertEquals(json("bounding_box_list"), toJson(LIST));
    }

    @Test
    void serializeToYaml() throws JsonProcessingException {
        assertEquals(yaml("bounding_box"), toYaml(SINGLE));
        assertEquals(yaml("bounding_box_list"), toYaml(LIST));
    }

    @Test
    void serializeToToml() throws JsonProcessingException {
        assertEquals(toml("bounding_box"), toToml(SINGLE));
    }
}

