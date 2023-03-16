package de.eldoria.jacksonbukkit.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.bukkit.Color;

import java.io.IOException;

public class ColorDeserializer extends JsonDeserializer<Color> {

    @Override
    public Color deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return ctxt.readValue(p, de.eldoria.jacksonbukkit.entities.Color.class).toBukkitColor();
    }
}
