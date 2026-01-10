/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import tools.jackson.core.JacksonException;
import tools.jackson.databind.JacksonModule;
import de.eldoria.jacksonbukkit.CoreSerializationTest;
import de.eldoria.jacksonbukkit.JacksonBukkit;
import de.eldoria.jacksonbukkit.templates.EnchantmentTemplate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EnchantmentSerializerTest implements CoreSerializationTest {
    @Override
    public JacksonModule buildModule() {
        return new JacksonBukkit(false, NamespacedKeySerializer.Format.OBJECT);
    }

    @Test
    void serializeToJson() throws JacksonException {
        assertEquals(json("enchantment"), toJson(EnchantmentTemplate.SINGLE));
        assertEquals(json("enchantment_list"), toJson(EnchantmentTemplate.LIST));
    }

    @Test
    void serializeToYaml() throws JacksonException {
        assertEquals(yaml("enchantment"), toYaml(EnchantmentTemplate.SINGLE));
        assertEquals(yaml("enchantment_list"), toYaml(EnchantmentTemplate.LIST));
    }

    @Test
    void serializeToToml() throws JacksonException {
        assertEquals(toml("enchantment"), toToml(EnchantmentTemplate.SINGLE));
    }
}
