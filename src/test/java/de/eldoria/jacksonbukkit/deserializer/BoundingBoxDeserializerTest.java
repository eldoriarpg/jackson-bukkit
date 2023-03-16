package de.eldoria.jacksonbukkit.deserializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.eldoria.jacksonbukkit.TestUtil;
import org.bukkit.util.BoundingBox;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static de.eldoria.jacksonbukkit.templates.BoundingBoxTemplate.BOUNDING_BOX;
import static de.eldoria.jacksonbukkit.templates.BoundingBoxTemplate.BOUNDING_BOX_LIST;


class BoundingBoxDeserializerTest implements TestUtil {

    @Test
    void deserializeFromJson() throws JsonProcessingException {
        Assertions.assertEquals(BOUNDING_BOX, fromJson("bounding_box", BoundingBox.class));
        Assertions.assertEquals(BOUNDING_BOX_LIST, fromJsonList("bounding_box_list", BoundingBox.class));
    }
    @Test
    void deserializeFromYaml() throws JsonProcessingException {
        Assertions.assertEquals(BOUNDING_BOX, fromYaml("bounding_box", BoundingBox.class));
        Assertions.assertEquals(BOUNDING_BOX_LIST, fromYamlList("bounding_box_list", BoundingBox.class));
    }
    @Test
    void deserializeFromToml() throws JsonProcessingException {
        Assertions.assertEquals(BOUNDING_BOX, fromToml("bounding_box", BoundingBox.class));
    }
}
