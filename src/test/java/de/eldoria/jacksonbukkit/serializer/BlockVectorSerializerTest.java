package de.eldoria.jacksonbukkit.serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.eldoria.jacksonbukkit.TestUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static de.eldoria.jacksonbukkit.templates.BlockVectorTemplate.VECTOR;
import static de.eldoria.jacksonbukkit.templates.BlockVectorTemplate.VECTORS;
import static org.junit.jupiter.api.Assertions.*;

class BlockVectorSerializerTest implements TestUtil {

    @Test
    void serializeToJson() throws JsonProcessingException {
        Assertions.assertEquals(json("vector"), toJson(VECTOR));
        Assertions.assertEquals(json("vector_list"), toJson(VECTORS));
    }
    @Test
    void serializeToYaml() throws JsonProcessingException {
        Assertions.assertEquals(yaml("vector"), toYaml(VECTOR));
        Assertions.assertEquals(yaml("vector_list"), toYaml(VECTORS));
    }
    @Test
    void serializeToToml() throws JsonProcessingException {
        Assertions.assertEquals(toml("vector"), toToml(VECTOR));
    }
}
