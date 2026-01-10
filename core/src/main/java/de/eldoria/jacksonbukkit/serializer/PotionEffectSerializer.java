/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import de.eldoria.jacksonbukkit.entities.PotionEffectWrapper;
import org.bukkit.potion.PotionEffect;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonGenerator;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.ValueSerializer;

/**
 * Class for serialization of {@link PotionEffect}.
 */
public class PotionEffectSerializer extends ValueSerializer<PotionEffect> {
    @Override
    public void serialize(PotionEffect value, JsonGenerator gen, SerializationContext serializers) throws JacksonException {
        gen.writePOJO(PotionEffectWrapper.of(value));
    }
}
