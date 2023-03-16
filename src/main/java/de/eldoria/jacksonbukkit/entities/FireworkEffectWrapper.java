package de.eldoria.jacksonbukkit.entities;

import org.bukkit.FireworkEffect;

import java.util.List;

public record FireworkEffectWrapper(FireworkEffect.Type type, List<org.bukkit.Color> colors,
                                    List<org.bukkit.Color> fadeColors, boolean flicker, boolean trail) {
    public FireworkEffect toFireworkEffect() {
        return FireworkEffect.builder().build();
    }
}
