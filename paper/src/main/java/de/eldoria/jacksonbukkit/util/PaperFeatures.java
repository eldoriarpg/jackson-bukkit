/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.util;

import org.bukkit.Color;
import org.bukkit.inventory.ItemStack;

public class PaperFeatures {
    public static final boolean IS_RGBA;
    public static final boolean HAS_SERIALIZE_AS_BYTES;

    static {
        // Check if this version supports ARGB colors (1.19+)
        boolean isRGBA = true;
        try {
            Color.class.getDeclaredMethod("getAlpha");
        } catch (NoSuchMethodException e) {
            isRGBA = false;
        }
        IS_RGBA = isRGBA;

        // Check if this version supports byte serialization (1.16+)
        boolean hasSerializeAsBytes = true;
        try {
            ItemStack.class.getDeclaredMethod("serializeAsBytes");
        } catch (NoSuchMethodException e) {
            hasSerializeAsBytes = false;
        }
        HAS_SERIALIZE_AS_BYTES = hasSerializeAsBytes;
    }
}
