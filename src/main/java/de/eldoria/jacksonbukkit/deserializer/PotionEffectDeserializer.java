/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import de.eldoria.jacksonbukkit.entities.PotionEffectWrapper;
import org.bukkit.potion.PotionEffect;

import java.io.IOException;

/**
 * Class for deserialization of {@link PotionEffect}.
 */
public class PotionEffectDeserializer extends JsonDeserializer<PotionEffect> {
    @Override
    public PotionEffect deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return ctxt.readValue(p, PotionEffectWrapper.class).toBukkitPotionEffect();
    }
}
