package de.eldoria.jacksonbukkit.deserializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.eldoria.jacksonbukkit.TestUtil;
import de.eldoria.jacksonbukkit.templates.NamespacedKeyTemplate;
import org.bukkit.inventory.ItemStack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NamespacedKeyDeserializerTest implements TestUtil {

    @Test
    void deserializeToJson() throws JsonProcessingException {
        Assertions.assertEquals(NamespacedKeyTemplate.SINGLE, fromJson("namespaced_key", ItemStack.class));
        Assertions.assertEquals(NamespacedKeyTemplate.LIST, fromJsonList("item_stack_list", ItemStack.class));
    }

    @Test
    void deserializeToYaml() throws JsonProcessingException {
        Assertions.assertEquals(NamespacedKeyTemplate.SINGLE, fromYaml("item_stack", ItemStack.class));
        Assertions.assertEquals(NamespacedKeyTemplate.LIST, fromYamlList("item_stack_list", ItemStack.class));
    }

    @Test
    void deserializeToToml() throws JsonProcessingException {
        Assertions.assertEquals(NamespacedKeyTemplate.SINGLE, fromToml("item_stack", ItemStack.class));
    }
}
