/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import de.eldoria.jacksonbukkit.entities.NamespacedKeyWrapper;
import org.bukkit.NamespacedKey;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonGenerator;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.ValueSerializer;

/**
 * Class for serialization of {@link NamespacedKey}.
 */
public class NamespacedKeySerializer extends ValueSerializer<NamespacedKey> {

    private final Format format;

    public NamespacedKeySerializer(Format format) {
        this.format = format;
    }

    @Override
    public void serialize(NamespacedKey value, JsonGenerator gen, SerializationContext serializers) throws JacksonException {
        switch (format) {
            case OBJECT -> gen.writePOJO(NamespacedKeyWrapper.of(value));
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
