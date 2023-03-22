/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import de.eldoria.jacksonbukkit.entities.RGBColorWrapper;
import org.bukkit.Color;

import java.io.IOException;

/**
 * Class for deserialization of {@link Color} as object.
 */
public class RGBColorDeserializer extends JsonDeserializer<Color> {

    @Override
    public Color deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return ctxt.readValue(p, RGBColorWrapper.class).toBukkitColor();
    }
}
