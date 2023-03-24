/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import de.eldoria.jacksonbukkit.entities.BoundingBoxWrapper;
import org.bukkit.util.BoundingBox;

import java.io.IOException;

/**
 * Class for serialization of {@link BoundingBox}.
 */
public class BoundingBoxSerializer extends JsonSerializer<BoundingBox> {
    @Override
    public void serialize(BoundingBox value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeObject(BoundingBoxWrapper.of(value));
    }
}
