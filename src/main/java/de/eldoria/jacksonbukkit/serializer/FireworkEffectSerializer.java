package de.eldoria.jacksonbukkit.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import de.eldoria.jacksonbukkit.entities.FireworkEffectWrapper;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;

import java.io.IOException;
import java.util.List;

public class FireworkEffectSerializer extends JsonSerializer<FireworkEffect> {
    @Override
    public void serialize(FireworkEffect value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        FireworkEffect.Type type = value.getType();
        List<Color> colors = value.getColors();
        List<Color> fadeColors = value.getFadeColors();
        boolean flicker = value.hasFlicker();
        boolean trail = value.hasTrail();
        gen.writeObject(new FireworkEffectWrapper(type, colors, fadeColors, flicker, trail));
    }
}
