/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.eldoria.jacksonbukkit.CoreSerializationTest;
import de.eldoria.jacksonbukkit.templates.PatternTemplate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PatternSerializerTest implements CoreSerializationTest {
    @Test
    void serializeToJson() throws JsonProcessingException {
        assertEquals(json("pattern"), toJson(PatternTemplate.SINGLE));
        assertEquals(json("pattern_list"), toJson(PatternTemplate.LIST));
    }

    @Test
    void serializeToYaml() throws JsonProcessingException {
        assertEquals(yaml("pattern"), toYaml(PatternTemplate.SINGLE));
        assertEquals(yaml("pattern_list"), toYaml(PatternTemplate.LIST));
    }

    @Test
    void serializeToToml() throws JsonProcessingException {
        assertEquals(toml("pattern"), toToml(PatternTemplate.SINGLE));
    }

}
