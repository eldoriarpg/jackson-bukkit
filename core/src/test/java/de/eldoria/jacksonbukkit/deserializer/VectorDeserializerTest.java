/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import tools.jackson.core.JacksonException;
import de.eldoria.jacksonbukkit.CoreSerializationTest;
import de.eldoria.jacksonbukkit.templates.VectorTemplate;
import org.bukkit.util.Vector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class VectorDeserializerTest implements CoreSerializationTest {

    @Test
    void deserializeToJson() throws JacksonException {
        assertEquals(VectorTemplate.SINGLE, fromJson("vector", Vector.class));
        assertEquals(VectorTemplate.LIST, fromJsonList("vector_list", Vector.class));
    }

    @Test
    void deserializeToYaml() throws JacksonException {
        assertEquals(VectorTemplate.SINGLE, fromYaml("vector", Vector.class));
        assertEquals(VectorTemplate.LIST, fromYamlList("vector_list", Vector.class));
    }

    @Test
    void deserializeToToml() throws JacksonException {
        assertEquals(VectorTemplate.SINGLE, fromToml("vector", Vector.class));
    }
}
