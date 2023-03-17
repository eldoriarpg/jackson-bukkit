package de.eldoria.jacksonbukkit.serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.Module;
import de.eldoria.jacksonbukkit.JacksonBukkit;
import de.eldoria.jacksonbukkit.SerializationTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static de.eldoria.jacksonbukkit.templates.ColorTemplate.LIST;
import static de.eldoria.jacksonbukkit.templates.ColorTemplate.SINGLE;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HexColorSerializerTest implements SerializationTest {
    @Override
    public Module buildModule() {
        return new JacksonBukkit(true);
    }

    @Test
    void serializeToJson() throws JsonProcessingException {
        assertEquals(json("color_hex"), toJson(SINGLE));
        assertEquals(json("color_hex_list"), toJson(LIST));
    }

    @Test
    void serializeToYaml() throws JsonProcessingException {
        assertEquals(yaml("color_hex"), toYaml(SINGLE));
        assertEquals(yaml("color_hex_list"), toYaml(LIST));
    }

    // toml can't c:
    @Test
    @Disabled
    void serializeToml() throws JsonProcessingException {
        assertEquals(toml("color_hex"), toToml(SINGLE));
    }
}
