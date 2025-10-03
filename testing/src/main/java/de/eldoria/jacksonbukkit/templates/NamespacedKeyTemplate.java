/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.templates;

import org.bukkit.NamespacedKey;

import java.util.List;

public class NamespacedKeyTemplate {
    public static final NamespacedKey SINGLE = new NamespacedKey("key", "name");
    public static final NamespacedKey SINGLE_MINECRAFT = new NamespacedKey("minecraft", "name");

    public static final List<NamespacedKey> LIST = List.of(SINGLE, SINGLE, SINGLE);
    public static final List<NamespacedKey> LIST_MINECRAFT = List.of(SINGLE_MINECRAFT, SINGLE_MINECRAFT, SINGLE_MINECRAFT);
}
