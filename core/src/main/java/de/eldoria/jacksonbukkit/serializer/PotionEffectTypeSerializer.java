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
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.io.IOException;

/**
 * Class for serialization of {@link PotionEffect}.
 */
public class PotionEffectTypeSerializer extends JsonSerializer<PotionEffectType> {

    public static final boolean LEGACY;

    static {
        LEGACY = !Reflections.methodExists(PotionEffectType.class, "getByKey", NamespacedKey.class);
    }

    @Override
    public void serialize(PotionEffectType value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if (LEGACY) {
            gen.writeObject(value.getId());
        } else {
            gen.writeObject(value.getKey());
        }
    }
}
