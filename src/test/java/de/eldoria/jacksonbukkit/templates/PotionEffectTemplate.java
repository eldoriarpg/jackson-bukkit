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
            SINGLE.withType(PotionEffectType.CONFUSION).withDuration(10).withParticles(false),
            SINGLE.withAmbient(false).withIcon(false),
            SINGLE
    );
}
