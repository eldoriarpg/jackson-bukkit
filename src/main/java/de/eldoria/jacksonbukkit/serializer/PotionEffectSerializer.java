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
import org.bukkit.potion.PotionEffectType;

import java.io.IOException;

public class PotionEffectSerializer extends JsonSerializer<PotionEffect> {
    @Override
    public void serialize(PotionEffect value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        int amplifier = value.getAmplifier();
        int duration = value.getDuration();
        PotionEffectType type = value.getType();
        boolean ambient = value.isAmbient();
        boolean icon = value.hasIcon();
        boolean particles = value.hasParticles();
        gen.writeObject(new PotionEffectWrapper(amplifier, duration, type.getKey(), ambient, particles, icon));
    }
}
