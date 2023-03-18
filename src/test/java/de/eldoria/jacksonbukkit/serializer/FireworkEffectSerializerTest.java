/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.Module;
import de.eldoria.jacksonbukkit.JacksonPaper;
import de.eldoria.jacksonbukkit.SerializationTest;
import de.eldoria.jacksonbukkit.templates.FireworkEffectTemplate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FireworkEffectSerializerTest implements SerializationTest {
       @Override
    public Module buildModule() {
        return JacksonPaper.paper().build();
    }
 @Test
    void serializeToJson() throws JsonProcessingException {
        assertEquals(json("firework_effect"), toJson(FireworkEffectTemplate.SINGLE));
        assertEquals(json("firework_effect_list"), toJson(FireworkEffectTemplate.LIST));
    }

    @Test
    void serializeToYaml() throws JsonProcessingException {
        assertEquals(yaml("firework_effect"), toYaml(FireworkEffectTemplate.SINGLE));
        assertEquals(yaml("firework_effect_list"), toYaml(FireworkEffectTemplate.LIST));
    }

    @Test
    void serializeToToml() throws JsonProcessingException {
        assertEquals(toml("firework_effect"), toToml(FireworkEffectTemplate.SINGLE));
    }
}
