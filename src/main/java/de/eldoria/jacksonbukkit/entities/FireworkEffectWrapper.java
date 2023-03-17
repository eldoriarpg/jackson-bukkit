/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.entities;

import org.bukkit.FireworkEffect;

import java.util.List;

public record FireworkEffectWrapper(FireworkEffect.Type type, List<org.bukkit.Color> colors,
                                    List<org.bukkit.Color> fadeColors, boolean flicker, boolean trail) {
    public FireworkEffect toFireworkEffect() {
        return FireworkEffect.builder().with(type).withColor(colors).withFade(fadeColors).flicker(flicker).trail(trail).build();
    }
}
