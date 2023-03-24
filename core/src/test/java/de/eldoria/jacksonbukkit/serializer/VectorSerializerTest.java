/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.eldoria.jacksonbukkit.CoreSerializationTest;
import de.eldoria.jacksonbukkit.templates.VectorTemplate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class VectorSerializerTest implements CoreSerializationTest {

    @Test
    void serializeToJson() throws JsonProcessingException {
        assertEquals(json("vector"), toJson(VectorTemplate.SINGLE));
        assertEquals(json("vector_list"), toJson(VectorTemplate.LIST));
    }

    @Test
    void serializeToYaml() throws JsonProcessingException {
        assertEquals(yaml("vector"), toYaml(VectorTemplate.SINGLE));
        assertEquals(yaml("vector_list"), toYaml(VectorTemplate.LIST));
    }

    @Test
    void serializeToToml() throws JsonProcessingException {
        assertEquals(toml("vector"), toToml(VectorTemplate.SINGLE));
    }
}
