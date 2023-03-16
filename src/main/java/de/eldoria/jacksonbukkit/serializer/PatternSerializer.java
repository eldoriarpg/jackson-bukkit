package de.eldoria.jacksonbukkit.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import de.eldoria.jacksonbukkit.entities.PatternWrapper;
import org.bukkit.block.banner.Pattern;

import java.io.IOException;

public class PatternSerializer extends JsonSerializer<Pattern> {
    @Override
    public void serialize(Pattern value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeObject(new PatternWrapper(value.getColor(), value.getPattern()));
    }
}
