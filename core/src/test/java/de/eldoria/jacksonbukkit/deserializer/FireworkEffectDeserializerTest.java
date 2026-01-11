/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import tools.jackson.core.JacksonException;
import tools.jackson.databind.JacksonModule;
import de.eldoria.jacksonbukkit.JacksonBukkit;
import de.eldoria.jacksonbukkit.CoreSerializationTest;
import de.eldoria.jacksonbukkit.serializer.NamespacedKeySerializer;
import de.eldoria.jacksonbukkit.templates.FireworkEffectTemplate;
import org.bukkit.FireworkEffect;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FireworkEffectDeserializerTest implements CoreSerializationTest {
    @Override
    public JacksonModule buildModule() {
        return new JacksonBukkit(false, NamespacedKeySerializer.Format.FULL);
    }

    @Test
    void deserializeToJson() throws JacksonException {
        assertEquals(FireworkEffectTemplate.SINGLE, fromJson("firework_effect", FireworkEffect.class));
        assertEquals(FireworkEffectTemplate.LIST, fromJsonList("firework_effect_list", FireworkEffect.class));
    }

    @Test
    void deserializeToYaml() throws JacksonException {
        assertEquals(FireworkEffectTemplate.SINGLE, fromYaml("firework_effect", FireworkEffect.class));
        assertEquals(FireworkEffectTemplate.LIST, fromYamlList("firework_effect_list", FireworkEffect.class));
    }

    @Test
    void deserializeToToml() throws JacksonException {
        assertEquals(FireworkEffectTemplate.SINGLE, fromToml("firework_effect", FireworkEffect.class));
    }
}
