/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import org.bukkit.OfflinePlayer;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonGenerator;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.ValueSerializer;

/**
 * Class for serialization of {@link OfflinePlayer}.
 */
public class PlayerSerializer extends ValueSerializer<OfflinePlayer> {
    @Override
    public void serialize(OfflinePlayer value, JsonGenerator gen, SerializationContext serializers) throws JacksonException {
        gen.writePOJO(value.getUniqueId());
    }
}
