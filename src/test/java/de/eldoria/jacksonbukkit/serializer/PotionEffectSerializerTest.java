package de.eldoria.jacksonbukkit.serializer;

import be.seeseemelk.mockbukkit.MockBukkit;
import be.seeseemelk.mockbukkit.ServerMock;
import com.fasterxml.jackson.core.JsonProcessingException;
import de.eldoria.jacksonbukkit.MockServer;
import de.eldoria.jacksonbukkit.TestUtil;
import de.eldoria.jacksonbukkit.templates.PotionEffectTemplate;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class PotionEffectSerializerTest implements TestUtil {
    @BeforeAll
    static void setup() {
        MockServer.startServer();
    }

    @Test
    void serializeToJson() throws JsonProcessingException {
        Assertions.assertEquals(json("potion_effect"), toJson(PotionEffectTemplate.SINGLE));
        Assertions.assertEquals(json("potion_effect_list"), toJson(PotionEffectTemplate.LIST));
    }

    @Test
    void serializeToYaml() throws JsonProcessingException {
        Assertions.assertEquals(yaml("potion_effect"), toYaml(PotionEffectTemplate.SINGLE));
        Assertions.assertEquals(yaml("potion_effect_list"), toYaml(PotionEffectTemplate.LIST));
    }

    @Test
    void serializeToToml() throws JsonProcessingException {
        Assertions.assertEquals(toml("potion_effect"), toToml(PotionEffectTemplate.SINGLE));
    }
}
