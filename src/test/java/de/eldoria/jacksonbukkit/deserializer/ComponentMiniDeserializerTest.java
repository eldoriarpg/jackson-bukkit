package de.eldoria.jacksonbukkit.deserializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.Module;
import de.eldoria.jacksonbukkit.JacksonPaper;
import de.eldoria.jacksonbukkit.SerializationTest;
import de.eldoria.jacksonbukkit.templates.ComponentTemplate;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ComponentMiniDeserializerTest implements SerializationTest {
    MiniMessage miniMessage = MiniMessage.miniMessage();

    @Override
    public Module buildModule() {
        return JacksonPaper.paper().build();
    }

    @Test
    void deserializeToJson() throws JsonProcessingException {
        assertEquals(miniMessage.serialize(ComponentTemplate.SINGLE), miniMessage.serialize(fromJson("component", Component.class)));
        assertEquals(ComponentTemplate.LIST.stream().map(miniMessage::serialize).toList(), fromJsonList("component_list", Component.class).stream().map(miniMessage::serialize).toList());
    }

    @Test
    void deserializeToYaml() throws JsonProcessingException {
        assertEquals(miniMessage.serialize(ComponentTemplate.SINGLE), miniMessage.serialize(fromYaml("component", Component.class)));
        assertEquals(ComponentTemplate.LIST.stream().map(miniMessage::serialize).toList(), fromYamlList("component_list", Component.class).stream().map(miniMessage::serialize).toList());
    }

    // toml can't c:
    @Test
    @Disabled
    void deserializeToToml() throws JsonProcessingException {
        assertEquals(ComponentTemplate.SINGLE, fromToml("component", Component.class));
    }

}
