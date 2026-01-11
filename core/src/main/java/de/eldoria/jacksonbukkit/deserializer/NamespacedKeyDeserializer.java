/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import de.eldoria.jacksonbukkit.entities.NamespacedKeyWrapper;
import org.bukkit.NamespacedKey;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ValueDeserializer;

/**
 * Class for deserialization of {@link NamespacedKey}.
 */
public class NamespacedKeyDeserializer extends ValueDeserializer<NamespacedKey> {
    @Override
    public NamespacedKey deserialize(JsonParser p, DeserializationContext ctxt) throws JacksonException {
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
