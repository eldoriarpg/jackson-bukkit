/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.templates;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.block.banner.Pattern;
import org.bukkit.potion.PotionEffect;
import org.bukkit.util.BlockVector;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.Vector;

public class ComplexPojoTemplate {

    public static final ComplexPojo SINGLE = new ComplexPojo(
            AttributeModifierTemplate.SINGLE,
            BlockVectorTemplate.SINGLE,
            BoundingBoxTemplate.SINGLE,
            PaperColorTemplate.SINGLE,
            FireworkEffectTemplate.SINGLE,
            LocationTemplate.SINGLE,
            NamespacedKeyTemplate.SINGLE,
            PatternTemplate.SINGLE,
            PotionEffectTemplate.SINGLE,
            VectorTemplate.SINGLE
    );

    public record ComplexPojo(
            AttributeModifier strength,
            BlockVector skyIslandOrigin,
            BoundingBox boundingBox,
            Color color,
            FireworkEffect fireworkEffect,
            Location location,
            NamespacedKey namespacedKey,
            Pattern pattern,
            PotionEffect potionEffect,
            Vector heavyWeightedPressurePlateJump
    ) {
    }
}
