/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import de.eldoria.jacksonbukkit.entities.VectorWrapper;
import org.bukkit.util.Vector;

import java.io.IOException;

/**
 * Class for serialization of {@link Vector}.
 */
public class VectorSerializer extends JsonSerializer<Vector> {
    @Override
    public void serialize(Vector value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeObject(VectorWrapper.of(value));
    }
}
