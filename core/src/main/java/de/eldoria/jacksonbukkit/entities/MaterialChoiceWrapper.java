package de.eldoria.jacksonbukkit.entities;

import org.bukkit.Material;
import org.bukkit.inventory.RecipeChoice.MaterialChoice;

import java.util.List;

/**
 * Class for wrapping a {@link MaterialChoice}.
 */
public record MaterialChoiceWrapper(List<Material> choices) implements RecipeChoiceWrapper<MaterialChoice> {
    /**
     * Create a new {@link MaterialChoiceWrapper} based on a {@link MaterialChoice}.
     *
     * @param choice choice instance
     * @return new {@link MaterialChoiceWrapper} instance
     */
    public static MaterialChoiceWrapper of(MaterialChoice choice) {
        List<Material> choices = choice.getChoices();
        return new MaterialChoiceWrapper(choices);
    }

    /**
     * Constructs a new {@link MaterialChoice} based on wrapper values.
     *
     * @return new {@link MaterialChoice} instance
     */
    @Override
    public MaterialChoice toBukkitRecipeChoice() {
        return new MaterialChoice(choices);
    }
}
