/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;


import de.eldoria.jacksonbukkit.util.Reflections;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonGenerator;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.ValueSerializer;

public class EnchantmentSerializer extends ValueSerializer<Enchantment> {
    public static final boolean LEGACY;

    static {
        LEGACY = !Reflections.methodExists(Enchantment.class, "getByKey", NamespacedKey.class);
    }

    @Override
    public void serialize(Enchantment value, JsonGenerator gen, SerializationContext serializers) throws JacksonException {
        if (LEGACY) {
            gen.writePOJO(value.getName());
        } else {
            gen.writePOJO(value.getKey());
        }
    }
}
