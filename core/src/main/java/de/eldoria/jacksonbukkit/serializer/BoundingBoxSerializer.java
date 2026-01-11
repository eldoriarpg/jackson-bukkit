/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import de.eldoria.jacksonbukkit.entities.BoundingBoxWrapper;
import org.bukkit.util.BoundingBox;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonGenerator;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.ValueSerializer;

/**
 * Class for serialization of {@link BoundingBox}.
 */
public class BoundingBoxSerializer extends ValueSerializer<BoundingBox> {
    @Override
    public void serialize(BoundingBox value, JsonGenerator gen, SerializationContext serializers) throws JacksonException {
        gen.writePOJO(BoundingBoxWrapper.of(value));
    }
}
