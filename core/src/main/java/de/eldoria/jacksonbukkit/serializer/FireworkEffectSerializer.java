/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import de.eldoria.jacksonbukkit.entities.FireworkEffectWrapper;
import org.bukkit.FireworkEffect;

import java.io.IOException;

/**
 * Class for serialization of {@link FireworkEffect}.
 */
public class FireworkEffectSerializer extends JsonSerializer<FireworkEffect> {
    @Override
    public void serialize(FireworkEffect value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeObject(FireworkEffectWrapper.of(value));
    }
}
