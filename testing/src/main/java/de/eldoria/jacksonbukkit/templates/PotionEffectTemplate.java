/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.templates;

import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;

public class PotionEffectTemplate {
    public static final PotionEffect SINGLE = new PotionEffect(PotionEffectType.BLINDNESS, 1, 1, true, true, true);

    public static final List<PotionEffect> LIST = List.of(
            new PotionEffect(PotionEffectType.CONFUSION, 10, 1, false, true, false),
            new PotionEffect(PotionEffectType.CONFUSION, 10, 1, true, true, false),
            SINGLE
    );
}
