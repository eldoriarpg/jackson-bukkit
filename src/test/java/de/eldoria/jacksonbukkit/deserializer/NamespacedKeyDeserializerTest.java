package de.eldoria.jacksonbukkit.deserializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.eldoria.jacksonbukkit.TestUtil;
import de.eldoria.jacksonbukkit.templates.NamespacedKeyTemplate;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NamespacedKeyDeserializerTest implements TestUtil {

    @Test
    void deserializeToJson() throws JsonProcessingException {
        Assertions.assertEquals(NamespacedKeyTemplate.SINGLE, fromJson("namespaced_key", NamespacedKey.class));
        Assertions.assertEquals(NamespacedKeyTemplate.LIST, fromJsonList("namespaced_key_list", NamespacedKey.class));
    }

    @Test
    void deserializeToYaml() throws JsonProcessingException {
        Assertions.assertEquals(NamespacedKeyTemplate.SINGLE, fromYaml("namespaced_key", NamespacedKey.class));
        Assertions.assertEquals(NamespacedKeyTemplate.LIST, fromYamlList("namespaced_key_list", NamespacedKey.class));
    }

    @Test
    void deserializeToToml() throws JsonProcessingException {
        Assertions.assertEquals(NamespacedKeyTemplate.SINGLE, fromToml("namespaced_key", NamespacedKey.class));
    }
}
