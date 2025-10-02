/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.Module;
import de.eldoria.jacksonbukkit.CoreSerializationTest;
import de.eldoria.jacksonbukkit.JacksonBukkit;
import de.eldoria.jacksonbukkit.templates.EnchantmentTemplate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EnchantmentSerializerTest implements CoreSerializationTest {
    @Override
    public Module buildModule() {
        return new JacksonBukkit(false, NamespacedKeySerializer.Format.OBJECT);
    }

    @Test
    void serializeToJson() throws JsonProcessingException {
        assertEquals(json("enchantment"), toJson(EnchantmentTemplate.SINGLE));
        assertEquals(json("enchantment_list"), toJson(EnchantmentTemplate.LIST));
    }

    @Test
    void serializeToYaml() throws JsonProcessingException {
        assertEquals(yaml("enchantment"), toYaml(EnchantmentTemplate.SINGLE));
        assertEquals(yaml("enchantment_list"), toYaml(EnchantmentTemplate.LIST));
    }

    @Test
    void serializeToToml() throws JsonProcessingException {
        assertEquals(toml("enchantment"), toToml(EnchantmentTemplate.SINGLE));
    }
}
