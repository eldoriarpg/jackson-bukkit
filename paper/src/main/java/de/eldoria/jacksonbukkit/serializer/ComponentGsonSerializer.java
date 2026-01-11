/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonGenerator;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.ValueSerializer;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * Class for serialization of {@link Component} using {@link MiniMessage}.
 */
public class ComponentGsonSerializer extends ValueSerializer<Component> {
    private static final Type MAP_TYPE = new TypeToken<Map<String, Object>>() {
    }.getType();

    private static final Gson GSON = new Gson();

    /**
     * Creates a new serializer
     */
    public ComponentGsonSerializer() {
    }

    @Override
    public void serialize(Component value, JsonGenerator gen, SerializationContext serializers) throws JacksonException {
        String serialize = GsonComponentSerializer.gson().serialize(value);
        Map<String, Object> component = GSON.fromJson(serialize, MAP_TYPE);
        gen.writePOJO(component);
    }
}
