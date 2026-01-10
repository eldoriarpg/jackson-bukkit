/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import be.seeseemelk.mockbukkit.MockBukkit;
import tools.jackson.core.JacksonException;
import tools.jackson.databind.JacksonModule;
import de.eldoria.jacksonbukkit.JacksonPaper;
import de.eldoria.jacksonbukkit.PaperSerializationTest;
import de.eldoria.jacksonbukkit.templates.ItemStackTemplate;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Disabled
class PaperItemStackSerializerTest implements PaperSerializationTest {
    // Mockbukkit does not support serialization to bytes
    @BeforeAll
    static void setup() {
        MockBukkit.mock();
    }

    @AfterAll
    static void tearDown() {
        MockBukkit.unmock();
    }

    @Override
    public JacksonModule buildModule() {
        return new JacksonPaper();
    }

    @Test
    void serializeToJson() throws JacksonException {
        assertEquals(json("item_stack"), toJson(ItemStackTemplate.SINGLE));
        assertEquals(json("item_stack_list"), toJson(ItemStackTemplate.LIST));
    }

    @Test
    void serializeToYaml() throws JacksonException {
        assertEquals(yaml("item_stack"), toYaml(ItemStackTemplate.SINGLE));
        assertEquals(yaml("item_stack_list"), toYaml(ItemStackTemplate.LIST));
    }

    @Test
    void serializeToToml() throws JacksonException {
        assertEquals(toml("item_stack"), toToml(ItemStackTemplate.SINGLE));
    }
}
