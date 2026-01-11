/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import de.eldoria.jacksonbukkit.entities.ShapelessRecipeWrapper;
import org.bukkit.inventory.ShapelessRecipe;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.ValueDeserializer;

/**
 * Class for deserialization of {@link ShapelessRecipe}.
 */
public class ShapelessRecipeDeserializer extends ValueDeserializer<ShapelessRecipe> {
    @Override
    public ShapelessRecipe deserialize(JsonParser p, DeserializationContext ctxt) throws JacksonException {
        return ctxt.readValue(p, ShapelessRecipeWrapper.class).toBukkitShapelessRecipe();
    }
}
