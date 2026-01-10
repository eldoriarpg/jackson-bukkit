/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import de.eldoria.jacksonbukkit.entities.MaterialChoiceWrapper;
import org.bukkit.inventory.RecipeChoice.MaterialChoice;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.ValueDeserializer;

/**
 * Class for deserialization of {@link MaterialChoice}.
 */
public class MaterialChoiceDeserializer extends ValueDeserializer<MaterialChoice> {
    @Override
    public MaterialChoice deserialize(JsonParser p, DeserializationContext ctxt) throws JacksonException {
        return ctxt.readValue(p, MaterialChoiceWrapper.class).toBukkitRecipeChoice();
    }
}
