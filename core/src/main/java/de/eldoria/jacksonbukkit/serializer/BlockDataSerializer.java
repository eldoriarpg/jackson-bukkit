/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import org.bukkit.block.data.BlockData;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonGenerator;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.ValueSerializer;

/**
 * Class for serialization of {@link BlockData}.
 */
public class BlockDataSerializer extends ValueSerializer<BlockData> {
    @Override
    public void serialize(BlockData value, JsonGenerator gen, SerializationContext serializers) throws JacksonException {
        gen.writeString(value.getAsString());
    }
}
