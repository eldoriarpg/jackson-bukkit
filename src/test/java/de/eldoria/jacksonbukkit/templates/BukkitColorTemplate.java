/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.templates;

import org.bukkit.Color;

import java.util.List;

public class BukkitColorTemplate {
    public static final Color SINGLE = Color.fromRGB(
             255, 60, 0
    );

    public static final List<Color> LIST = List.of(
            Color.fromRGB( 255, 60, 0),
            Color.fromRGB( 20, 200, 70)
    );

}
