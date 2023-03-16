/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.Module;

public class JacksonBukkitSpigot extends Module {
    @Override
    public String getModuleName() {
        return "JacksonBukkit";
    }

    @Override
    public Version version() {
        return new Version(1, 0, 0, "", "de.eldoria", "jackson-bukkit");
    }

    @Override
    public void setupModule(SetupContext context) {

    }
}

/*

- Vector
- BlockVector
- ItemStack
- Color
- PotionEffect
- FireworkEffect
- Pattern
- Location
- AttributeModifier
- BoundingBox

 */
