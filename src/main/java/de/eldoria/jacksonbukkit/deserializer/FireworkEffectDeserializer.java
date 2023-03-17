/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import de.eldoria.jacksonbukkit.entities.FireworkEffectWrapper;
import org.bukkit.FireworkEffect;

import java.io.IOException;

public class FireworkEffectDeserializer extends JsonDeserializer<FireworkEffect> {
    @Override
    public FireworkEffect deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return ctxt.readValue(p, FireworkEffectWrapper.class).toFireworkEffect();
    }
}
