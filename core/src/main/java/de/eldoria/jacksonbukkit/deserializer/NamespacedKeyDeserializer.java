/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import de.eldoria.jacksonbukkit.entities.NamespacedKeyWrapper;
import org.bukkit.NamespacedKey;

import java.io.IOException;

/**
 * Class for deserialization of {@link NamespacedKey}.
 */
public class NamespacedKeyDeserializer extends JsonDeserializer<NamespacedKey> {
    @Override
    public NamespacedKey deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode jsonNode = ctxt.readTree(p);
        if (jsonNode.isObject()) {
            return ctxt.readTreeAsValue(jsonNode, NamespacedKeyWrapper.class).toBukkitNamespacedKey();
        }
        if (jsonNode.isTextual()) {
            String text = jsonNode.asText();
            if (text.contains(":")) {
                return NamespacedKey.fromString(text);
            } else {
                return NamespacedKey.minecraft(text);
            }
        }
        throw new IllegalArgumentException("Cannot deserialize " + jsonNode.getNodeType().name());
    }
}
