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
import org.bukkit.Color;

import java.io.IOException;

/**
 * Class for serialization of {@link Color}.
 */
public class HexRGBColorSerializer extends JsonSerializer<Color> {
    @Override
    public void serialize(Color value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeString(RGBColorWrapper.of(value).asHex());
    }
}
