package de.eldoria.jacksonbukkit.deserializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.eldoria.jacksonbukkit.TestUtil;
import de.eldoria.jacksonbukkit.templates.VectorTemplate;
import org.bukkit.util.Vector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class VectorDeserializerTest implements TestUtil {

    @Test
    void deserializeToJson() throws JsonProcessingException {
        Assertions.assertEquals(VectorTemplate.VECTOR, fromJson("vector", Vector.class));
        Assertions.assertEquals(VectorTemplate.VECTORS, fromJsonList("vector_list", Vector.class));
    }

    @Test
    void deserializeToYaml() throws JsonProcessingException {
        Assertions.assertEquals(VectorTemplate.VECTOR, fromYaml("vector", Vector.class));
        Assertions.assertEquals(VectorTemplate.VECTORS, fromYamlList("vector_list", Vector.class));
    }

    @Test
    void deserializeToToml() throws JsonProcessingException {
        Assertions.assertEquals(VectorTemplate.VECTOR, fromToml("vector", Vector.class));
    }
}
