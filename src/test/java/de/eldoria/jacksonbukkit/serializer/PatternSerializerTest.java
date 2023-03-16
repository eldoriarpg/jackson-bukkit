package de.eldoria.jacksonbukkit.serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.eldoria.jacksonbukkit.TestUtil;
import de.eldoria.jacksonbukkit.templates.PatternTemplate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PatternSerializerTest implements TestUtil {
    @Test
    void serializeToJson() throws JsonProcessingException {
        Assertions.assertEquals(json("pattern"), toJson(PatternTemplate.SINGLE));
        Assertions.assertEquals(json("pattern_list"), toJson(PatternTemplate.LIST));
    }

    @Test
    void serializeToYaml() throws JsonProcessingException {
        Assertions.assertEquals(yaml("pattern"), toYaml(PatternTemplate.SINGLE));
        Assertions.assertEquals(yaml("pattern_list"), toYaml(PatternTemplate.LIST));
    }

    @Test
    void serializeToToml() throws JsonProcessingException {
        Assertions.assertEquals(toml("pattern"), toToml(PatternTemplate.SINGLE));
    }

}
