/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import de.eldoria.jacksonbukkit.entities.PotionEffectWrapper;
import org.bukkit.potion.PotionEffect;

import java.io.IOException;

/**
 * Class for serialization of {@link PotionEffect}.
 */
public class PotionEffectSerializer extends JsonSerializer<PotionEffect> {
    @Override
    public void serialize(PotionEffect value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeObject(PotionEffectWrapper.of(value));
    }
}
