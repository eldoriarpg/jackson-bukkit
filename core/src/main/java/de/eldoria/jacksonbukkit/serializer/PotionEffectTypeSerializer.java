/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import de.eldoria.jacksonbukkit.util.Reflections;
import org.bukkit.NamespacedKey;
import org.bukkit.potion.PotionEffectType;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonGenerator;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.ValueSerializer;

/**
 * Class for serialization of {@link PotionEffectType}.
 */
public class PotionEffectTypeSerializer extends ValueSerializer<PotionEffectType> {

    public static final boolean LEGACY;

    static {
        LEGACY = !Reflections.methodExists(PotionEffectType.class, "getByKey", NamespacedKey.class);
    }

    @Override
    public void serialize(PotionEffectType value, JsonGenerator gen, SerializationContext serializers) throws JacksonException {
        if (LEGACY) {
            gen.writePOJO(value.getId());
        } else {
            gen.writePOJO(value.getKey());
        }
    }
}
