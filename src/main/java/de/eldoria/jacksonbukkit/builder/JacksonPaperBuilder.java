/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.builder;

import de.eldoria.jacksonbukkit.JacksonBukkit;
import de.eldoria.jacksonbukkit.JacksonPaper;
import org.bukkit.configuration.serialization.ConfigurationSerializable;

public class JacksonPaperBuilder extends ModuleBuilder<JacksonPaperBuilder, JacksonBukkit> {
    private boolean legacyItemStackSerialization = false;

    /**
     * Use legacy serializer which serializes the item stack as a map via {@link ConfigurationSerializable}.
     * <p>
     * <b>This does not work if the plugin is a {@code PaperPlugin}</b>
     *
     * @return builder instance
     */
    public JacksonPaperBuilder useLegacyItemStackSerialization() {
        legacyItemStackSerialization = true;
        return this;
    }

    @Override
    public JacksonBukkit build() {
        return new JacksonPaper(hexColors, legacyItemStackSerialization);
    }
}
