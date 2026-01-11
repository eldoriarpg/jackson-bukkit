/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import de.eldoria.jacksonbukkit.entities.MaterialChoiceWrapper;
import org.bukkit.inventory.RecipeChoice.MaterialChoice;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonGenerator;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.ValueSerializer;

/**
 * Class for serialization of {@link MaterialChoice}.
 */
public class MaterialChoiceSerializer extends ValueSerializer<MaterialChoice> {
    @Override
    public void serialize(MaterialChoice value, JsonGenerator gen, SerializationContext serializers) throws JacksonException {
        gen.writePOJO(MaterialChoiceWrapper.of(value));
    }
}
