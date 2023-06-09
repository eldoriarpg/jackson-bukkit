/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import de.eldoria.jacksonbukkit.entities.MaterialChoiceWrapper;
import org.bukkit.inventory.RecipeChoice.MaterialChoice;

import java.io.IOException;

/**
 * Class for deserialization of {@link MaterialChoice}.
 */
public class MaterialChoiceDeserializer extends JsonDeserializer<MaterialChoice> {
    @Override
    public MaterialChoice deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return ctxt.readValue(p, MaterialChoiceWrapper.class).toBukkitRecipeChoice();
    }
}
