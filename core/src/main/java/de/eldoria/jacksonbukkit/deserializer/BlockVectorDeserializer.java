/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import de.eldoria.jacksonbukkit.entities.VectorWrapper;
import org.bukkit.util.BlockVector;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.ValueDeserializer;

/**
 * Class for deserialization of {@link BlockVector}.
 */
public class BlockVectorDeserializer extends ValueDeserializer<BlockVector> {
    @Override
    public BlockVector deserialize(JsonParser p, DeserializationContext ctxt) throws JacksonException {
        return ctxt.readValue(p, VectorWrapper.class).toBukkitBlockVector();
    }
}
