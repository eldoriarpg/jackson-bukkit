/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import de.eldoria.jacksonbukkit.entities.ShapelessRecipeWrapper;
import org.bukkit.inventory.ShapelessRecipe;

import java.io.IOException;

/**
 * Class for deserialization of {@link ShapelessRecipe}.
 */
public class ShapelessRecipeDeserializer extends JsonDeserializer<ShapelessRecipe> {
    @Override
    public ShapelessRecipe deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return ctxt.readValue(p, ShapelessRecipeWrapper.class).toBukkitShapelessRecipe();
    }
}
