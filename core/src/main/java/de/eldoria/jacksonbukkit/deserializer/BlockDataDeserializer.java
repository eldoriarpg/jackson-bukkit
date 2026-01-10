/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import org.bukkit.Bukkit;
import org.bukkit.block.data.BlockData;
import org.bukkit.util.BlockVector;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.ValueDeserializer;

/**
 * Class for deserialization of {@link BlockVector}.
 */
public class BlockDataDeserializer extends ValueDeserializer<BlockData> {
    @Override
    public BlockData deserialize(JsonParser p, DeserializationContext ctxt) throws JacksonException {
        return Bukkit.createBlockData(ctxt.readValue(p, String.class));
    }
}
