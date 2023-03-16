package de.eldoria.jacksonbukkit.deserializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.eldoria.jacksonbukkit.TestUtil;
import de.eldoria.jacksonbukkit.templates.FireworkEffectTemplate;
import de.eldoria.jacksonbukkit.templates.NamespacedKeyTemplate;
import org.bukkit.FireworkEffect;
import org.bukkit.NamespacedKey;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FireworkEffectDeserializerTest implements TestUtil {
    @Test
    void deserializeToJson() throws JsonProcessingException {
        Assertions.assertEquals(FireworkEffectTemplate.SINGLE, fromJson("firework_effect", FireworkEffect.class));
        Assertions.assertEquals(FireworkEffectTemplate.LIST, fromJsonList("firework_effect_list", FireworkEffect.class));
    }

    @Test
    void deserializeToYaml() throws JsonProcessingException {
        Assertions.assertEquals(FireworkEffectTemplate.SINGLE, fromYaml("firework_effect", FireworkEffect.class));
        Assertions.assertEquals(FireworkEffectTemplate.LIST, fromYamlList("firework_effect_list", FireworkEffect.class));
    }

    @Test
    void deserializeToToml() throws JsonProcessingException {
        Assertions.assertEquals(FireworkEffectTemplate.SINGLE, fromToml("firework_effect", FireworkEffect.class));
    }

}
