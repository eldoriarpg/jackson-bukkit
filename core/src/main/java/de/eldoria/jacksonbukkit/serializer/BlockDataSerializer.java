/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.bukkit.block.data.BlockData;
import org.bukkit.util.BlockVector;

import java.io.IOException;

/**
 * Class for serialization of {@link BlockVector}.
 */
public class BlockDataSerializer extends JsonSerializer<BlockData> {
    @Override
    public void serialize(BlockData value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeObject(value.getAsString());
    }
}
