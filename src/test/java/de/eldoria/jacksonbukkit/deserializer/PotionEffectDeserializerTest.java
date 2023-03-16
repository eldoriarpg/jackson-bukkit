package de.eldoria.jacksonbukkit.deserializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.eldoria.jacksonbukkit.TestUtil;
import de.eldoria.jacksonbukkit.templates.NamespacedKeyTemplate;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PotionEffectDeserializerTest implements TestUtil {

    @Test
    void deserializeToJson() throws JsonProcessingException {
        Assertions.assertEquals(NamespacedKeyTemplate.SINGLE, fromJson("potion_effect", PotionEffect.class));
        Assertions.assertEquals(NamespacedKeyTemplate.LIST, fromJsonList("potion_effect_list", PotionEffect.class));
    }

    @Test
    void deserializeToYaml() throws JsonProcessingException {
        Assertions.assertEquals(NamespacedKeyTemplate.SINGLE, fromYaml("potion_effect", PotionEffect.class));
        Assertions.assertEquals(NamespacedKeyTemplate.LIST, fromYamlList("potion_effect_list", PotionEffect.class));
    }

    @Test
    void deserializeToToml() throws JsonProcessingException {
        Assertions.assertEquals(NamespacedKeyTemplate.SINGLE, fromToml("potion_effect", PotionEffect.class));
    }
}
