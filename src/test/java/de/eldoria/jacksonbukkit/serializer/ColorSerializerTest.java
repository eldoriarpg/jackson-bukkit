package de.eldoria.jacksonbukkit.serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.eldoria.jacksonbukkit.TestUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static de.eldoria.jacksonbukkit.templates.ColorTemplate.SINGLE;
import static de.eldoria.jacksonbukkit.templates.ColorTemplate.LIST;

class ColorSerializerTest implements TestUtil {


    @Test
    void serializeToJson() throws JsonProcessingException {
        Assertions.assertEquals(json("color"), toJson(SINGLE));
        Assertions.assertEquals(json("color_list"), toJson(LIST));
    }

    @Test
    void serializeToYaml() throws JsonProcessingException {
        Assertions.assertEquals(yaml("color"), toYaml(SINGLE));
        Assertions.assertEquals(yaml("color_list"), toYaml(LIST));
    }

    @Test
    void serializeoToml() throws JsonProcessingException {
        Assertions.assertEquals(toml("color"), toToml(SINGLE));
    }
}
