/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import de.eldoria.jacksonbukkit.util.PaperFeatures;
import org.bukkit.inventory.ItemStack;

import java.io.IOException;
import java.util.Base64;

/**
 * Class for serialization of {@link ItemStack} as {@code byte[]}.
 */
public class PaperItemStackSerializer extends LegacyItemStackSerializer {
    @Override
    public void serialize(ItemStack value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if (PaperFeatures.HAS_SERIALIZE_AS_BYTES) {
            gen.writeString(Base64.getEncoder().encodeToString(value.serializeAsBytes()));
        } else {
            super.serialize(value, gen, serializers);
        }
    }
}
