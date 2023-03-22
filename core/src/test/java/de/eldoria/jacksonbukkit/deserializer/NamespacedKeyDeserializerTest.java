/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.eldoria.jacksonbukkit.CoreSerializationTest;
import de.eldoria.jacksonbukkit.templates.NamespacedKeyTemplate;
import org.bukkit.NamespacedKey;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class NamespacedKeyDeserializerTest implements CoreSerializationTest {

    @Test
    void deserializeToJson() throws JsonProcessingException {
        assertEquals(NamespacedKeyTemplate.SINGLE, fromJson("namespaced_key", NamespacedKey.class));
        assertEquals(NamespacedKeyTemplate.LIST, fromJsonList("namespaced_key_list", NamespacedKey.class));
    }

    @Test
    void deserializeToYaml() throws JsonProcessingException {
        assertEquals(NamespacedKeyTemplate.SINGLE, fromYaml("namespaced_key", NamespacedKey.class));
        assertEquals(NamespacedKeyTemplate.LIST, fromYamlList("namespaced_key_list", NamespacedKey.class));
    }

    @Test
    void deserializeToToml() throws JsonProcessingException {
        assertEquals(NamespacedKeyTemplate.SINGLE, fromToml("namespaced_key", NamespacedKey.class));
    }
}
