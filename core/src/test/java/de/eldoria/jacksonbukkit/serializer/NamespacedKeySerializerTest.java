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
import de.eldoria.jacksonbukkit.templates.NamespacedKeyTemplate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NamespacedKeySerializerTest implements CoreSerializationTest {
    NamespacedKeySerializer.Format format = NamespacedKeySerializer.Format.OBJECT;
    @Override
    public Module buildModule() {
        return new JacksonBukkit(false, format);
    }

    @Test
    void serializeToJsonObject() throws JsonProcessingException {
        format = NamespacedKeySerializer.Format.OBJECT;
        assertEquals(json("namespaced_key"), toJson(NamespacedKeyTemplate.SINGLE));
        assertEquals(json("namespaced_key_list"), toJson(NamespacedKeyTemplate.LIST));
    }

    @Test
    void serializeToYamlObject() throws JsonProcessingException {
        format = NamespacedKeySerializer.Format.OBJECT;
        assertEquals(yaml("namespaced_key"), toYaml(NamespacedKeyTemplate.SINGLE));
        assertEquals(yaml("namespaced_key_list"), toYaml(NamespacedKeyTemplate.LIST));
    }

    @Test
    void serializeToTomlObject() throws JsonProcessingException {
        format = NamespacedKeySerializer.Format.OBJECT;
        assertEquals(toml("namespaced_key"), toToml(NamespacedKeyTemplate.SINGLE));
    }
    @Test
    void serializeToJsonShort() throws JsonProcessingException {
        format = NamespacedKeySerializer.Format.SHORT;
        assertEquals("\"key:name\"", toJson(NamespacedKeyTemplate.SINGLE).strip());
        assertEquals("\"name\"", toJson(NamespacedKeyTemplate.SINGLE_MINECRAFT).strip());
    }

    @Test
    void serializeToYamlShort() throws JsonProcessingException {
        format = NamespacedKeySerializer.Format.SHORT;
        assertEquals("--- \"key:name\"", toYaml(NamespacedKeyTemplate.SINGLE).strip());
        assertEquals("--- \"name\"", toYaml(NamespacedKeyTemplate.SINGLE_MINECRAFT).strip());
    }

    @Test
    void serializeToTomlShort() throws JsonProcessingException {
        format = NamespacedKeySerializer.Format.SHORT;
        assertEquals("= 'key:name'", toToml(NamespacedKeyTemplate.SINGLE).strip());
        assertEquals("= 'name'", toToml(NamespacedKeyTemplate.SINGLE_MINECRAFT).strip());
    }
    @Test
    void serializeToJsonFull() throws JsonProcessingException {
        format = NamespacedKeySerializer.Format.FULL;
        assertEquals("\"key:name\"", toJson(NamespacedKeyTemplate.SINGLE).strip());
        assertEquals("\"minecraft:name\"", toJson(NamespacedKeyTemplate.SINGLE_MINECRAFT).strip());
    }

    @Test
    void serializeToYamlFull() throws JsonProcessingException {
        format = NamespacedKeySerializer.Format.FULL;
        assertEquals("--- \"key:name\"", toYaml(NamespacedKeyTemplate.SINGLE).strip());
        assertEquals("--- \"minecraft:name\"", toYaml(NamespacedKeyTemplate.SINGLE_MINECRAFT).strip());
    }

    @Test
    void serializeToTomlFull() throws JsonProcessingException {
        format = NamespacedKeySerializer.Format.FULL;
        assertEquals("= 'key:name'", toToml(NamespacedKeyTemplate.SINGLE).strip());
        assertEquals("= 'minecraft:name'", toToml(NamespacedKeyTemplate.SINGLE_MINECRAFT).strip());
    }
}
