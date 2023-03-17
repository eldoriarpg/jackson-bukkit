/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.entities;

import org.bukkit.Color;

public record ColorWrapper(int red, int green, int blue, int alpha) {

    public static ColorWrapper of(Color color) {
        return new ColorWrapper(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
    }

    public Color toBukkitColor() {
        return Color.fromARGB(alpha, red, green, blue);
    }
}
