/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.entities;

import org.bukkit.util.BoundingBox;
import org.bukkit.util.Vector;

/**
 * Class for wrapping a {@link BoundingBox}.
 */
public record BoundingBoxWrapper(Vector corner1, Vector corner2) {

    /**
     * Create a new {@link BoundingBoxWrapper} based on a {@link BoundingBox}.
     *
     * @param boundingBox bounding box instance
     * @return new {@link BoundingBoxWrapper} instance
     */
    public static BoundingBoxWrapper of(BoundingBox boundingBox) {
        return new BoundingBoxWrapper(
                boundingBox.getMin(),
                boundingBox.getMax()
        );
    }

    /**
     * Constructs a new {@link BoundingBox} based on wrapper values.
     *
     * @return new {@link BoundingBox} instance
     */
    public BoundingBox toBukkitBoundingBox() {
        return BoundingBox.of(
                corner1,
                corner2
        );
    }

}
