/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import de.eldoria.jacksonbukkit.entities.VectorWrapper;
import org.bukkit.util.BlockVector;

import java.io.IOException;

/**
 * Class for deserialization of {@link BlockVector}.
 */
public class BlockVectorDeserializer extends JsonDeserializer<BlockVector> {
    @Override
    public BlockVector deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return ctxt.readValue(p, VectorWrapper.class).toBukkitBlockVector();
    }
}
