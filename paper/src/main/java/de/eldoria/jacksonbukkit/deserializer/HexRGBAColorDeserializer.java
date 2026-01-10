/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import de.eldoria.jacksonbukkit.entities.RGBAColorWrapper;
import de.eldoria.jacksonbukkit.entities.RGBColorWrapper;
import de.eldoria.jacksonbukkit.util.PaperFeatures;
import org.bukkit.Color;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.ValueDeserializer;

/**
 * Class for deserialization of {@link Color} as hexadecimal string.
 */
public class HexRGBAColorDeserializer extends ValueDeserializer<Color> {

    @Override
    public Color deserialize(JsonParser p, DeserializationContext ctxt) throws JacksonException {
        if (PaperFeatures.IS_RGBA) {
            return RGBAColorWrapper.of(ctxt.readValue(p, String.class)).toBukkitColor();
        }
        return RGBColorWrapper.of(ctxt.readValue(p, String.class)).toBukkitColor();
    }
}
