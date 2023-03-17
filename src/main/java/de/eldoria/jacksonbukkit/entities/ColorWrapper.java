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
public record ColorWrapper(int red, int green, int blue, int alpha) {

    /**
     * Create a new {@link ColorWrapper} based on a {@link Color}.
     *
     * @param color color instance
     * @return new {@link ColorWrapper} instance
     */
    public static ColorWrapper of(Color color) {
        return new ColorWrapper(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
    }

    /**
     * Create a new {@link ColorWrapper} based on a hex string with RGBA or RGB.
     *
     * @param hex color as hex string
     * @return new {@link ColorWrapper} instance
     */
    public static ColorWrapper of(String hex) {

        int red = Integer.parseInt(hex.substring(0, 2), 16);
        int green = Integer.parseInt(hex.substring(2, 4), 16);
        int blue = Integer.parseInt(hex.substring(4, 6), 16);
        int alpha = 255;
        if (hex.length() == 8) {
            alpha = Integer.parseInt(hex.substring(6, 8), 16);
        }

        return new ColorWrapper(red, green, blue, alpha);
    }

    /**
     * Get the string as hex string with RGBA.
     *
     * @return hex color as RGBA
     */
    public String asHex() {
        return "%02X%02X%02X%02X".formatted(red, green, blue, alpha);
    }

    private String pad(String s) {
        return (s.length() == 1) ? "0" + s : s;
    }

    /**
     * Constructs a new color instance based on wrapper values.
     *
     * @return new color instance
     */
    public Color toBukkitColor() {
        return Color.fromARGB(alpha, red, green, blue);
    }
}
