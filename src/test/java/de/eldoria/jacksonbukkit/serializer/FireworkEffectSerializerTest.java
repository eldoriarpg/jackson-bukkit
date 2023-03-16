package de.eldoria.jacksonbukkit.serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.eldoria.jacksonbukkit.TestUtil;
import de.eldoria.jacksonbukkit.templates.FireworkEffectTemplate;
import de.eldoria.jacksonbukkit.templates.ItemStackTemplate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FireworkEffectSerializerTest implements TestUtil {
    @Test
    void serializeToJson() throws JsonProcessingException {
        Assertions.assertEquals(json("firework_effect"), toJson(FireworkEffectTemplate.SINGLE));
        Assertions.assertEquals(json("firework_effect_list"), toJson(FireworkEffectTemplate.LIST));
    }

    @Test
    void serializeToYaml() throws JsonProcessingException {
        Assertions.assertEquals(yaml("firework_effect"), toYaml(FireworkEffectTemplate.SINGLE));
        Assertions.assertEquals(yaml("firework_effect_list"), toYaml(FireworkEffectTemplate.LIST));
    }

    @Test
    void serializeToToml() throws JsonProcessingException {
        Assertions.assertEquals(toml("firework_effect"), toToml(FireworkEffectTemplate.SINGLE));
    }

}
