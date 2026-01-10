/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import de.eldoria.jacksonbukkit.entities.VectorWrapper;
import org.bukkit.util.Vector;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.ValueDeserializer;

/**
 * Class for deserialization of {@link VectorDeserializer}.
 */
public class VectorDeserializer extends ValueDeserializer<Vector> {
    @Override
    public Vector deserialize(JsonParser p, DeserializationContext ctxt) throws JacksonException {
        return ctxt.readValue(p, VectorWrapper.class).toBukkitVector();
    }
}
