/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.eldoria.jacksonbukkit.CoreSerializationTest;
import de.eldoria.jacksonbukkit.templates.BlockVectorTemplate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static de.eldoria.jacksonbukkit.templates.BlockVectorTemplate.LIST;
import static de.eldoria.jacksonbukkit.templates.BlockVectorTemplate.SINGLE;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BlockVectorSerializerTest implements CoreSerializationTest {

    @Test
    void serializeToJson() throws JsonProcessingException {
        Assertions.assertEquals(json("vector"), toJson(BlockVectorTemplate.SINGLE));
        Assertions.assertEquals(json("vector_list"), toJson(BlockVectorTemplate.LIST));
    }

    @Test
    void serializeToYaml() throws JsonProcessingException {
        Assertions.assertEquals(yaml("vector"), toYaml(BlockVectorTemplate.SINGLE));
        Assertions.assertEquals(yaml("vector_list"), toYaml(BlockVectorTemplate.LIST));
    }

    @Test
    void serializeToToml() throws JsonProcessingException {
        Assertions.assertEquals(toml("vector"), toToml(BlockVectorTemplate.SINGLE));
    }
}
