package de.eldoria.jacksonbukkit.deserializer;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.bukkit.util.Vector;

import java.io.IOException;

public class VectorDeserializer extends JsonDeserializer<Vector> {
    @Override
    public Vector deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
        return ctxt.readValue(p, de.eldoria.jacksonbukkit.entities.Vector.class).toBukkitVector();
    }
}
