package de.eldoria.jacksonbukkit.entities;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice.ExactChoice;

import java.util.List;

/**
 * Class for wrapping a {@link ExactChoice}.
 */
public record ExactChoiceWrapper(List<ItemStack> choices) implements RecipeChoiceWrapper<ExactChoice> {
    /**
     * Create a new {@link ExactChoiceWrapper} based on a {@link ExactChoice}.
     *
     * @param choice choice instance
     * @return new {@link ExactChoiceWrapper} instance
     */
    public static ExactChoiceWrapper of(ExactChoice choice) {
        List<ItemStack> choices = choice.getChoices();
        return new ExactChoiceWrapper(choices);
    }

    /**
     * Constructs a new {@link ExactChoice} based on wrapper values.
     *
     * @return new {@link ExactChoice} instance
     */
    @Override
    public ExactChoice toBukkitRecipeChoice() {
        return new ExactChoice(choices);
    }
}
