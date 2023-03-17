/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.builder;

import de.eldoria.jacksonbukkit.JacksonBukkit;

/**
 * Class to build a {@link JacksonBukkit} module.
 */
public class JacksonBukkitBuilder extends ModuleBuilder<JacksonBukkitBuilder, JacksonBukkit> {
    @Override
    public JacksonBukkit build() {
        return new JacksonBukkit(hexColors);
    }
}
