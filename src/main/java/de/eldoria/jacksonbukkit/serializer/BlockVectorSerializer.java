package de.eldoria.jacksonbukkit.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import de.eldoria.jacksonbukkit.entities.Vector;
import org.bukkit.util.BlockVector;

import java.io.IOException;

public class BlockVectorSerializer extends JsonSerializer<BlockVector> {
    @Override
    public void serialize(BlockVector value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeObject(Vector.of(value));
    }
}
