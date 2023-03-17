/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.templates;

import org.bukkit.util.BoundingBox;
import org.bukkit.util.Vector;

import java.util.List;

public class BoundingBoxTemplate {

    public static final BoundingBox SINGLE = BoundingBox.of(
            new Vector(10, 20, 10),
            new Vector(60, 40, 300)
    );

    public static final List<BoundingBox> LIST = List.of(
            BoundingBox.of(
                    new Vector(10, 20, 10),
                    new Vector(20, 40, 300)
            ),
            BoundingBox.of(
                    new Vector(20, 40, 10),
                    new Vector(40, 80, 300)
            ),
            BoundingBox.of(
                    new Vector(30, 80, 10),
                    new Vector(60, 160, 300)
            )
    );
}
