/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.bukkit.Bukkit;
import org.bukkit.block.data.BlockData;
import org.bukkit.util.BlockVector;

import java.io.IOException;

/**
 * Class for deserialization of {@link BlockVector}.
 */
public class BlockDataDeserializer extends JsonDeserializer<BlockData> {
    @Override
    public BlockData deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return Bukkit.createBlockData(ctxt.readValue(p, String.class));
    }
}
