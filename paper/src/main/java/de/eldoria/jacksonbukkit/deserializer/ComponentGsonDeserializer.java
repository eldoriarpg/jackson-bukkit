/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
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
 * Class for deserialization of {@link Component} using {@link Gson}.
 */
public class ComponentGsonDeserializer extends JsonDeserializer<Component> {
    private static final Gson GSON = new Gson();

    /**
     * Creates a new serializer
     */
    public ComponentGsonDeserializer() {
    }

    @Override
    public Component deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode tree = ctxt.readTree(p);
        return parseObjectTree(tree, ctxt);
    }

    protected Component parseObjectTree(JsonNode tree, DeserializationContext ctxt) throws IOException {
        MapType type = ctxt.getTypeFactory().constructMapType(HashMap.class, String.class, Object.class);
        Map<String, Object> map = ctxt.readTreeAsValue(tree, type);
        return GsonComponentSerializer.gson().deserialize(GSON.toJson(map));
    }
}
