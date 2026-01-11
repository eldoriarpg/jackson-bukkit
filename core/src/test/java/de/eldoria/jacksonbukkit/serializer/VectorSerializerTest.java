/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import tools.jackson.core.JacksonException;
import de.eldoria.jacksonbukkit.CoreSerializationTest;
import de.eldoria.jacksonbukkit.templates.VectorTemplate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class VectorSerializerTest implements CoreSerializationTest {

    @Test
    void serializeToJson() throws JacksonException {
        assertEquals(json("vector"), toJson(VectorTemplate.SINGLE));
        assertEquals(json("vector_list"), toJson(VectorTemplate.LIST));
    }

    @Test
    void serializeToYaml() throws JacksonException {
        assertEquals(yaml("vector"), toYaml(VectorTemplate.SINGLE));
        assertEquals(yaml("vector_list"), toYaml(VectorTemplate.LIST));
    }

    @Test
    void serializeToToml() throws JacksonException {
        assertEquals(toml("vector"), toToml(VectorTemplate.SINGLE));
    }
}
