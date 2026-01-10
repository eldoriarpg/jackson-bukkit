/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import de.eldoria.jacksonbukkit.entities.FireworkEffectWrapper;
import org.bukkit.FireworkEffect;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.ValueDeserializer;

/**
 * Class for deserialization of {@link FireworkEffect}.
 */
public class FireworkEffectDeserializer extends ValueDeserializer<FireworkEffect> {
    @Override
    public FireworkEffect deserialize(JsonParser p, DeserializationContext ctxt) throws JacksonException {
        return ctxt.readValue(p, FireworkEffectWrapper.class).toFireworkEffect();
    }
}
