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
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ValueDeserializer;

/**
 * Class for deserialization of {@link Color} as object.
 */
public class RGBAColorDeserializer extends ValueDeserializer<Color> {

    @Override
    public Color deserialize(JsonParser p, DeserializationContext ctxt) throws JacksonException {
        JsonNode tree = ctxt.readTree(p);
        if (tree.has("alpha") && PaperFeatures.IS_RGBA) {
            return ctxt.readTreeAsValue(tree, RGBAColorWrapper.class).toBukkitColor();
        }
        return ctxt.readTreeAsValue(tree, RGBColorWrapper.class).toBukkitColor();
    }
}
