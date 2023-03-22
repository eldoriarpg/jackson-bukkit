/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import de.eldoria.jacksonbukkit.entities.RGBColorWrapper;
import de.eldoria.jacksonbukkit.templates.RGBAColorWrapper;
import de.eldoria.jacksonbukkit.util.PaperFeatures;
import org.bukkit.Color;

import java.io.IOException;

/**
 * Class for deserialization of {@link Color} as object.
 */
public class RGBAColorDeserializer extends JsonDeserializer<Color> {

    @Override
    public Color deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode tree = ctxt.readTree(p);
        if (tree.has("alpha") && PaperFeatures.IS_RGBA) {
            return ctxt.readTreeAsValue(tree, RGBAColorWrapper.class).toBukkitColor();
        }
        return ctxt.readTreeAsValue(tree, RGBColorWrapper.class).toBukkitColor();
    }
}
