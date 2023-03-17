/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import de.eldoria.jacksonbukkit.entities.NamespacedKeyWrapper;
import org.bukkit.NamespacedKey;

import java.io.IOException;

public class NamespacedKeyDeserializer extends JsonDeserializer<NamespacedKey> {
    @Override
    public NamespacedKey deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return ctxt.readValue(p, NamespacedKeyWrapper.class).toKey();
    }
}
