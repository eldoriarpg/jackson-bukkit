/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import be.seeseemelk.mockbukkit.MockBukkit;
import com.fasterxml.jackson.core.JsonProcessingException;
import de.eldoria.jacksonbukkit.SerializationTest;
import de.eldoria.jacksonbukkit.templates.PotionEffectTemplate;
import org.bukkit.potion.PotionEffect;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PotionEffectDeserializerTest implements SerializationTest {
    @BeforeAll
    static void setup() {
        MockBukkit.mock();
    }

    @AfterAll
    static void tearDown() {
        MockBukkit.unmock();
    }

    @Test
    void deserializeToJson() throws JsonProcessingException {
        assertEquals(PotionEffectTemplate.SINGLE, fromJson("potion_effect", PotionEffect.class));
        assertEquals(PotionEffectTemplate.LIST, fromJsonList("potion_effect_list", PotionEffect.class));
    }

    @Test
    void deserializeToYaml() throws JsonProcessingException {
        assertEquals(PotionEffectTemplate.SINGLE, fromYaml("potion_effect", PotionEffect.class));
        assertEquals(PotionEffectTemplate.LIST, fromYamlList("potion_effect_list", PotionEffect.class));
    }

    @Test
    void deserializeToToml() throws JsonProcessingException {
        assertEquals(PotionEffectTemplate.SINGLE, fromToml("potion_effect", PotionEffect.class));
    }
}
