/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import be.seeseemelk.mockbukkit.MockBukkit;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.Module;
import de.eldoria.jacksonbukkit.JacksonPaper;
import de.eldoria.jacksonbukkit.SerializationTest;
import de.eldoria.jacksonbukkit.templates.ItemStackTemplate;
import org.bukkit.inventory.ItemStack;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Disabled
class PaperItemStackDeserializerTest implements SerializationTest {

    @BeforeAll
    static void setup() {
        MockBukkit.mock();
    }

    @AfterAll
    static void tearDown() {
        MockBukkit.unmock();
    }

    @Override
    public Module buildModule() {
        return new JacksonPaper();
    }

    @Test
    void deserializeToJson() throws JsonProcessingException {
        assertEquals(ItemStackTemplate.SINGLE, fromJson("item_stack_paper", ItemStack.class));
        assertEquals(ItemStackTemplate.LIST, fromJsonList("item_stack_paper_list", ItemStack.class));
    }

    @Test
    void deserializeToYaml() throws JsonProcessingException {
        assertEquals(ItemStackTemplate.SINGLE, fromYaml("item_stack_paper", ItemStack.class));
        assertEquals(ItemStackTemplate.LIST, fromYamlList("item_stack_paper_list", ItemStack.class));
    }

    @Test
    void deserializeToToml() throws JsonProcessingException {
        assertEquals(ItemStackTemplate.SINGLE, fromToml("item_stack_paper", ItemStack.class));
    }
}
