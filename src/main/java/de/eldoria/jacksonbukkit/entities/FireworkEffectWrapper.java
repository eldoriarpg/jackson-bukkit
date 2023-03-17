/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.entities;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;

import java.util.List;

/**
 * Class for wrapping a {@link FireworkEffect}.
 */
public record FireworkEffectWrapper(FireworkEffect.Type type, List<Color> colors, List<Color> fadeColors,
                                    boolean flicker, boolean trail) {
    /**
     * Create a new {@link FireworkEffectWrapper} based on a {@link FireworkEffect}.
     *
     * @param fireworkEffect firework effect instance
     * @return new {@link FireworkEffectWrapper} instance
     */
    public static FireworkEffectWrapper of(FireworkEffect fireworkEffect) {
        FireworkEffect.Type type = fireworkEffect.getType();
        List<Color> colors = fireworkEffect.getColors();
        List<Color> fadeColors = fireworkEffect.getFadeColors();
        boolean flicker = fireworkEffect.hasFlicker();
        boolean trail = fireworkEffect.hasTrail();
        return new FireworkEffectWrapper(type, colors, fadeColors, flicker, trail);
    }

    /**
     * Constructs a new {@link FireworkEffect} based on wrapper values.
     *
     * @return new {@link FireworkEffect} instance
     */
    public FireworkEffect toFireworkEffect() {
        return FireworkEffect.builder().with(type).withColor(colors).withFade(fadeColors).flicker(flicker).trail(trail).build();
    }
}
