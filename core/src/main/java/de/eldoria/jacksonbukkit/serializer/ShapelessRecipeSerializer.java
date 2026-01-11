/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import de.eldoria.jacksonbukkit.entities.ShapelessRecipeWrapper;
import org.bukkit.inventory.ShapelessRecipe;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonGenerator;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.ValueSerializer;

/**
 * Class for serialization of {@link ShapelessRecipe}.
 */
public class ShapelessRecipeSerializer extends ValueSerializer<ShapelessRecipe> {
    @Override
    public void serialize(ShapelessRecipe value, JsonGenerator gen, SerializationContext serializers) throws JacksonException {
        gen.writePOJO(ShapelessRecipeWrapper.of(value));
    }
}
