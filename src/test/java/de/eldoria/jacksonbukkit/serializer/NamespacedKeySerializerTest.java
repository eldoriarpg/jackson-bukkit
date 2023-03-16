package de.eldoria.jacksonbukkit.serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.eldoria.jacksonbukkit.TestUtil;
import de.eldoria.jacksonbukkit.templates.NamespacedKeyTemplate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NamespacedKeySerializerTest implements TestUtil {

    @Test
    void serializeToJson() throws JsonProcessingException {
        Assertions.assertEquals(json("namespaced_key"), toJson(NamespacedKeyTemplate.SINGLE));
        Assertions.assertEquals(json("namespaced_key_list"), toJson(NamespacedKeyTemplate.LIST));
    }

    @Test
    void serializeToYaml() throws JsonProcessingException {
        Assertions.assertEquals(yaml("namespaced_key"), toYaml(NamespacedKeyTemplate.SINGLE));
        Assertions.assertEquals(yaml("namespaced_key_list"), toYaml(NamespacedKeyTemplate.LIST));
    }

    @Test
    void serializeToToml() throws JsonProcessingException {
        Assertions.assertEquals(toml("namespaced_key"), toToml(NamespacedKeyTemplate.SINGLE));
    }
}
