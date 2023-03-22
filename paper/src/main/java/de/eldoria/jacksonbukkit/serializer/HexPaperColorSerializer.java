/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import de.eldoria.jacksonbukkit.entities.RGBColorWrapper;
import de.eldoria.jacksonbukkit.templates.RGBAColorWrapper;
import de.eldoria.jacksonbukkit.util.PaperFeatures;
import org.bukkit.Color;

import java.io.IOException;

/**
 * Class for serialization of {@link Color}.
 */
public class HexPaperColorSerializer extends JsonSerializer<Color> {
    @Override
    public void serialize(Color value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if (PaperFeatures.IS_RGBA) {
            gen.writeString(RGBAColorWrapper.of(value).asHex());
        } else {
            gen.writeString(RGBColorWrapper.of(value).asHex());
        }
    }
}
