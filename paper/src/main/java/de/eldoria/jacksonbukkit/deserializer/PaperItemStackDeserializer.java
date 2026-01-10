/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import de.eldoria.jacksonbukkit.util.PaperFeatures;
import org.bukkit.inventory.ItemStack;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.JsonNode;

import java.util.Base64;

/**
 * Class for deserialization of {@link ItemStack} as {@code byte[]}.
 */
public class PaperItemStackDeserializer extends LegacyItemStackDeserializer {
    @Override
    public ItemStack deserialize(JsonParser p, DeserializationContext ctxt) throws JacksonException {
        JsonNode tree = ctxt.readTree(p);
        if (tree.isTextual() && PaperFeatures.HAS_SERIALIZE_AS_BYTES) {
            byte[] decode = Base64.getDecoder().decode(ctxt.readValue(p, String.class));
            return ItemStack.deserializeBytes(decode);
        }
        return parseTree(tree, ctxt);
    }
}
