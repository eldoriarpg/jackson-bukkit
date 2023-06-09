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
import org.bukkit.NamespacedKey;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.io.IOException;

/**
 * Class for deserialization of {@link PotionEffect}.
 */
public class PotionEffectTypeDeserializer extends JsonDeserializer<PotionEffectType> {
    @Override
    public PotionEffectType deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode tree = ctxt.readTree(p);
        if (tree.isInt()) {
            return PotionEffectType.getById(ctxt.readValue(p, Integer.class));
        }
        if (tree.isObject()) {
            return PotionEffectType.getByKey(ctxt.readTreeAsValue(tree, NamespacedKey.class));
        }

        throw new IOException("Unknown type for field type" + tree.getNodeType().name());
    }
}
