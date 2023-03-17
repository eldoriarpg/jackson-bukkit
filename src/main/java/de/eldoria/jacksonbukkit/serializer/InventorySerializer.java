/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import de.eldoria.jacksonbukkit.entities.InventoryWrapper;

import java.io.IOException;

/**
 * Class for serialization of {@link InventoryWrapper}.
 */
public class InventorySerializer extends JsonSerializer<InventoryWrapper> {
    @Override
    public void serialize(InventoryWrapper value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeObject(value);
    }
}
