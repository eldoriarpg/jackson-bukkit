/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import tools.jackson.core.JacksonException;
import de.eldoria.jacksonbukkit.CoreSerializationTest;
import de.eldoria.jacksonbukkit.templates.PatternTemplate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PatternSerializerTest implements CoreSerializationTest {
    @Test
    void serializeToJson() throws JacksonException {
        assertEquals(json("pattern"), toJson(PatternTemplate.SINGLE));
        assertEquals(json("pattern_list"), toJson(PatternTemplate.LIST));
    }

    @Test
    void serializeToYaml() throws JacksonException {
        assertEquals(yaml("pattern"), toYaml(PatternTemplate.SINGLE));
        assertEquals(yaml("pattern_list"), toYaml(PatternTemplate.LIST));
    }

    @Test
    void serializeToToml() throws JacksonException {
        assertEquals(toml("pattern"), toToml(PatternTemplate.SINGLE));
    }

}
