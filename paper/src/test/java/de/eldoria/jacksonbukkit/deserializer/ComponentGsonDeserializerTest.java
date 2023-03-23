package de.eldoria.jacksonbukkit.deserializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.Module;
import de.eldoria.jacksonbukkit.JacksonPaper;
import de.eldoria.jacksonbukkit.PaperSerializationTest;
import de.eldoria.jacksonbukkit.serializer.ComponentGsonSerializer;
import de.eldoria.jacksonbukkit.templates.ComponentTemplate;
import net.kyori.adventure.text.Component;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ComponentGsonDeserializerTest implements PaperSerializationTest {

    @Override
    public Module buildModule() {
        return new JacksonPaper(false,
                false,
                new ComponentGsonDeserializer(),
                new ComponentGsonSerializer());
    }

    @Test
    void deserializeToJson() throws JsonProcessingException {
        assertEquals(ComponentTemplate.SINGLE, fromJson("gson_component", Component.class));
        assertEquals(ComponentTemplate.LIST, fromJsonList("gson_component_list", Component.class));
    }

    @Test
    void deserializeToYaml() throws JsonProcessingException {
        assertEquals(ComponentTemplate.SINGLE, fromYaml("gson_component", Component.class));
        assertEquals(ComponentTemplate.LIST, fromYamlList("gson_component_list", Component.class));
    }

    // toml can't c:
    @Test
    void deserializeToToml() throws JsonProcessingException {
        assertEquals(ComponentTemplate.SINGLE, fromToml("gson_component", Component.class));
    }

}
