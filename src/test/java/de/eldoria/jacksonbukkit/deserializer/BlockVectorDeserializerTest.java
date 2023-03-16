package de.eldoria.jacksonbukkit.deserializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.eldoria.jacksonbukkit.TestUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static de.eldoria.jacksonbukkit.templates.BlockVectorTemplate.VECTOR;
import static de.eldoria.jacksonbukkit.templates.BlockVectorTemplate.VECTORS;

class BlockVectorDeserializerTest implements TestUtil {

    @Test
    void deserializeToJson() throws JsonProcessingException {
        Assertions.assertEquals(json("vector"), toJson(VECTOR));
        Assertions.assertEquals(json("vector_list"), toJson(VECTORS));
    }
    @Test
    void deserializeToYaml() throws JsonProcessingException {
        Assertions.assertEquals(yaml("vector"), toYaml(VECTOR));
        Assertions.assertEquals(yaml("vector_list"), toYaml(VECTORS));
    }
    @Test
    void deserializeToToml() throws JsonProcessingException {
        Assertions.assertEquals(toml("vector"), toToml(VECTOR));
    }
}
