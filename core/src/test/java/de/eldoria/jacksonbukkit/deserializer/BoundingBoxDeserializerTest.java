/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import tools.jackson.core.JacksonException;
import de.eldoria.jacksonbukkit.CoreSerializationTest;
import de.eldoria.jacksonbukkit.templates.BoundingBoxTemplate;
import org.bukkit.util.BoundingBox;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static de.eldoria.jacksonbukkit.templates.BoundingBoxTemplate.LIST;
import static de.eldoria.jacksonbukkit.templates.BoundingBoxTemplate.SINGLE;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


class BoundingBoxDeserializerTest implements CoreSerializationTest {

    @Test
    void deserializeFromJson() throws JacksonException {
        assertEquals(BoundingBoxTemplate.SINGLE, fromJson("bounding_box", BoundingBox.class));
        assertEquals(BoundingBoxTemplate.LIST, fromJsonList("bounding_box_list", BoundingBox.class));
    }

    @Test
    void deserializeFromYaml() throws JacksonException {
        assertEquals(BoundingBoxTemplate.SINGLE, fromYaml("bounding_box", BoundingBox.class));
        assertEquals(BoundingBoxTemplate.LIST, fromYamlList("bounding_box_list", BoundingBox.class));
    }

    @Test
    void deserializeFromToml() throws JacksonException {
        assertEquals(BoundingBoxTemplate.SINGLE, fromToml("bounding_box", BoundingBox.class));
    }
}
