package de.eldoria.jacksonbukkit.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.bukkit.util.BoundingBox;

import java.io.IOException;

public class BoundingBoxSerializer extends JsonSerializer<BoundingBox> {
    @Override
    public void serialize(BoundingBox value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeObject(de.eldoria.jacksonbukkit.entities.BoundingBox.of(value));
    }
}
