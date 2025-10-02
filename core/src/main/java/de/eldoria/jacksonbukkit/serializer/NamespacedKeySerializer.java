/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import de.eldoria.jacksonbukkit.entities.NamespacedKeyWrapper;
import org.bukkit.NamespacedKey;

import java.io.IOException;

/**
 * Class for serialization of {@link NamespacedKey}.
 */
public class NamespacedKeySerializer extends JsonSerializer<NamespacedKey> {

    private final Format format;

    public NamespacedKeySerializer(Format format) {
        this.format = format;
    }

    @Override
    public void serialize(NamespacedKey value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        switch (format) {
            case OBJECT -> gen.writeObject(NamespacedKeyWrapper.of(value));
            case FULL -> gen.writeString(value.toString());
            case SHORT -> {
                if (value.getNamespace().equals("minecraft")) {
                    gen.writeString(value.getKey());
                } else {
                    gen.writeString(value.toString());
                }
            }
        }
    }

    public enum Format {
        /*
         Deserialize using a wrapper object {"namespace": "minecraft", "key": "stone"}.
         */
        OBJECT,
        /*
         Deserialize using the full key. E.g. (minecraft:stone)
         */
        FULL,
        /*
         Deserialize using the key name. E.g., stone if the namespace is minecraft. Otherwise, the full key.
         */
        SHORT
    }
}
