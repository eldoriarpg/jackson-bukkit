/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import de.eldoria.jacksonbukkit.entities.PotionEffectWrapper;
import org.bukkit.potion.PotionEffect;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.ValueDeserializer;

/**
 * Class for deserialization of {@link PotionEffect}.
 */
public class PotionEffectDeserializer extends ValueDeserializer<PotionEffect> {
    @Override
    public PotionEffect deserialize(JsonParser p, DeserializationContext ctxt) throws JacksonException {
        return ctxt.readValue(p, PotionEffectWrapper.class).toBukkitPotionEffect();
    }
}
