/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import be.seeseemelk.mockbukkit.MockBukkit;
import tools.jackson.core.JacksonException;
import de.eldoria.jacksonbukkit.CoreSerializationTest;
import de.eldoria.jacksonbukkit.templates.ItemStackTemplate;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Disabled
class LegacyItemStackSerializerTest implements CoreSerializationTest {
    @BeforeAll
    static void setup() {
        MockBukkit.mock();
    }

    @AfterAll
    static void tearDown() {
        MockBukkit.unmock();
    }

    @Test
    void serializeToJson() throws JacksonException {
        assertEquals(json("item_stack_bukkit"), toJson(ItemStackTemplate.SINGLE));
        assertEquals(json("item_stack_bukkit_list"), toJson(ItemStackTemplate.LIST));
    }

    @Test
    void serializeToYaml() throws JacksonException {
        assertEquals(yaml("item_stack_bukkit"), toYaml(ItemStackTemplate.SINGLE));
        assertEquals(yaml("item_stack_bukkit_list"), toYaml(ItemStackTemplate.LIST));
    }

    @Test
    void serializeToToml() throws JacksonException {
        assertEquals(toml("item_stack_bukkit"), toToml(ItemStackTemplate.SINGLE));
    }
}
