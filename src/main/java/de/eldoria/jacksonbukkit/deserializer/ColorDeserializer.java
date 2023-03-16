package de.eldoria.jacksonbukkit.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.bukkit.Color;

import java.io.IOException;

public class ColorDeserializer extends JsonDeserializer<Color> {

    @Override
    public Color deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        var type = ctxt.getTypeFactory().constructArrayType(Integer.class);
        int[] colors = ctxt.readValue(p,type);
        if(colors.length == 4){
            return Color.fromARGB(colors[3], colors[0], colors[1], colors[2]);
        }
        return null;
    }
}
