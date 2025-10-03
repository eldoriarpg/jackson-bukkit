/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.builder;

import de.eldoria.jacksonbukkit.JacksonBukkitModule;
import de.eldoria.jacksonbukkit.serializer.NamespacedKeySerializer;

/**
 * Base class for module builder.
 *
 * @param <T> type of builder
 * @param <V> type of created module
 */
public abstract class ModuleBuilder<T, V extends JacksonBukkitModule> {
    /**
     * Whether hex colors should be serialized as hex or not.
     */
    protected boolean hexColors = false;
    protected NamespacedKeySerializer.Format namespacedKeyFormat = NamespacedKeySerializer.Format.OBJECT;

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
     * Define the format used for serializing namespaced keys. Every format can be deserialized, independent of this setting.
     *
     * @return builder instance
     */
    public T withNamespacedKeyFormat(NamespacedKeySerializer.Format format) {
        this.namespacedKeyFormat = format;
        return (T) this;
    }

    /**
     * Build the module
     *
     * @return new module instance
     */
    public abstract V build();
}
