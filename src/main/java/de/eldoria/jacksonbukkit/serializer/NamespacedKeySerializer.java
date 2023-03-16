package de.eldoria.jacksonbukkit.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import de.eldoria.jacksonbukkit.entities.NamespacedKeyWrapper;
import org.bukkit.NamespacedKey;

import java.io.IOException;

public class NamespacedKeySerializer extends JsonSerializer<NamespacedKey> {
    @Override
    public void serialize(NamespacedKey value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeObject(new NamespacedKeyWrapper(value.namespace(), value.getKey()));
    }
}
