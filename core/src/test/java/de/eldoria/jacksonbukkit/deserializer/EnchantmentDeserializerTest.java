/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import be.seeseemelk.mockbukkit.MockBukkit;
import com.fasterxml.jackson.core.JsonProcessingException;
import de.eldoria.jacksonbukkit.CoreSerializationTest;
import de.eldoria.jacksonbukkit.templates.EnchantmentTemplate;
import org.bukkit.enchantments.Enchantment;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EnchantmentDeserializerTest implements CoreSerializationTest {
    @BeforeAll
    static void beforeAll() {
        MockBukkit.mock();
    }

    @Test
    void deserializeFromJson() throws JsonProcessingException {
        assertEquals(EnchantmentTemplate.SINGLE, fromJson("enchantment", Enchantment.class));
        assertEquals(EnchantmentTemplate.LIST, fromJsonList("enchantment_list", Enchantment.class));
    }

    @Test
    void deserializeFromYaml() throws JsonProcessingException {
        assertEquals(EnchantmentTemplate.SINGLE, fromYaml("enchantment", Enchantment.class));
        assertEquals(EnchantmentTemplate.LIST, fromYamlList("enchantment_list", Enchantment.class));
    }

    @Test
    void deserializeFromToml() throws JsonProcessingException {
        assertEquals(EnchantmentTemplate.SINGLE, fromToml("enchantment", Enchantment.class));
    }

    @AfterAll
    static void afterAll() {
        MockBukkit.unmock();
    }
}
