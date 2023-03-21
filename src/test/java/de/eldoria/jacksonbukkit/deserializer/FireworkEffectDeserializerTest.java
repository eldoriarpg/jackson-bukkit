/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.Module;
import de.eldoria.jacksonbukkit.JacksonPaper;
import de.eldoria.jacksonbukkit.SerializationTest;
import de.eldoria.jacksonbukkit.templates.FireworkEffectTemplate;
import org.bukkit.FireworkEffect;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FireworkEffectDeserializerTest implements SerializationTest {
        @Override
    public Module buildModule() {
        return JacksonPaper.paper().build();
    }
    @Test
    void deserializeToJson() throws JsonProcessingException {
        assertEquals(FireworkEffectTemplate.SINGLE, fromJson("firework_effect", FireworkEffect.class));
        assertEquals(FireworkEffectTemplate.LIST, fromJsonList("firework_effect_list", FireworkEffect.class));
    }

    @Test
    void deserializeToYaml() throws JsonProcessingException {
        assertEquals(FireworkEffectTemplate.SINGLE, fromYaml("firework_effect", FireworkEffect.class));
        assertEquals(FireworkEffectTemplate.LIST, fromYamlList("firework_effect_list", FireworkEffect.class));
    }

    @Test
    void deserializeToToml() throws JsonProcessingException {
        assertEquals(FireworkEffectTemplate.SINGLE, fromToml("firework_effect", FireworkEffect.class));
    }
}
