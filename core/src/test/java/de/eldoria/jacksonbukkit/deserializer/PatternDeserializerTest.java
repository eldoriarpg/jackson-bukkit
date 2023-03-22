/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.eldoria.jacksonbukkit.CoreSerializationTest;
import de.eldoria.jacksonbukkit.templates.PatternTemplate;
import org.bukkit.block.banner.Pattern;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PatternDeserializerTest implements CoreSerializationTest {

    @Test
    void deserializeToJson() throws JsonProcessingException {
        Assertions.assertEquals(PatternTemplate.SINGLE, fromJson("pattern", Pattern.class));
        Assertions.assertEquals(PatternTemplate.LIST, fromJsonList("pattern_list", Pattern.class));
    }

    @Test
    void deserializeToYaml() throws JsonProcessingException {
        Assertions.assertEquals(PatternTemplate.SINGLE, fromYaml("pattern", Pattern.class));
        Assertions.assertEquals(PatternTemplate.LIST, fromYamlList("pattern_list", Pattern.class));
    }

    @Test
    void deserializeToToml() throws JsonProcessingException {
        Assertions.assertEquals(PatternTemplate.SINGLE, fromToml("pattern", Pattern.class));
    }
}
