package de.eldoria.jacksonbukkit.deserializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.eldoria.jacksonbukkit.TestUtil;
import de.eldoria.jacksonbukkit.templates.ColorTemplate;
import org.bukkit.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ColorDeserializerTest  implements TestUtil {

    @Test
    void deserializeToJson() throws JsonProcessingException {
        Assertions.assertEquals(ColorTemplate.COLOR, fromJson("color", Color.class));
        Assertions.assertEquals(ColorTemplate.COLORS, fromJsonList("color_list", Color.class));
    }

    @Test
    void deserializeToYaml() throws JsonProcessingException {
        Assertions.assertEquals(ColorTemplate.COLOR, fromYaml("color", Color.class));
        Assertions.assertEquals(ColorTemplate.COLORS, fromYamlList("color_list", Color.class));
    }

    @Test
    void deserializeToToml() throws JsonProcessingException {
        Assertions.assertEquals(ColorTemplate.COLOR, fromToml("color", Color.class));
    }
}
