/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import de.eldoria.jacksonbukkit.entities.LocationWrapper;
import org.bukkit.Location;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonGenerator;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.ValueSerializer;

/**
 * Class for serialization of {@link Location}.
 */
public class LocationSerializer extends ValueSerializer<Location> {
    @Override
    public void serialize(Location value, JsonGenerator gen, SerializationContext serializers) throws JacksonException {
        gen.writePOJO(LocationWrapper.of(value));
    }
}
