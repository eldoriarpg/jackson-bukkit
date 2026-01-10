/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import tools.jackson.core.JacksonException;
import tools.jackson.databind.JacksonModule;
import de.eldoria.jacksonbukkit.JacksonBukkit;
import de.eldoria.jacksonbukkit.CoreSerializationTest;
import de.eldoria.jacksonbukkit.templates.FireworkEffectTemplate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FireworkEffectSerializerTest implements CoreSerializationTest {
    @Override
    public JacksonModule buildModule() {
        return new JacksonBukkit(false, NamespacedKeySerializer.Format.FULL);
    }

    @Test
    void serializeToJson() throws JacksonException {
        assertEquals(json("firework_effect"), toJson(FireworkEffectTemplate.SINGLE));
        assertEquals(json("firework_effect_list"), toJson(FireworkEffectTemplate.LIST));
    }

    @Test
    void serializeToYaml() throws JacksonException {
        assertEquals(yaml("firework_effect"), toYaml(FireworkEffectTemplate.SINGLE));
        assertEquals(yaml("firework_effect_list"), toYaml(FireworkEffectTemplate.LIST));
    }

    @Test
    void serializeToToml() throws JacksonException {
        assertEquals(toml("firework_effect"), toToml(FireworkEffectTemplate.SINGLE));
    }
}
