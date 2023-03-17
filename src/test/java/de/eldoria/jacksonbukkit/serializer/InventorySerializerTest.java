/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import be.seeseemelk.mockbukkit.MockBukkit;
import com.fasterxml.jackson.core.JsonProcessingException;
import de.eldoria.jacksonbukkit.SerializationTest;
import de.eldoria.jacksonbukkit.templates.InventoryWrapperTemplate;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Disabled
class InventorySerializerTest implements SerializationTest {


    // Mockbukkit does not support serialization to bytes
    @BeforeAll
    static void setup() {
        MockBukkit.mock();
    }

    @AfterAll
    static void tearDown() {
        MockBukkit.unmock();
    }

    @Test
    void serializeToJson() throws JsonProcessingException {
        assertEquals(json("inventory"), toJson(InventoryWrapperTemplate.SINGLE));
    }

    @Test
    void serializeToYaml() throws JsonProcessingException {
        assertEquals(yaml("inventory"), toYaml(InventoryWrapperTemplate.SINGLE));
    }

    @Test
    void serializeToToml() throws JsonProcessingException {
        assertEquals(toml("inventory"), toToml(InventoryWrapperTemplate.SINGLE));
    }
}
