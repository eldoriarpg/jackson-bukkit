/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import de.eldoria.jacksonbukkit.entities.BoundingBoxWrapper;
import org.bukkit.util.BoundingBox;

import java.io.IOException;

/**
 * Class for deserialization of {@link BoundingBox}.
 */
public class BoundingBoxDeserializer extends JsonDeserializer<BoundingBox> {
    @Override
    public BoundingBox deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return ctxt.readValue(p, BoundingBoxWrapper.class).toBukkitBoundingBox();
    }
}
