/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.entities;

import org.bukkit.DyeColor;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;
import org.bukkit.potion.PotionEffect;

/**
 * Class for wrapping a {@link Pattern}.
 */
public record PatternWrapper(DyeColor color, PatternType pattern) {
    /**
     * Create a new {@link PatternWrapper} based on a {@link Pattern}.
     *
     * @param pattern pattern instance
     * @return new {@link PatternWrapper} instance
     */
    public static PatternWrapper of(Pattern pattern) {
        return new PatternWrapper(pattern.getColor(), pattern.getPattern());
    }

    /**
     * Constructs a new {@link Pattern} based on wrapper values.
     *
     * @return new {@link Pattern} instance
     */
    public Pattern toBukkitPattern() {
        return new Pattern(color, pattern);
    }
}
