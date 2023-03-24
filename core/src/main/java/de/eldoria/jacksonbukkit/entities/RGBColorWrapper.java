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

import java.util.Objects;

/**
 * Class for wrapping a {@link Color}.
 * <p>
 * It also allows transformation to hex code and parsing of hex code.
 */
@JsonPropertyOrder({"red", "green", "blue"})
public class RGBColorWrapper {
    private final int red;
    private final int green;
    private final int blue;

    /**
     * Create a new color wrapper for RGB colors
     *
     * @param red   red value
     * @param green green value
     * @param blue  blue value
     */
    @JsonCreator
    public RGBColorWrapper(@JsonProperty("red") int red,
                           @JsonProperty("green") int green,
                           @JsonProperty("blue") int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    /**
     * Create a new {@link RGBColorWrapper} based on a {@link Color}.
     *
     * @param color color instance
     * @return new {@link RGBColorWrapper} instance
     */
    public static RGBColorWrapper of(Color color) {
        return new RGBColorWrapper(color.getRed(), color.getGreen(), color.getBlue());
    }

    /**
     * Create a new {@link RGBColorWrapper} based on a hex string with RGBA or RGB.
     *
     * @param hex color as hex string
     * @return new {@link RGBColorWrapper} instance
     */
    public static RGBColorWrapper of(String hex) {
        int red = Integer.parseInt(hex.substring(0, 2), 16);
        int green = Integer.parseInt(hex.substring(2, 4), 16);
        int blue = Integer.parseInt(hex.substring(4, 6), 16);
        return new RGBColorWrapper(red, green, blue);
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

    /**
     * Value of color red
     *
     * @return red
     */
    @JsonProperty
    public int red() {
        return red;
    }

    /**
     * Value of color green
     *
     * @return green
     */
    @JsonProperty
    public int green() {
        return green;
    }

    /**
     * Value of color blue
     *
     * @return blue
     */
    @JsonProperty
    public int blue() {
        return blue;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (RGBColorWrapper) obj;
        return this.red == that.red &&
               this.green == that.green &&
               this.blue == that.blue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(red, green, blue);
    }

    @Override
    public String toString() {
        return "RGBColorWrapper[red=%d, green=%d, blue=%d]".formatted(red, green, blue);
    }
}
