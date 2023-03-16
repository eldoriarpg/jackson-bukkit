package de.eldoria.jacksonbukkit.serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.eldoria.jacksonbukkit.TestUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static de.eldoria.jacksonbukkit.templates.ColorTemplate.COLOR;
import static de.eldoria.jacksonbukkit.templates.ColorTemplate.COLORS;

class ColorSerializerTest implements TestUtil {


    @Test
    void serializeToJson() throws JsonProcessingException {
        Assertions.assertEquals(json("color"), toJson(COLOR));
        Assertions.assertEquals(json("color_list"), toJson(COLORS));
    }

    @Test
    void serializeToYaml() throws JsonProcessingException {
        Assertions.assertEquals(yaml("color"), toYaml(COLOR));
        Assertions.assertEquals(yaml("color_list"), toYaml(COLORS));
    }

    @Test
    void serializeoToml() throws JsonProcessingException {
        Assertions.assertEquals(toml("color"), toToml(COLOR));
    }
}
