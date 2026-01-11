/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonGenerator;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.ValueSerializer;

/**
 * Class for serialization of {@link Component} using {@link MiniMessage}.
 */
public class ComponentMiniMessageSerializer extends ValueSerializer<Component> {

    private final MiniMessage miniMessage;

    /**
     * Creates a new serializer
     *
     * @param miniMessage MiniMessage instance to use
     */
    public ComponentMiniMessageSerializer(MiniMessage miniMessage) {
        this.miniMessage = miniMessage;
    }

    /**
     * Creates a new serializer
     */
    public ComponentMiniMessageSerializer() {
        this.miniMessage = MiniMessage.miniMessage();
    }

    @Override
    public void serialize(Component value, JsonGenerator gen, SerializationContext serializers) throws JacksonException {
        gen.writeString(miniMessage.serialize(value));
    }
}
