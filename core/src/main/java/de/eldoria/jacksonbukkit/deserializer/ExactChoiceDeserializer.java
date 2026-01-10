/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import de.eldoria.jacksonbukkit.entities.ExactChoiceWrapper;
import org.bukkit.inventory.RecipeChoice.ExactChoice;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.ValueDeserializer;

/**
 * Class for deserialization of {@link ExactChoice}.
 */
public class ExactChoiceDeserializer extends ValueDeserializer<ExactChoice> {
    @Override
    public ExactChoice deserialize(JsonParser p, DeserializationContext ctxt) throws JacksonException {
        return ctxt.readValue(p, ExactChoiceWrapper.class).toBukkitRecipeChoice();
    }
}
