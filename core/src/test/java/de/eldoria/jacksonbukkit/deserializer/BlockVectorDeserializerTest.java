/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import tools.jackson.core.JacksonException;
import de.eldoria.jacksonbukkit.CoreSerializationTest;
import de.eldoria.jacksonbukkit.templates.BlockVectorTemplate;
import org.bukkit.util.BlockVector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static de.eldoria.jacksonbukkit.templates.BlockVectorTemplate.LIST;
import static de.eldoria.jacksonbukkit.templates.BlockVectorTemplate.SINGLE;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BlockVectorDeserializerTest implements CoreSerializationTest {
    @Test
    void deserializeFromJson() throws JacksonException {
        assertEquals(BlockVectorTemplate.SINGLE, fromJson("vector", BlockVector.class));
        assertEquals(BlockVectorTemplate.LIST, fromJsonList("vector_list", BlockVector.class));
    }

    @Test
    void deserializeFromYaml() throws JacksonException {
        assertEquals(BlockVectorTemplate.SINGLE, fromYaml("vector", BlockVector.class));
        assertEquals(BlockVectorTemplate.LIST, fromYamlList("vector_list", BlockVector.class));
    }

    @Test
    void deserializeFromToml() throws JacksonException {
        assertEquals(BlockVectorTemplate.SINGLE, fromToml("vector", BlockVector.class));
    }

}
