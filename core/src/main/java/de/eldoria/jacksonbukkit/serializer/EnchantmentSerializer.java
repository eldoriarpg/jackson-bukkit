/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import de.eldoria.jacksonbukkit.util.Reflections;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;

import java.io.IOException;

public class EnchantmentSerializer extends JsonSerializer<Enchantment> {
    public static final boolean LEGACY;

    static {
        LEGACY = !Reflections.methodExists(Enchantment.class, "getByKey", NamespacedKey.class);
    }

    @Override
    public void serialize(Enchantment value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if (LEGACY) {
            gen.writeObject(value.getName());
        } else {
            gen.writeObject(value.getKey());
        }
    }
}
