/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import de.eldoria.jacksonbukkit.entities.ExactChoiceWrapper;
import org.bukkit.inventory.RecipeChoice.ExactChoice;

import java.io.IOException;

/**
 * Class for serialization of {@link ExactChoice}.
 */
public class ExactChoiceSerializer extends JsonSerializer<ExactChoice> {
    @Override
    public void serialize(ExactChoice value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeObject(ExactChoiceWrapper.of(value));
    }
}
