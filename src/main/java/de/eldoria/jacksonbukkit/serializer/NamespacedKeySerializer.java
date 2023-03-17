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
    @Override
    public void serialize(NamespacedKey value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeObject(NamespacedKeyWrapper.of(value));
    }
}
