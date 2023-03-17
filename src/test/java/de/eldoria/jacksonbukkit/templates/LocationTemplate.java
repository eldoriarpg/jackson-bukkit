/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.templates;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.util.List;

public class LocationTemplate {
    public static final Location SINGLE = new Location(Bukkit.getWorld("world"), 0, 0, 0, 0, 0);

    public static final List<Location> LIST = List.of(
            new Location(Bukkit.getWorld("world"), 10, 0, -10, 0.001f, 0.005f),
            new Location(null, 12, 0, 55, 285f, 250f),
            SINGLE
    );
}
