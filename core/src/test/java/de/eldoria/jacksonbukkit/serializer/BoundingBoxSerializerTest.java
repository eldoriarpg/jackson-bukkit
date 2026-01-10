/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import tools.jackson.core.JacksonException;
import de.eldoria.jacksonbukkit.CoreSerializationTest;
import de.eldoria.jacksonbukkit.templates.BoundingBoxTemplate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static de.eldoria.jacksonbukkit.templates.BoundingBoxTemplate.LIST;
import static de.eldoria.jacksonbukkit.templates.BoundingBoxTemplate.SINGLE;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


class BoundingBoxSerializerTest implements CoreSerializationTest {

    @Test
    void serializeToJson() throws JacksonException {
        assertEquals(json("bounding_box"), toJson(BoundingBoxTemplate.SINGLE));
        assertEquals(json("bounding_box_list"), toJson(BoundingBoxTemplate.LIST));
    }

    @Test
    void serializeToYaml() throws JacksonException {
        assertEquals(yaml("bounding_box"), toYaml(BoundingBoxTemplate.SINGLE));
        assertEquals(yaml("bounding_box_list"), toYaml(BoundingBoxTemplate.LIST));
    }

    @Test
    void serializeToToml() throws JacksonException {
        assertEquals(toml("bounding_box"), toToml(BoundingBoxTemplate.SINGLE));
    }
}

