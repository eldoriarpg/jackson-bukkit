/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import com.google.gson.Gson;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ValueDeserializer;
import tools.jackson.databind.type.MapType;

import java.util.HashMap;
import java.util.Map;

/**
 * Class for deserialization of {@link Component} using {@link Gson}.
 */
public class ComponentGsonDeserializer extends ValueDeserializer<Component> {
    private static final Gson GSON = new Gson();

    @Override
    public Component deserialize(JsonParser p, DeserializationContext ctxt) throws JacksonException {
        JsonNode tree = ctxt.readTree(p);
        return parseObjectTree(tree, ctxt);
    }

    protected Component parseObjectTree(JsonNode tree, DeserializationContext ctxt) throws JacksonException {
        MapType type = ctxt.getTypeFactory().constructMapType(HashMap.class, String.class, Object.class);
        Map<String, Object> map = ctxt.readTreeAsValue(tree, type);
        return GsonComponentSerializer.gson().deserialize(GSON.toJson(map));
    }
}
