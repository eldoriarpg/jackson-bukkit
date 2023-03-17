/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.eldoria.jacksonbukkit.SerializationTest;
import org.bukkit.util.BoundingBox;
import org.junit.jupiter.api.Test;

import static de.eldoria.jacksonbukkit.templates.BoundingBoxTemplate.LIST;
import static de.eldoria.jacksonbukkit.templates.BoundingBoxTemplate.SINGLE;
import static org.junit.jupiter.api.Assertions.assertEquals;


class BoundingBoxDeserializerTest implements SerializationTest {

    @Test
    void deserializeFromJson() throws JsonProcessingException {
        assertEquals(SINGLE, fromJson("bounding_box", BoundingBox.class));
        assertEquals(LIST, fromJsonList("bounding_box_list", BoundingBox.class));
    }

    @Test
    void deserializeFromYaml() throws JsonProcessingException {
        assertEquals(SINGLE, fromYaml("bounding_box", BoundingBox.class));
        assertEquals(LIST, fromYamlList("bounding_box_list", BoundingBox.class));
    }

    @Test
    void deserializeFromToml() throws JsonProcessingException {
        assertEquals(SINGLE, fromToml("bounding_box", BoundingBox.class));
    }
}
