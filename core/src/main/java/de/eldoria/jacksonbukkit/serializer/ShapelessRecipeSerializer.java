/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import de.eldoria.jacksonbukkit.entities.ShapelessRecipeWrapper;
import org.bukkit.inventory.ShapelessRecipe;

import java.io.IOException;

/**
 * Class for serialization of {@link ShapelessRecipe}.
 */
public class ShapelessRecipeSerializer extends JsonSerializer<ShapelessRecipe> {
    @Override
    public void serialize(ShapelessRecipe value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeObject(ShapelessRecipeWrapper.of(value));
    }
}
