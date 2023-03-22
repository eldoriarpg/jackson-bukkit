/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;

import java.io.IOException;

/**
 * Class for deserialization of {@link Component} using {@link MiniMessage}.
 */
public class ComponentMiniDeserializer extends JsonDeserializer<Component> {
    private final MiniMessage miniMessage;

    /**
     * Creates a new serializer
     *
     * @param miniMessage MiniMessage instance to use
     */
    public ComponentMiniDeserializer(MiniMessage miniMessage) {
        this.miniMessage = miniMessage;
    }

    @Override
    public Component deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
        return miniMessage.deserialize(ctxt.readValue(p, String.class));
    }
}
