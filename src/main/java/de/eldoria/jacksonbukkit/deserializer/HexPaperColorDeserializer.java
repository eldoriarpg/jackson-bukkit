/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import de.eldoria.jacksonbukkit.entities.PaperColorWrapper;
import org.bukkit.Color;

import java.io.IOException;

/**
 * Class for deserialization of {@link Color} as hexadecimal string.
 */
public class HexPaperColorDeserializer extends JsonDeserializer<Color> {

    @Override
    public Color deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return PaperColorWrapper.of(ctxt.readValue(p, String.class)).toBukkitColor();
    }
}
