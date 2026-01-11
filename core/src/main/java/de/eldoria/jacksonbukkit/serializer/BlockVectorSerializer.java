/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import de.eldoria.jacksonbukkit.entities.VectorWrapper;
import org.bukkit.util.BlockVector;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonGenerator;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.ValueSerializer;

/**
 * Class for serialization of {@link BlockVector}.
 */
public class BlockVectorSerializer extends ValueSerializer<BlockVector> {
    @Override
    public void serialize(BlockVector value, JsonGenerator gen, SerializationContext serializers) throws JacksonException {
        gen.writePOJO(VectorWrapper.of(value));
    }
}
