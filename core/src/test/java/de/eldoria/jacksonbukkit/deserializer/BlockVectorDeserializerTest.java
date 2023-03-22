/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.eldoria.jacksonbukkit.CoreSerializationTest;
import de.eldoria.jacksonbukkit.templates.BlockVectorTemplate;
import org.bukkit.util.BlockVector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static de.eldoria.jacksonbukkit.templates.BlockVectorTemplate.LIST;
import static de.eldoria.jacksonbukkit.templates.BlockVectorTemplate.SINGLE;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BlockVectorDeserializerTest implements CoreSerializationTest {
    @Test
    void deserializeFromJson() throws JsonProcessingException {
        Assertions.assertEquals(BlockVectorTemplate.SINGLE, fromJson("vector", BlockVector.class));
        Assertions.assertEquals(BlockVectorTemplate.LIST, fromJsonList("vector_list", BlockVector.class));
    }

    @Test
    void deserializeFromYaml() throws JsonProcessingException {
        Assertions.assertEquals(BlockVectorTemplate.SINGLE, fromYaml("vector", BlockVector.class));
        Assertions.assertEquals(BlockVectorTemplate.LIST, fromYamlList("vector_list", BlockVector.class));
    }

    @Test
    void deserializeFromToml() throws JsonProcessingException {
        Assertions.assertEquals(BlockVectorTemplate.SINGLE, fromToml("vector", BlockVector.class));
    }

}
