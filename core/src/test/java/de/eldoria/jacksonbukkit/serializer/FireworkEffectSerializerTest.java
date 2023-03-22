/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.Module;
import de.eldoria.jacksonbukkit.JacksonBukkit;
import de.eldoria.jacksonbukkit.CoreSerializationTest;
import de.eldoria.jacksonbukkit.templates.FireworkEffectTemplate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FireworkEffectSerializerTest implements CoreSerializationTest {
    @Override
    public Module buildModule() {
        return new JacksonBukkit(false);
    }

    @Test
    void serializeToJson() throws JsonProcessingException {
        Assertions.assertEquals(json("firework_effect"), toJson(FireworkEffectTemplate.SINGLE));
        Assertions.assertEquals(json("firework_effect_list"), toJson(FireworkEffectTemplate.LIST));
    }

    @Test
    void serializeToYaml() throws JsonProcessingException {
        Assertions.assertEquals(yaml("firework_effect"), toYaml(FireworkEffectTemplate.SINGLE));
        Assertions.assertEquals(yaml("firework_effect_list"), toYaml(FireworkEffectTemplate.LIST));
    }

    @Test
    void serializeToToml() throws JsonProcessingException {
        Assertions.assertEquals(toml("firework_effect"), toToml(FireworkEffectTemplate.SINGLE));
    }
}
