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
import de.eldoria.jacksonbukkit.entities.VectorWrapper;
import org.bukkit.util.Vector;

import java.io.IOException;

public class VectorDeserializer extends JsonDeserializer<Vector> {
    @Override
    public Vector deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return ctxt.readValue(p, VectorWrapper.class).toBukkitVector();
    }
}
