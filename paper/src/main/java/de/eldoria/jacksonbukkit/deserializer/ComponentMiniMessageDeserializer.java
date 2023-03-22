/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.type.MapType;
import com.google.gson.Gson;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Class for deserialization of {@link Component} using {@link MiniMessage}.
 */
public class ComponentMiniMessageDeserializer extends ComponentGsonDeserializer {
    private final MiniMessage miniMessage;
    private static final Gson GSON = new Gson();

    /**
     * Creates a new serializer
     *
     * @param miniMessage MiniMessage instance to use
     */
    public ComponentMiniMessageDeserializer(MiniMessage miniMessage) {
        this.miniMessage = miniMessage;
    }

    /**
     * Creates a new serializer
     */
    public ComponentMiniMessageDeserializer() {
        miniMessage = MiniMessage.miniMessage();
    }

    @Override
    public Component deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode tree = ctxt.readTree(p);
        if (tree.isObject()) {
            return parseObjectTree(tree, ctxt);
        }
        return miniMessage.deserialize(ctxt.readValue(p, String.class));
    }

    protected Component parseObjectTree(JsonNode tree, DeserializationContext ctxt) throws IOException {
        MapType type = ctxt.getTypeFactory().constructMapType(HashMap.class, String.class, Object.class);
        Map<String, Object> map = ctxt.readTreeAsValue(tree, type);
        return GsonComponentSerializer.gson().deserialize(GSON.toJson(map));
    }
}
