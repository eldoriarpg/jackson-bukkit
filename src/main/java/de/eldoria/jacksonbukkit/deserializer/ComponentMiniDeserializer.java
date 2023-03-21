package de.eldoria.jacksonbukkit.deserializer;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;

import java.io.IOException;

public class ComponentMiniDeserializer extends JsonDeserializer<Component> {
    private final MiniMessage miniMessage;

    public ComponentMiniDeserializer(MiniMessage miniMessage) {
        this.miniMessage = miniMessage;
    }

    @Override
    public Component deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
        return miniMessage.deserialize(ctxt.readValue(p, String.class));
    }
}
