/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.entities;

import java.util.Map;

public class MapContainer {
    public Map<String, Object> map;

    public MapContainer() {
    }

    public MapContainer(Map<String, Object> map) {
        this.map = map;
    }
}
