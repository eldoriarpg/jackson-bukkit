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
        assertEquals(NamespacedKeyTemplate.SINGLE, json().readValue("\"key:name\"", NamespacedKey.class));
        assertEquals(NamespacedKeyTemplate.SINGLE_MINECRAFT, json().readValue("\"name\"", NamespacedKey.class));
        assertEquals(NamespacedKeyTemplate.SINGLE_MINECRAFT, json().readValue("\"minecraft:name\"", NamespacedKey.class));
    }

    @Test
    void deserializeObjectToYaml() throws JsonProcessingException {
        assertEquals(NamespacedKeyTemplate.SINGLE, fromYaml("namespaced_key", NamespacedKey.class));
        assertEquals(NamespacedKeyTemplate.LIST, fromYamlList("namespaced_key_list", NamespacedKey.class));
        assertEquals(NamespacedKeyTemplate.SINGLE_MINECRAFT, yaml().readValue("--- \"minecraft:name\"", NamespacedKey.class));
        assertEquals(NamespacedKeyTemplate.SINGLE_MINECRAFT, yaml().readValue("--- \"name\"", NamespacedKey.class));
        assertEquals(NamespacedKeyTemplate.SINGLE, yaml().readValue("--- \"key:name\"", NamespacedKey.class));
    }

    @Test
    void deserializeObjectToToml() throws JsonProcessingException {
        assertEquals(NamespacedKeyTemplate.SINGLE, fromToml("namespaced_key", NamespacedKey.class));
    }
}
