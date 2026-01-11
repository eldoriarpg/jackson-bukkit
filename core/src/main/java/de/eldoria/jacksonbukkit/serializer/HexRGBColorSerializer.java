/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;


import de.eldoria.jacksonbukkit.entities.RGBColorWrapper;
import org.bukkit.Color;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonGenerator;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.ValueSerializer;

/**
 * Class for serialization of {@link Color}.
 */
public class HexRGBColorSerializer extends ValueSerializer<Color> {
    @Override
    public void serialize(Color value, JsonGenerator gen, SerializationContext serializers) throws JacksonException {
        gen.writeString(RGBColorWrapper.of(value).asHex());
    }
}
