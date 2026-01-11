/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.builder;

import de.eldoria.jacksonbukkit.JacksonPaper;
import de.eldoria.jacksonbukkit.deserializer.ComponentGsonDeserializer;
import de.eldoria.jacksonbukkit.deserializer.ComponentMiniMessageDeserializer;
import de.eldoria.jacksonbukkit.serializer.ComponentGsonSerializer;
import de.eldoria.jacksonbukkit.serializer.ComponentMiniMessageSerializer;
import de.eldoria.jacksonbukkit.util.PaperFeatures;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.jetbrains.annotations.Nullable;
import tools.jackson.databind.ValueDeserializer;
import tools.jackson.databind.ValueSerializer;

/**
 * Class to build a {@link JacksonPaper} module.
 */
public class JacksonPaperBuilder extends ModuleBuilder<JacksonPaperBuilder, JacksonPaper> {
    private boolean legacyItemStackSerialization = false;
    private @Nullable ValueSerializer<Component> componentJsonSerializer;
    private @Nullable ValueDeserializer<Component> componentJsonDeserializer;

    /**
     * Create a new builder instance
     */
    public JacksonPaperBuilder() {
        if (PaperFeatures.HAS_MINI_MESSAGE) {
            componentJsonDeserializer = new ComponentMiniMessageDeserializer();
            componentJsonSerializer = new ComponentMiniMessageSerializer();
        } else if (PaperFeatures.HAS_ADVENTURE) {
            componentJsonSerializer = new ComponentGsonSerializer();
            componentJsonDeserializer = new ComponentGsonDeserializer();
        }
    }

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
    public JacksonPaperBuilder withMiniMessages(MiniMessage miniMessage) {
        this.componentJsonSerializer = new ComponentMiniMessageSerializer(miniMessage);
        this.componentJsonDeserializer = new ComponentMiniMessageDeserializer(miniMessage);
        return this;
    }

    /**
     * Use mini message for deserialization. This is the default behaviour when mini messages is present.
     *
     * @return builder instance
     */
    public JacksonPaperBuilder withMiniMessages() {
        this.componentJsonSerializer = new ComponentMiniMessageSerializer();
        this.componentJsonDeserializer = new ComponentMiniMessageDeserializer();
        return this;
    }

    @Override
    public JacksonPaper build() {
        return new JacksonPaper(hexColors, legacyItemStackSerialization, componentJsonDeserializer, componentJsonSerializer, namespacedKeyFormat);
    }
}
