/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;

import java.io.IOException;
import java.util.UUID;

/**
 * Class for deserialization of {@link OfflinePlayer}.
 */
public class PlayerDeserializer extends JsonDeserializer<OfflinePlayer> {
    @Override
    public OfflinePlayer deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return Bukkit.getPlayer(ctxt.readValue(p, UUID.class));
    }
}
