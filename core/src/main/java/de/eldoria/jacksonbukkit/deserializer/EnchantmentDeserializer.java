/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonParser;
import tools.jackson.core.exc.JacksonIOException;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ValueDeserializer;

import java.io.IOException;

public class EnchantmentDeserializer extends ValueDeserializer<Enchantment> {
    @Override
    public Enchantment deserialize(JsonParser p, DeserializationContext ctxt) throws JacksonException {
        JsonNode tree = ctxt.readTree(p);
        if (tree.isTextual()) {
            return Enchantment.getByName(ctxt.readTreeAsValue(tree, String.class));
        }

        if (tree.isObject()) {
            return Enchantment.getByKey(ctxt.readTreeAsValue(tree, NamespacedKey.class));
        }
        throw JacksonIOException.construct(new IOException("Unknown type for field type" + tree.getNodeType().name()));
    }
}
