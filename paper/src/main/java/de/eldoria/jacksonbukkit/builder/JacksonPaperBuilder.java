/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.builder;

import de.eldoria.jacksonbukkit.JacksonPaper;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

/**
 * Class to build a {@link JacksonPaper} module.
 */
public class JacksonPaperBuilder extends ModuleBuilder<JacksonPaperBuilder, JacksonPaper> {
    private boolean legacyItemStackSerialization = false;
    private Supplier<MiniMessage> miniMessage = MiniMessage::miniMessage;

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

    /**
     * Supply a custom mini message instance to the module.
     *
     * @param miniMessage mini message instance. Providing null will disable component serialization.
     * @return builder instance
     */
    public JacksonPaperBuilder withMiniMessages(Supplier<@Nullable MiniMessage> miniMessage) {
        this.miniMessage = miniMessage;
        return this;
    }

    /**
     * Disable component support via mini messages.
     * <p>
     * This is equal to calling {@link #withMiniMessages(Supplier)} and providing {@code null}
     *
     * @return builder instance
     */
    public JacksonPaperBuilder withoutComponentSupport() {
        miniMessage = () -> null;
        return this;
    }

    @Override
    public JacksonPaper build() {
        return new JacksonPaper(hexColors, legacyItemStackSerialization, miniMessage);
    }
}
