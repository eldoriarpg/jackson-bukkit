/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.type.MapType;
import org.bukkit.inventory.ItemStack;

import java.io.IOException;
import java.util.HashMap;

/**
 * Class for deserialization of {@link ItemStack} as a map.
 */
public class LegacyItemStackDeserializer extends JsonDeserializer<ItemStack> {
    @Override
    public ItemStack deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        MapType type = ctxt.getTypeFactory().constructMapType(HashMap.class, String.class, Object.class);
        return ItemStack.deserialize(ctxt.readValue(p, type));
    }
}
