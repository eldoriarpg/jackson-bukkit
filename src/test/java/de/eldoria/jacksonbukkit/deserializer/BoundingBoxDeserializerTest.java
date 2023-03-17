package de.eldoria.jacksonbukkit.deserializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.eldoria.jacksonbukkit.TestUtil;
import org.bukkit.util.BoundingBox;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static de.eldoria.jacksonbukkit.templates.BoundingBoxTemplate.SINGLE;
import static de.eldoria.jacksonbukkit.templates.BoundingBoxTemplate.LIST;


class BoundingBoxDeserializerTest implements TestUtil {

    @Test
    void deserializeFromJson() throws JsonProcessingException {
        Assertions.assertEquals(SINGLE, fromJson("bounding_box", BoundingBox.class));
        Assertions.assertEquals(LIST, fromJsonList("bounding_box_list", BoundingBox.class));
    }
    @Test
    void deserializeFromYaml() throws JsonProcessingException {
        Assertions.assertEquals(SINGLE, fromYaml("bounding_box", BoundingBox.class));
        Assertions.assertEquals(LIST, fromYamlList("bounding_box_list", BoundingBox.class));
    }
    @Test
    void deserializeFromToml() throws JsonProcessingException {
        Assertions.assertEquals(SINGLE, fromToml("bounding_box", BoundingBox.class));
    }
}
