/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import be.seeseemelk.mockbukkit.MockBukkit;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.Module;
import de.eldoria.jacksonbukkit.CoreSerializationTest;
import de.eldoria.jacksonbukkit.JacksonBukkit;
import de.eldoria.jacksonbukkit.templates.PotionEffectTemplate;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PotionEffectSerializerTest implements CoreSerializationTest {
    @Override
    public Module buildModule() {
        return new JacksonBukkit(false, NamespacedKeySerializer.Format.OBJECT);
    }

    @BeforeAll
    static void setup() {
        MockBukkit.mock();
    }

    @AfterAll
    static void afterAll() {
        MockBukkit.unmock();
    }

    @Test
    void serializeToJson() throws JsonProcessingException {
        assertEquals(json("potion_effect"), toJson(PotionEffectTemplate.SINGLE));
        assertEquals(json("potion_effect_list"), toJson(PotionEffectTemplate.LIST));
    }

    @Test
    void serializeToYaml() throws JsonProcessingException {
        assertEquals(yaml("potion_effect"), toYaml(PotionEffectTemplate.SINGLE));
        assertEquals(yaml("potion_effect_list"), toYaml(PotionEffectTemplate.LIST));
    }

    @Test
    void serializeToToml() throws JsonProcessingException {
        assertEquals(toml("potion_effect"), toToml(PotionEffectTemplate.SINGLE));
    }
}
