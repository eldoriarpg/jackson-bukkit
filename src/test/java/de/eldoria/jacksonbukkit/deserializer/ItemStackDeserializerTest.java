package de.eldoria.jacksonbukkit.deserializer;

import be.seeseemelk.mockbukkit.MockBukkit;
import com.fasterxml.jackson.core.JsonProcessingException;
import de.eldoria.jacksonbukkit.TestUtil;
import de.eldoria.jacksonbukkit.templates.ItemStackTemplate;
import org.bukkit.inventory.ItemStack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled
class ItemStackDeserializerTest implements TestUtil {

    @BeforeAll
    static void setup() {
        MockBukkit.mock();
    }

    @Test
    void deserializeToJson() throws JsonProcessingException {
        Assertions.assertEquals(ItemStackTemplate.SINGLE, fromJson("item_stack", ItemStack.class));
        Assertions.assertEquals(ItemStackTemplate.LIST, fromJsonList("item_stack_list", ItemStack.class));
    }

    @Test
    void deserializeToYaml() throws JsonProcessingException {
        Assertions.assertEquals(ItemStackTemplate.SINGLE, fromYaml("item_stack", ItemStack.class));
        Assertions.assertEquals(ItemStackTemplate.LIST, fromYamlList("item_stack_list", ItemStack.class));
    }

    @Test
    void deserializeToToml() throws JsonProcessingException {
        Assertions.assertEquals(ItemStackTemplate.SINGLE, fromToml("item_stack", ItemStack.class));
    }
}
