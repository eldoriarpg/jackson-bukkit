/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.templates;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;

import java.util.List;

public class FireworkEffectTemplate {
    public static final FireworkEffect SINGLE = FireworkEffect.builder()
            .with(FireworkEffect.Type.BURST)
            .withFade(Color.AQUA)
            .withColor(Color.RED)
            .build();

    public static final List<FireworkEffect> LIST = List.of(
            FireworkEffect.builder()
                    .with(FireworkEffect.Type.BALL)
                    .withFade(Color.AQUA, Color.OLIVE)
                    .withColor(Color.RED)
                    .build(),
            FireworkEffect.builder()
                    .with(FireworkEffect.Type.BURST)
                    .withFade(Color.AQUA)
                    .withColor(Color.RED)
                    .trail(true)
                    .flicker(true)
                    .build(),
            SINGLE
    );
}
