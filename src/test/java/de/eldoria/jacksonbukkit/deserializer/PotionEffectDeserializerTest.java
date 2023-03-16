package de.eldoria.jacksonbukkit.deserializer;

import be.seeseemelk.mockbukkit.MockBukkit;
import be.seeseemelk.mockbukkit.ServerMock;
import com.fasterxml.jackson.core.JsonProcessingException;
import de.eldoria.jacksonbukkit.MockServer;
import de.eldoria.jacksonbukkit.TestUtil;
import de.eldoria.jacksonbukkit.templates.NamespacedKeyTemplate;
import de.eldoria.jacksonbukkit.templates.PotionEffectTemplate;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PotionEffectDeserializerTest implements TestUtil {
    @BeforeAll
    static void setup() {
        MockServer.startServer();
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
}
