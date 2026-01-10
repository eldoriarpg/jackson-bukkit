/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import de.eldoria.jacksonbukkit.entities.PatternWrapper;
import org.bukkit.block.banner.Pattern;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonGenerator;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.ValueSerializer;

/**
 * Class for serialization of {@link Pattern}.
 */
public class PatternSerializer extends ValueSerializer<Pattern> {
    @Override
    public void serialize(Pattern value, JsonGenerator gen, SerializationContext serializers) throws JacksonException {
        gen.writePOJO(PatternWrapper.of(value));
    }
}
