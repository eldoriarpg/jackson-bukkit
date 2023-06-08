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
import org.bukkit.enchantments.Enchantment;

import java.io.IOException;

public class EnchantmentDeserializer extends JsonDeserializer<Enchantment> {
    @Override
    public Enchantment deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode tree = ctxt.readTree(p);
        if (tree.isTextual()) {
            return Enchantment.getByName(ctxt.readValue(p, String.class));
        }

        if (tree.isObject()) {
            return Enchantment.getByKey(ctxt.readTreeAsValue(tree, NamespacedKey.class));
        }
        throw new IOException("Unknown type for field type" + tree.getNodeType().name());
    }
}
