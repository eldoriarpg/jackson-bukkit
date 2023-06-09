/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.entities;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.bukkit.inventory.RecipeChoice;

/**
 * Class for wrapping a {@link RecipeChoice}.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "@clazz")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ExactChoiceWrapper.class, name = "ExactChoice"),
        @JsonSubTypes.Type(value = MaterialChoiceWrapper.class, name = "MaterialChoice")
})
public interface RecipeChoiceWrapper<T extends RecipeChoice> {

    /**
     * Constructs a new {@link T} based on wrapper values.
     *
     * @return new {@link T} instance
     */
    T toBukkitRecipeChoice();

    public static RecipeChoiceWrapper<?> of(RecipeChoice choice) {
        if (choice == null) {
            return null;
        }

        if (choice instanceof RecipeChoice.ExactChoice c) {
            return ExactChoiceWrapper.of(c);
        }

        if (choice instanceof RecipeChoice.MaterialChoice c) {
            return MaterialChoiceWrapper.of(c);
        }
        throw new IllegalArgumentException("%s is not a known RecipeChoice".formatted(choice.getClass().getName()));
    }
}
