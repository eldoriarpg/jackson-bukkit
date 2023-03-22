/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.eldoria.jacksonbukkit.CoreSerializationTest;
import de.eldoria.jacksonbukkit.templates.NamespacedKeyTemplate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class NamespacedKeySerializerTest implements CoreSerializationTest {

    @Test
    void serializeToJson() throws JsonProcessingException {
        assertEquals(json("namespaced_key"), toJson(NamespacedKeyTemplate.SINGLE));
        assertEquals(json("namespaced_key_list"), toJson(NamespacedKeyTemplate.LIST));
    }

    @Test
    void serializeToYaml() throws JsonProcessingException {
        assertEquals(yaml("namespaced_key"), toYaml(NamespacedKeyTemplate.SINGLE));
        assertEquals(yaml("namespaced_key_list"), toYaml(NamespacedKeyTemplate.LIST));
    }

    @Test
    void serializeToToml() throws JsonProcessingException {
        assertEquals(toml("namespaced_key"), toToml(NamespacedKeyTemplate.SINGLE));
    }
}
