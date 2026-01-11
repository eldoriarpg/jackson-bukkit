/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.ValueDeserializer;

import java.util.UUID;

/**
 * Class for deserialization of {@link OfflinePlayer}.
 */
public class PlayerDeserializer extends ValueDeserializer<OfflinePlayer> {
    @Override
    public OfflinePlayer deserialize(JsonParser p, DeserializationContext ctxt) throws JacksonException {
        return Bukkit.getPlayer(ctxt.readValue(p, UUID.class));
    }
}
