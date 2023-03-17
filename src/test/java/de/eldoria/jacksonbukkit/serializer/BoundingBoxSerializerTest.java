package de.eldoria.jacksonbukkit.serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.eldoria.jacksonbukkit.TestUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static de.eldoria.jacksonbukkit.templates.BoundingBoxTemplate.SINGLE;
import static de.eldoria.jacksonbukkit.templates.BoundingBoxTemplate.LIST;


class BoundingBoxSerializerTest implements TestUtil {

    @Test
    void serializeToJson() throws JsonProcessingException {
        Assertions.assertEquals(json("bounding_box"), toJson(SINGLE));
        Assertions.assertEquals(json("bounding_box_list"), toJson(LIST));
    }
    @Test
    void serializeToYaml() throws JsonProcessingException {
        Assertions.assertEquals(yaml("bounding_box"), toYaml(SINGLE));
        Assertions.assertEquals(yaml("bounding_box_list"), toYaml(LIST));
    }
    @Test
    void serializeToToml() throws JsonProcessingException {
        Assertions.assertEquals(toml("bounding_box"), toToml(SINGLE));
    }
}

