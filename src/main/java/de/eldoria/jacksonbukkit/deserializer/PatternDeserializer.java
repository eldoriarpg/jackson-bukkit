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
import de.eldoria.jacksonbukkit.entities.PatternWrapper;
import org.bukkit.block.banner.Pattern;

import java.io.IOException;

public class PatternDeserializer extends JsonDeserializer<Pattern> {
    @Override
    public Pattern deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return ctxt.readValue(p, PatternWrapper.class).toPattern();
    }
}
