/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.builder;

import de.eldoria.jacksonbukkit.JacksonBukkit;

public abstract class ModuleBuilder<T, V extends JacksonBukkit> {
    protected boolean hexColors = false;

    /**
     * Serialize {@link org.bukkit.Color} as hex string.
     *
     * @return builder instance
     */
    public T colorAsHex() {
        hexColors = true;
        return (T) this;
    }

    /**
     * Serialize {@link org.bukkit.Color} as hex string.
     *
     * @param hexColors true to serialize colors as hex.
     * @return builder instance
     */
    public T colorAsHex(boolean hexColors) {
        this.hexColors = hexColors;
        return (T) this;
    }

    /**
     * Build the module
     *
     * @return new module instance
     */
    public abstract V build();
}
