package de.eldoria.jacksonbukkit.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import de.eldoria.jacksonbukkit.entities.AttributeModifierWrapper;
import org.bukkit.attribute.AttributeModifier;

import java.io.IOException;

public class AttributeModifierSerializer extends JsonSerializer<AttributeModifier> {
    @Override
    public void serialize(AttributeModifier value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeObject(AttributeModifierWrapper.of(value));
    }
}
