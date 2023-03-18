/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.entities;

import org.bukkit.Color;

/**
 * Class for wrapping a {@link Color}.
 * <p>
 * It also allows transformation to hex code and parsing of hex code.
 */
public record BukkitColorWrapper(int red, int green, int blue) {

    /**
     * Create a new {@link BukkitColorWrapper} based on a {@link Color}.
     *
     * @param color color instance
     * @return new {@link BukkitColorWrapper} instance
     */
    public static BukkitColorWrapper of(Color color) {
        return new BukkitColorWrapper(color.getRed(), color.getGreen(), color.getBlue());
    }

    /**
     * Create a new {@link BukkitColorWrapper} based on a hex string with RGBA or RGB.
     *
     * @param hex color as hex string
     * @return new {@link BukkitColorWrapper} instance
     */
    public static BukkitColorWrapper of(String hex) {
        int red = Integer.parseInt(hex.substring(0, 2), 16);
        int green = Integer.parseInt(hex.substring(2, 4), 16);
        int blue = Integer.parseInt(hex.substring(4, 6), 16);
        return new BukkitColorWrapper(red, green, blue);
    }

    /**
     * Get the string as hex string with RGBA.
     *
     * @return hex color as RGBA
     */
    public String asHex() {
        return "%02X%02X%02X".formatted(red, green, blue);
    }

    /**
     * Constructs a new color instance based on wrapper values.
     *
     * @return new color instance
     */
    public Color toBukkitColor() {
        return Color.fromRGB(red, green, blue);
    }
}
