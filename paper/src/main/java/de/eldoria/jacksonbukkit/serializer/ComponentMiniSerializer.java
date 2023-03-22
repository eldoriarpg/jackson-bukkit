/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Color;

import java.io.IOException;

/**
 * Class for serialization of {@link Component} using {@link MiniMessage}.
 */
public class ComponentMiniSerializer extends JsonSerializer<Component> {

    private final MiniMessage miniMessage;

    /**
     * Creates a new serializer
     * @param miniMessage MiniMessage instance to use
     */
    public ComponentMiniSerializer(MiniMessage miniMessage) {
        this.miniMessage = miniMessage;
    }

    @Override
    public void serialize(Component value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeString(miniMessage.serialize(value));
    }
}
