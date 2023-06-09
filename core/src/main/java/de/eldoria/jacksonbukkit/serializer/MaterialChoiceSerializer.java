/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import de.eldoria.jacksonbukkit.entities.MaterialChoiceWrapper;
import org.bukkit.inventory.RecipeChoice.MaterialChoice;

import java.io.IOException;

/**
 * Class for serialization of {@link MaterialChoice}.
 */
public class MaterialChoiceSerializer extends JsonSerializer<MaterialChoice> {
    @Override
    public void serialize(MaterialChoice value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeObject(MaterialChoiceWrapper.of(value));
    }
}
