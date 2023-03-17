/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.eldoria.jacksonbukkit.SerializationTest;
import de.eldoria.jacksonbukkit.templates.PatternTemplate;
import org.bukkit.block.banner.Pattern;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PatternDeserializerTest implements SerializationTest {

    @Test
    void deserializeToJson() throws JsonProcessingException {
        assertEquals(PatternTemplate.SINGLE, fromJson("pattern", Pattern.class));
        assertEquals(PatternTemplate.LIST, fromJsonList("pattern_list", Pattern.class));
    }

    @Test
    void deserializeToYaml() throws JsonProcessingException {
        assertEquals(PatternTemplate.SINGLE, fromYaml("pattern", Pattern.class));
        assertEquals(PatternTemplate.LIST, fromYamlList("pattern_list", Pattern.class));
    }

    @Test
    void deserializeToToml() throws JsonProcessingException {
        assertEquals(PatternTemplate.SINGLE, fromToml("pattern", Pattern.class));
    }
}
