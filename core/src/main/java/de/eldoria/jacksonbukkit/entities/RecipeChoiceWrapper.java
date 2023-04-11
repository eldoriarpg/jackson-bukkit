package de.eldoria.jacksonbukkit.entities;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.bukkit.inventory.RecipeChoice;

/**
 * Class for wrapping a {@link RecipeChoice}.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "@clazz")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ShapedRecipeWrapper.class, name = "ShapedRecipe"),
        @JsonSubTypes.Type(value = ShapelessRecipeWrapper.class, name = "ShapedRecipe")
})
public interface RecipeChoiceWrapper<T extends RecipeChoice> {

    /**
     * Constructs a new {@link T} based on wrapper values.
     *
     * @return new {@link T} instance
     */
    T toBukkitRecipeChoice();
}
