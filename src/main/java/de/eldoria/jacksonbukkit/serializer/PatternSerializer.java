/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import de.eldoria.jacksonbukkit.entities.PatternWrapper;
import org.bukkit.block.banner.Pattern;

import java.io.IOException;

/**
 * Class for serialization of {@link Pattern}.
 */
public class PatternSerializer extends JsonSerializer<Pattern> {
    @Override
    public void serialize(Pattern value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeObject(PatternWrapper.of(value));
    }
}
