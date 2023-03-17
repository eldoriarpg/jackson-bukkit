package de.eldoria.jacksonbukkit.deserializer;

import be.seeseemelk.mockbukkit.MockBukkit;
import com.fasterxml.jackson.core.JsonProcessingException;
import de.eldoria.jacksonbukkit.SerializationTest;
import de.eldoria.jacksonbukkit.templates.ItemStackTemplate;
import org.bukkit.inventory.ItemStack;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BukkitItemStackDeserializerTest implements SerializationTest {
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
        assertEquals(ItemStackTemplate.SINGLE, fromJson("item_stack_bukkit", ItemStack.class));
        assertEquals(ItemStackTemplate.LIST, fromJsonList("item_stack_bukkit_list", ItemStack.class));
    }

    @Test
    void deserializeToYaml() throws JsonProcessingException {
        assertEquals(ItemStackTemplate.SINGLE, fromYaml("item_stack_bukkit", ItemStack.class));
        assertEquals(ItemStackTemplate.LIST, fromYamlList("item_stack_bukkit_list", ItemStack.class));
    }

    @Test
    void deserializeToToml() throws JsonProcessingException {
        assertEquals(ItemStackTemplate.SINGLE, fromToml("item_stack_bukkit", ItemStack.class));
    }
}
