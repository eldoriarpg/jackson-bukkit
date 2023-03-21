package de.eldoria.jacksonbukkit.serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.Module;
import de.eldoria.jacksonbukkit.JacksonPaper;
import de.eldoria.jacksonbukkit.SerializationTest;
import de.eldoria.jacksonbukkit.templates.ComponentTemplate;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ComponentMiniSerializerTest implements SerializationTest {
    @Override
    public Module buildModule() {
        return JacksonPaper.paper().build();
    }

    @Test
    void serializeToJson() throws JsonProcessingException {
        assertEquals(json("component"), toJson(ComponentTemplate.SINGLE));
        assertEquals(json("component_list"), toJson(ComponentTemplate.LIST));
    }

    @Test
    void serializeToYaml() throws JsonProcessingException {
        assertEquals(yaml("component"), toYaml(ComponentTemplate.SINGLE));
        assertEquals(yaml("component_list"), toYaml(ComponentTemplate.LIST));
    }

    // toml can't c:
    @Test
    @Disabled
    void serializeToToml() throws JsonProcessingException {
        assertEquals(toml("component"), toToml(ComponentTemplate.SINGLE));
    }

}
