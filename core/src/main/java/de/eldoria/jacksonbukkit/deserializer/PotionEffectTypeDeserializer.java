/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import org.bukkit.NamespacedKey;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonParser;
import tools.jackson.core.exc.JacksonIOException;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ValueDeserializer;

import java.io.IOException;

/**
 * Class for deserialization of {@link PotionEffect}.
 */
public class PotionEffectTypeDeserializer extends ValueDeserializer<PotionEffectType> {
    @Override
    public PotionEffectType deserialize(JsonParser p, DeserializationContext ctxt) throws JacksonException {
        JsonNode tree = ctxt.readTree(p);
        if (tree.isInt()) {
            return PotionEffectType.getById(ctxt.readValue(p, Integer.class));
        }
        if (tree.isObject()) {
            return PotionEffectType.getByKey(ctxt.readTreeAsValue(tree, NamespacedKey.class));
        }

        throw JacksonIOException.construct(new IOException("Unknown type for field type" + tree.getNodeType().name()));
    }
}
