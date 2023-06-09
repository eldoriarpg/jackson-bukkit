/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import de.eldoria.jacksonbukkit.entities.ShapedRecipeWrapper;
import org.bukkit.inventory.ShapedRecipe;

import java.io.IOException;

/**
 * Class for deserialization of {@link ShapedRecipe}.
 */
public class ShapedRecipeDeserializer extends JsonDeserializer<ShapedRecipe> {
    @Override
    public ShapedRecipe deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return ctxt.readValue(p, ShapedRecipeWrapper.class).toBukkitShapedRecipe();
    }
}
