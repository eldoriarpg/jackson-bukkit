package de.eldoria.jacksonbukkit.serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.eldoria.jacksonbukkit.TestUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static de.eldoria.jacksonbukkit.templates.BlockVectorTemplate.SINGLE;
import static de.eldoria.jacksonbukkit.templates.BlockVectorTemplate.LIST;

class BlockVectorSerializerTest implements TestUtil {

    @Test
    void serializeToJson() throws JsonProcessingException {
        Assertions.assertEquals(json("vector"), toJson(SINGLE));
        Assertions.assertEquals(json("vector_list"), toJson(LIST));
    }
    @Test
    void serializeToYaml() throws JsonProcessingException {
        Assertions.assertEquals(yaml("vector"), toYaml(SINGLE));
        Assertions.assertEquals(yaml("vector_list"), toYaml(LIST));
    }
    @Test
    void serializeToToml() throws JsonProcessingException {
        Assertions.assertEquals(toml("vector"), toToml(SINGLE));
    }
}
