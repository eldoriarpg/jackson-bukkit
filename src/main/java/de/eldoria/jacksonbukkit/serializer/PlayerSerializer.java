/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.bukkit.OfflinePlayer;

import java.io.IOException;

/**
 * Class for serialization of {@link OfflinePlayer}.
 */
public class PlayerSerializer extends JsonSerializer<OfflinePlayer> {
    @Override
    public void serialize(OfflinePlayer value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeObject(value.getUniqueId());
    }
}
