/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import de.eldoria.jacksonbukkit.entities.RGBAColorWrapper;
import de.eldoria.jacksonbukkit.entities.RGBColorWrapper;
import de.eldoria.jacksonbukkit.util.PaperFeatures;
import org.bukkit.Color;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonGenerator;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.ValueSerializer;

/**
 * Class for serialization of {@link Color}.
 */
public class PaperColorSerializer extends ValueSerializer<Color> {

    @Override
    public void serialize(Color value, JsonGenerator gen, SerializationContext serializers) throws JacksonException {
        if (PaperFeatures.IS_RGBA) {
            gen.writePOJO(RGBAColorWrapper.of(value));
        } else {
            gen.writePOJO(RGBColorWrapper.of(value));
        }
    }
}
