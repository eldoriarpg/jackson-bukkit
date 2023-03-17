/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import be.seeseemelk.mockbukkit.MockBukkit;
import com.fasterxml.jackson.core.JsonProcessingException;
import de.eldoria.jacksonbukkit.SerializationTest;
import de.eldoria.jacksonbukkit.entities.InventoryWrapper;
import de.eldoria.jacksonbukkit.templates.InventoryWrapperTemplate;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Disabled
class InventoryDeserializerTest implements SerializationTest {


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
        var wrapper = fromJson("inventory", InventoryWrapper.class);
        assertEquals(InventoryWrapperTemplate.SINGLE.getType(), wrapper.inventoryType());
        assertEquals(InventoryWrapperTemplate.SINGLE.getContents(), wrapper.contents());
    }

    @Test
    void deserializeToYaml() throws JsonProcessingException {
        var wrapper = fromYaml("inventory", InventoryWrapper.class);
        assertEquals(InventoryWrapperTemplate.SINGLE.getType(), wrapper.inventoryType());
        assertEquals(InventoryWrapperTemplate.SINGLE.getContents(), wrapper.contents());
    }

    @Test
    void deserializeToToml() throws JsonProcessingException {
        var wrapper = fromToml("inventory", InventoryWrapper.class);
        assertEquals(InventoryWrapperTemplate.SINGLE.getType(), wrapper.inventoryType());
        assertEquals(InventoryWrapperTemplate.SINGLE.getContents(), wrapper.contents());
    }
}
