/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.util;

import org.bukkit.Color;
import org.bukkit.inventory.ItemStack;

/**
 * Class used to check for api features of a Paper server.
 */
public class PaperFeatures {
    /**
     * True when {@link Color} supports alpha values.
     */
    public static final boolean IS_RGBA;

    /**
     * True when {@link ItemStack} supports {@code ItemStack#serializeAsBytes()}
     */
    public static final boolean HAS_SERIALIZE_AS_BYTES;

    static {
        // Check if this version supports ARGB colors (1.19+)
        IS_RGBA = Reflections.methodExists(Color.class, "getAlpha");

        // Check if this version supports byte serialization (1.16+)
        HAS_SERIALIZE_AS_BYTES = Reflections.methodExists(ItemStack.class, "serializeAsBytes");
    }
}
