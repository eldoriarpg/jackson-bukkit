package de.eldoria.jacksonbukkit.deserializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.eldoria.jacksonbukkit.TestUtil;
import de.eldoria.jacksonbukkit.templates.ColorTemplate;
import org.bukkit.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ColorDeserializerTest  implements TestUtil {

    @Test
    void deserializeFromJson() throws JsonProcessingException {
        Assertions.assertEquals(ColorTemplate.SINGLE, fromJson("color", Color.class));
        Assertions.assertEquals(ColorTemplate.LIST, fromJsonList("color_list", Color.class));
    }

    @Test
    void deserializeFromYaml() throws JsonProcessingException {
        Assertions.assertEquals(ColorTemplate.SINGLE, fromYaml("color", Color.class));
        Assertions.assertEquals(ColorTemplate.LIST, fromYamlList("color_list", Color.class));
    }

    @Test
    void deserializeFromToml() throws JsonProcessingException {
        Assertions.assertEquals(ColorTemplate.SINGLE, fromToml("color", Color.class));
    }
}
