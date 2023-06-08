/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import de.eldoria.jacksonbukkit.entities.ShapedRecipeWrapper;
import org.bukkit.inventory.ShapedRecipe;

import java.io.IOException;

/**
 * Class for serialization of {@link ShapedRecipe}.
 */
public class ShapedRecipeSerializer extends JsonSerializer<ShapedRecipe> {
    @Override
    public void serialize(ShapedRecipe value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeObject(ShapedRecipeWrapper.of(value));
    }
}
