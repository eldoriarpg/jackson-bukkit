/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import de.eldoria.jacksonbukkit.entities.ExactChoiceWrapper;
import org.bukkit.inventory.RecipeChoice.ExactChoice;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonGenerator;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.ValueSerializer;

/**
 * Class for serialization of {@link ExactChoice}.
 */
public class ExactChoiceSerializer extends ValueSerializer<ExactChoice> {
    @Override
    public void serialize(ExactChoice value, JsonGenerator gen, SerializationContext serializers) throws JacksonException {
        gen.writePOJO(ExactChoiceWrapper.of(value));
    }
}
