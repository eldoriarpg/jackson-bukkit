/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import de.eldoria.jacksonbukkit.entities.ShapedRecipeWrapper;
import org.bukkit.inventory.ShapedRecipe;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.ValueDeserializer;

/**
 * Class for deserialization of {@link ShapedRecipe}.
 */
public class ShapedRecipeDeserializer extends ValueDeserializer<ShapedRecipe> {
    @Override
    public ShapedRecipe deserialize(JsonParser p, DeserializationContext ctxt) throws JacksonException {
        return ctxt.readValue(p, ShapedRecipeWrapper.class).toBukkitShapedRecipe();
    }
}
