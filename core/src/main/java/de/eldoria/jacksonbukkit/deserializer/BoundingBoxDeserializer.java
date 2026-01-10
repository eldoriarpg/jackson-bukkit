/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import de.eldoria.jacksonbukkit.entities.BoundingBoxWrapper;
import org.bukkit.util.BoundingBox;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.ValueDeserializer;

/**
 * Class for deserialization of {@link BoundingBox}.
 */
public class BoundingBoxDeserializer extends ValueDeserializer<BoundingBox> {
    @Override
    public BoundingBox deserialize(JsonParser p, DeserializationContext ctxt) throws JacksonException {
        return ctxt.readValue(p, BoundingBoxWrapper.class).toBukkitBoundingBox();
    }
}
