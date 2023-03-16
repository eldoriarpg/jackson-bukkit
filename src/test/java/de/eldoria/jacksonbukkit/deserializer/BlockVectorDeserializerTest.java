package de.eldoria.jacksonbukkit.deserializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.eldoria.jacksonbukkit.TestUtil;
import org.bukkit.util.BlockVector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static de.eldoria.jacksonbukkit.templates.BlockVectorTemplate.VECTOR;
import static de.eldoria.jacksonbukkit.templates.BlockVectorTemplate.VECTORS;

class BlockVectorDeserializerTest implements TestUtil {
    @Test
    void deserializeFromJson() throws JsonProcessingException {
        Assertions.assertEquals(VECTOR, fromJson("vector", BlockVector.class));
        Assertions.assertEquals(VECTORS, fromJsonList("vector_list", BlockVector.class));
    }
    @Test
    void deserializeFromYaml() throws JsonProcessingException {
        Assertions.assertEquals(VECTOR, fromYaml("vector", BlockVector.class));
        Assertions.assertEquals(VECTORS, fromYamlList("vector_list", BlockVector.class));
    }
    @Test
    void deserializeFromToml() throws JsonProcessingException {
        Assertions.assertEquals(VECTOR, fromToml("vector", BlockVector.class));
    }

}
