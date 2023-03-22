/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.bukkit.Color;

/**
 * Class for wrapping a {@link Color}.
 * <p>
 * It also allows transformation to hex code and parsing of hex code.
 * <p>
 * This class is used on Paper Servers starting from 1.19 where alpha was introduced to colors.
 */
@JsonPropertyOrder({"format", "red", "green", "blue", "alpha"})
public final class RGBAColorWrapper extends RGBColorWrapper {
    private final int alpha;

    /**
     * Create a new color wrapper for RGBA colors
     *
     * @param red   red value
     * @param green green value
     * @param blue  blue value
     * @param alpha alpha value
     */
    @JsonCreator
    public RGBAColorWrapper(@JsonProperty("red") int red,
                            @JsonProperty("green") int green,
                            @JsonProperty("blue") int blue,
                            @JsonProperty("alpha") int alpha) {
        super(red, green, blue);
        this.alpha = alpha;
    }

    /**
     * Create a new {@link RGBAColorWrapper} based on a {@link Color}.
     *
     * @param color color instance
     * @return new {@link RGBAColorWrapper} instance
     */
    public static RGBAColorWrapper of(Color color) {
        return new RGBAColorWrapper(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
    }

    /**
     * Create a new {@link RGBAColorWrapper} based on a hex string with RGBA or RGB.
     *
     * @param hex color as hex string
     * @return new {@link RGBAColorWrapper} instance
     */
    public static RGBAColorWrapper of(String hex) {
        int red = Integer.parseInt(hex.substring(0, 2), 16);
        int green = Integer.parseInt(hex.substring(2, 4), 16);
        int blue = Integer.parseInt(hex.substring(4, 6), 16);
        int alpha = hex.length() == 8 ? Integer.parseInt(hex.substring(6, 8), 16) : 255;
        return new RGBAColorWrapper(red, green, blue, alpha);
    }

    /**
     * Get the string as hex string with RGBA.
     *
     * @return hex color as RGBA
     */
    public String asHex() {
        return "%02X%02X%02X%02X".formatted(red(), green(), blue(), alpha);
    }

    /**
     * Constructs a new color instance based on wrapper values.
     *
     * @return new color instance
     */
    public Color toBukkitColor() {
        return Color.fromARGB(alpha, red(), green(), blue());
    }

    /**
     * Alpha value of the color
     *
     * @return alpha
     */
    @JsonProperty
    public int alpha() {
        return alpha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        RGBAColorWrapper that = (RGBAColorWrapper) o;

        return alpha == that.alpha;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + alpha;
        return result;
    }

    @Override
    public String toString() {
        return "RGBAColorWrapper[red=%d, green=%d, blue=%d, alpha=%d]".formatted(red(), green(), blue(), alpha);
    }
}
