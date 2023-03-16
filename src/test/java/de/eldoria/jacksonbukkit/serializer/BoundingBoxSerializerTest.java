package de.eldoria.jacksonbukkit.serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.eldoria.jacksonbukkit.TestUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static de.eldoria.jacksonbukkit.templates.BoundingBoxTemplate.BOUNDING_BOX;
import static de.eldoria.jacksonbukkit.templates.BoundingBoxTemplate.BOUNDING_BOX_LIST;


class BoundingBoxSerializerTest implements TestUtil {

    @Test
    void serializeToJson() throws JsonProcessingException {
        Assertions.assertEquals(json("bounding_box"), toJson(BOUNDING_BOX));
        Assertions.assertEquals(json("bounding_box_list"), toJson(BOUNDING_BOX_LIST));
    }
    @Test
    void serializeToYaml() throws JsonProcessingException {
        Assertions.assertEquals(yaml("bounding_box"), toYaml(BOUNDING_BOX));
        Assertions.assertEquals(yaml("bounding_box_list"), toYaml(BOUNDING_BOX_LIST));
    }
    @Test
    void serializeToToml() throws JsonProcessingException {
        Assertions.assertEquals(toml("bounding_box"), toToml(BOUNDING_BOX));
    }
}

