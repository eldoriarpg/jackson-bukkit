package de.eldoria.jacksonbukkit.deserializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.Module;
import de.eldoria.jacksonbukkit.JacksonBukkit;
import de.eldoria.jacksonbukkit.SerializationTest;
import de.eldoria.jacksonbukkit.templates.ColorTemplate;
import org.bukkit.Color;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HexColorDeserializerTest implements SerializationTest {
    @Override
    public Module buildModule() {
        return new JacksonBukkit(true);
    }

    @Test
    void deserializeFromJson() throws JsonProcessingException {
        assertEquals(ColorTemplate.SINGLE, fromJson("color_hex", Color.class));
        assertEquals(ColorTemplate.LIST, fromJsonList("color_hex_list", Color.class));
    }

    @Test
    void deserializeFromYaml() throws JsonProcessingException {
        assertEquals(ColorTemplate.SINGLE, fromYaml("color_hex", Color.class));
        assertEquals(ColorTemplate.LIST, fromYamlList("color_hex_list", Color.class));
    }

    // toml can't c:
    @Test
    @Disabled
    void deserializeFromToml() throws JsonProcessingException {
        assertEquals(ColorTemplate.SINGLE, fromToml("color_hex", Color.class));
    }
}
