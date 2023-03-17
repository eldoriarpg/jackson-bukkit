/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.entities;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public record LocationWrapper(@Nullable UUID uid, @Nullable String name, double xCoord, double yCoord, double zCoord,
                              float yaw, float pitch) {

    public static LocationWrapper fromLocation(Location loc) {
        if (loc.getWorld() == null) {
            return new LocationWrapper(null, null, loc.getX(), loc.getY(), loc.getZ(), loc.getYaw(), loc.getPitch());
        }
        return new LocationWrapper(loc.getWorld().getUID(), loc.getWorld().getName(), loc.getX(), loc.getY(), loc.getZ(), loc.getYaw(), loc.getPitch());
    }

    public Location toLocation() {
        if (uid != null && name != null) {
            World world = Bukkit.getWorld(uid);
            if (world == null) {
                world = Bukkit.getWorld(name);
            }
            return new Location(world, xCoord, yCoord, zCoord, yaw, pitch);
        }
        if (name != null) {
            return new Location(Bukkit.getWorld(name), xCoord, yCoord, zCoord, yaw, pitch);
        }
        if (uid != null) {
            return new Location(Bukkit.getWorld(uid), xCoord, yCoord, zCoord, yaw, pitch);
        }
        return new Location(null, xCoord, yCoord, zCoord, yaw, pitch);
    }
}
