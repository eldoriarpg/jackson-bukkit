/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import de.eldoria.jacksonbukkit.entities.InventoryWrapper;

import java.io.IOException;

/**
 * Class for deserialization of {@link InventoryWrapper}.
 */
public class InventoryDeserializer extends JsonDeserializer<InventoryWrapper> {
    @Override
    public InventoryWrapper deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return ctxt.readValue(p, InventoryWrapper.class);
    }
}
