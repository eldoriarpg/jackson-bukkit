/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import de.eldoria.jacksonbukkit.entities.LocationWrapper;
import org.bukkit.Location;

import java.io.IOException;

/**
 * Class for serialization of {@link Location}.
 */
public class LocationSerializer extends JsonSerializer<Location> {
    @Override
    public void serialize(Location value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeObject(LocationWrapper.of(value));
    }
}
