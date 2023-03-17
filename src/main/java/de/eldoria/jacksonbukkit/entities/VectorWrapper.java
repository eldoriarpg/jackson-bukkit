/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.entities;

import org.bukkit.util.BlockVector;
import org.bukkit.util.Vector;

/**
 * Class for wrapping a {@link Vector}.
 * <p>
 * Allows creation of a {@link Vector} or {@link BlockVector}.
 */
public record VectorWrapper(double xCoord, double yCoord, double zCoord) {
    /**
     * Create a new {@link VectorWrapper} based on a {@link Vector}.
     *
     * @param vector vector instance
     * @return new {@link VectorWrapper} instance
     */
    public static VectorWrapper of(Vector vector) {
        return new VectorWrapper(vector.getX(), vector.getY(), vector.getZ());
    }

    public Vector toBukkitVector() {
        return new Vector(xCoord, yCoord, zCoord);
    }

    /**
     * Constructs a new {@link BlockVector} based on wrapper values.
     *
     * @return new {@link BlockVector} instance
     */
    public BlockVector toBukkitBlockVector() {
        return new BlockVector(xCoord, yCoord, zCoord);
    }
}
