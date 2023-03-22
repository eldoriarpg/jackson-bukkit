/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.bukkit.inventory.ItemStack;

import java.io.IOException;

/**
 * Class for serialization of {@link ItemStack}.
 */
public class LegacyItemStackSerializer extends JsonSerializer<ItemStack> {
    @Override
    public void serialize(ItemStack value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeObject(value.serialize());
    }
}
