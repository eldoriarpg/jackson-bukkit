/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import de.eldoria.jacksonbukkit.entities.FireworkEffectWrapper;
import org.bukkit.FireworkEffect;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonGenerator;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.ValueSerializer;

/**
 * Class for serialization of {@link FireworkEffect}.
 */
public class FireworkEffectSerializer extends ValueSerializer<FireworkEffect> {
    @Override
    public void serialize(FireworkEffect value, JsonGenerator gen, SerializationContext serializers) throws JacksonException {
        gen.writePOJO(FireworkEffectWrapper.of(value));
    }
}
