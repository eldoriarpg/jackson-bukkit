/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import de.eldoria.jacksonbukkit.entities.ExactChoiceWrapper;
import org.bukkit.inventory.RecipeChoice.ExactChoice;

import java.io.IOException;

/**
 * Class for deserialization of {@link ExactChoice}.
 */
public class ExactChoiceDeserializer extends JsonDeserializer<ExactChoice> {
    @Override
    public ExactChoice deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return ctxt.readValue(p, ExactChoiceWrapper.class).toBukkitRecipeChoice();
    }
}
