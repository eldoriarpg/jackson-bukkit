/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.entities;

import org.bukkit.NamespacedKey;

public record NamespacedKeyWrapper(String namespace, String key) {
    public NamespacedKey toKey() {
        return new NamespacedKey(namespace, key);
    }
}
