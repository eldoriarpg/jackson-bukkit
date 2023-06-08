/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.eldoria.jacksonbukkit.CoreSerializationTest;
import de.eldoria.jacksonbukkit.templates.FireworkEffectTemplate;
import org.bukkit.enchantments.Enchantment;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EnchantmentSerializerTest implements CoreSerializationTest {
    private static final Enchantment SINGLE = Enchantment.ARROW_FIRE;
    private static final List<Enchantment> LIST = List.of(Enchantment.ARROW_FIRE, Enchantment.RIPTIDE, Enchantment.QUICK_CHARGE);

    @Test
    void serializeToJson() throws JsonProcessingException {
        assertEquals(json("enchantment"), toJson(SINGLE));
        assertEquals(json("enchantment_list"), toJson(LIST));
    }

    @Test
    void serializeToYaml() throws JsonProcessingException {
        assertEquals(yaml("enchantment"), toYaml(SINGLE));
        assertEquals(yaml("enchantment_list"), toYaml(LIST));
    }

    @Test
    void serializeToToml() throws JsonProcessingException {
        assertEquals(toml("enchantment"), toToml(SINGLE));
    }
}
