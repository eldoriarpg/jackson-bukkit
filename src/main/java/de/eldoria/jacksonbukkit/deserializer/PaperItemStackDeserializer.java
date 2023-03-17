/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.bukkit.inventory.ItemStack;

import java.io.IOException;
import java.util.Base64;

/**
 * Class for deserialization of {@link ItemStack} as {@code byte[]}.
 */
public class PaperItemStackDeserializer extends JsonDeserializer<ItemStack> {
    @Override
    public ItemStack deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        byte[] decode = Base64.getDecoder().decode(ctxt.readValue(p, String.class));
        return ItemStack.deserializeBytes(decode);
    }
}
