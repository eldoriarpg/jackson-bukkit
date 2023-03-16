package de.eldoria.jacksonbukkit.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import de.eldoria.jacksonbukkit.entities.Vector;

import java.io.IOException;

public class VectorSerializer extends JsonSerializer<Vector> {
    @Override
    public void serialize(Vector value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeObject();
    }
}
