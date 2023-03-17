/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import be.seeseemelk.mockbukkit.MockBukkit;
import com.fasterxml.jackson.core.JsonProcessingException;
import de.eldoria.jacksonbukkit.SerializationTest;
import de.eldoria.jacksonbukkit.templates.ItemStackTemplate;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Disabled
class BukkitItemStackSerializerTest implements SerializationTest {
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
        assertEquals(json("item_stack_bukkit"), toJson(ItemStackTemplate.SINGLE));
        assertEquals(json("item_stack_bukkit_list"), toJson(ItemStackTemplate.LIST));
    }

    @Test
    void serializeToYaml() throws JsonProcessingException {
        assertEquals(yaml("item_stack_bukkit"), toYaml(ItemStackTemplate.SINGLE));
        assertEquals(yaml("item_stack_bukkit_list"), toYaml(ItemStackTemplate.LIST));
    }

    @Test
    void serializeToToml() throws JsonProcessingException {
        assertEquals(toml("item_stack_bukkit"), toToml(ItemStackTemplate.SINGLE));
    }
}
