/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import de.eldoria.jacksonbukkit.entities.ShapedRecipeWrapper;
import org.bukkit.inventory.ShapedRecipe;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonGenerator;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.ValueSerializer;

/**
 * Class for serialization of {@link ShapedRecipe}.
 */
public class ShapedRecipeSerializer extends ValueSerializer<ShapedRecipe> {
    @Override
    public void serialize(ShapedRecipe value, JsonGenerator gen, SerializationContext serializers) throws JacksonException {
        gen.writePOJO(ShapedRecipeWrapper.of(value));
    }
}
