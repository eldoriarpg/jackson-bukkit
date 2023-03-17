package de.eldoria.jacksonbukkit.deserializer;

import be.seeseemelk.mockbukkit.MockBukkit;
import com.fasterxml.jackson.core.JsonProcessingException;
import de.eldoria.jacksonbukkit.TestUtil;
import de.eldoria.jacksonbukkit.templates.PotionEffectTemplate;
import org.bukkit.potion.PotionEffect;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class PotionEffectDeserializerTest implements TestUtil {
    @BeforeAll
    static void setup() {
        MockBukkit.mock();
    }

    @Test
    void deserializeToJson() throws JsonProcessingException {
        Assertions.assertEquals(PotionEffectTemplate.SINGLE, fromJson("potion_effect", PotionEffect.class));
        Assertions.assertEquals(PotionEffectTemplate.LIST, fromJsonList("potion_effect_list", PotionEffect.class));
    }

    @Test
    void deserializeToYaml() throws JsonProcessingException {
        Assertions.assertEquals(PotionEffectTemplate.SINGLE, fromYaml("potion_effect", PotionEffect.class));
        Assertions.assertEquals(PotionEffectTemplate.LIST, fromYamlList("potion_effect_list", PotionEffect.class));
    }

    @Test
    void deserializeToToml() throws JsonProcessingException {
        Assertions.assertEquals(PotionEffectTemplate.SINGLE, fromToml("potion_effect", PotionEffect.class));
    }

    @AfterAll
    static void tearDown() {
        MockBukkit.unmock();
    }
}
