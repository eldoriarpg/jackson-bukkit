package de.eldoria.jacksonbukkit.deserializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.eldoria.jacksonbukkit.TestUtil;
import org.bukkit.util.BlockVector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static de.eldoria.jacksonbukkit.templates.BlockVectorTemplate.SINGLE;
import static de.eldoria.jacksonbukkit.templates.BlockVectorTemplate.LIST;

class BlockVectorDeserializerTest implements TestUtil {
    @Test
    void deserializeFromJson() throws JsonProcessingException {
        Assertions.assertEquals(SINGLE, fromJson("vector", BlockVector.class));
        Assertions.assertEquals(LIST, fromJsonList("vector_list", BlockVector.class));
    }
    @Test
    void deserializeFromYaml() throws JsonProcessingException {
        Assertions.assertEquals(SINGLE, fromYaml("vector", BlockVector.class));
        Assertions.assertEquals(LIST, fromYamlList("vector_list", BlockVector.class));
    }
    @Test
    void deserializeFromToml() throws JsonProcessingException {
        Assertions.assertEquals(SINGLE, fromToml("vector", BlockVector.class));
    }

}
