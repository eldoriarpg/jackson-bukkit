/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.templates;

import org.bukkit.DyeColor;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;

import java.util.List;

public class PatternTemplate {
    public static final Pattern SINGLE = new Pattern(DyeColor.RED, PatternType.BASE);

    public static final List<Pattern> LIST = List.of(new Pattern(DyeColor.BLACK, PatternType.BORDER),
            new Pattern(DyeColor.CYAN, PatternType.CROSS),
            SINGLE);
}
