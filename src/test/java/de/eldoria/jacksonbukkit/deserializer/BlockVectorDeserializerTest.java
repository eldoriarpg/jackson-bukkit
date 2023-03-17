/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.eldoria.jacksonbukkit.SerializationTest;
import org.bukkit.util.BlockVector;
import org.junit.jupiter.api.Test;

import static de.eldoria.jacksonbukkit.templates.BlockVectorTemplate.LIST;
import static de.eldoria.jacksonbukkit.templates.BlockVectorTemplate.SINGLE;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BlockVectorDeserializerTest implements SerializationTest {
    @Test
    void deserializeFromJson() throws JsonProcessingException {
        assertEquals(SINGLE, fromJson("vector", BlockVector.class));
        assertEquals(LIST, fromJsonList("vector_list", BlockVector.class));
    }

    @Test
    void deserializeFromYaml() throws JsonProcessingException {
        assertEquals(SINGLE, fromYaml("vector", BlockVector.class));
        assertEquals(LIST, fromYamlList("vector_list", BlockVector.class));
    }

    @Test
    void deserializeFromToml() throws JsonProcessingException {
        assertEquals(SINGLE, fromToml("vector", BlockVector.class));
    }

}
