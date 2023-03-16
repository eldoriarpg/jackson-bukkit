package de.eldoria.jacksonbukkit.serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.eldoria.jacksonbukkit.TestUtil;
import de.eldoria.jacksonbukkit.templates.VectorTemplate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class VectorSerializerTest implements TestUtil {

    @Test
    void serializeToJson() throws JsonProcessingException {
        Assertions.assertEquals(json("vector"), toJson(VectorTemplate.VECTOR));
        Assertions.assertEquals(json("vector_list"), toJson(VectorTemplate.VECTORS));
    }
    @Test
    void serializeToYaml() throws JsonProcessingException {
        Assertions.assertEquals(yaml("vector"), toYaml(VectorTemplate.VECTOR));
        Assertions.assertEquals(yaml("vector_list"), toYaml(VectorTemplate.VECTORS));
    }
    @Test
    void serializeToToml() throws JsonProcessingException {
        Assertions.assertEquals(toml("vector"), toToml(VectorTemplate.VECTOR));
    }
}