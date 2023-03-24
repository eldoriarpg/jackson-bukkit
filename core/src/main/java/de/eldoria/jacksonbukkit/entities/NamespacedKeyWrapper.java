/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.entities;

import org.bukkit.NamespacedKey;

/**
 * Class for wrapping a {@link NamespacedKey}.
 */
public record NamespacedKeyWrapper(String namespace, String key) {
    /**
     * Create a new {@link NamespacedKeyWrapper} based on a {@link NamespacedKey}.
     *
     * @param key namespaced key instance
     * @return new {@link NamespacedKeyWrapper} instance
     */
    public static NamespacedKeyWrapper of(NamespacedKey key) {
        return new NamespacedKeyWrapper(key.getNamespace(), key.getKey());
    }

    /**
     * Constructs a new {@link NamespacedKey} based on wrapper values.
     *
     * @return new {@link NamespacedKey} instance
     */
    public NamespacedKey toBukkitNamespacedKey() {
        return new NamespacedKey(namespace, key);
    }
}
