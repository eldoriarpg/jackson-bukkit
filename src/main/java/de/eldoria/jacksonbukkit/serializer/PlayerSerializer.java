package de.eldoria.jacksonbukkit.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import de.eldoria.jacksonbukkit.entities.PatternWrapper;
import org.bukkit.OfflinePlayer;
import org.bukkit.block.banner.Pattern;

import java.io.IOException;

public class PlayerSerializer extends JsonSerializer<OfflinePlayer> {
    @Override
    public void serialize(OfflinePlayer value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeObject(value.getUniqueId());
    }
}
