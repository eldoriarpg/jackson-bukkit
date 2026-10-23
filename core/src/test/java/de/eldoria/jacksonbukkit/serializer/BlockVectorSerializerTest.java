/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import de.eldoria.jacksonbukkit.CoreSerializationTest;
import de.eldoria.jacksonbukkit.templates.BlockVectorTemplate;
import org.junit.jupiter.api.Test;
import tools.jackson.core.JacksonException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BlockVectorSerializerTest implements CoreSerializationTest {

    @Test
    void serializeToJson() throws JacksonException {
        assertEquals(json("vector"), toJson(BlockVectorTemplate.SINGLE));
        assertEquals(json("vector_list"), toJson(BlockVectorTemplate.LIST));
    }

    @Test
    void serializeToYaml() throws JacksonException {
        assertEquals(yaml("vector"), toYaml(BlockVectorTemplate.SINGLE));
        assertEquals(yaml("vector_list"), toYaml(BlockVectorTemplate.LIST));
    }

    @Test
    void serializeToToml() throws JacksonException {
        assertEquals(toml("vector"), toToml(BlockVectorTemplate.SINGLE));
    }
}
