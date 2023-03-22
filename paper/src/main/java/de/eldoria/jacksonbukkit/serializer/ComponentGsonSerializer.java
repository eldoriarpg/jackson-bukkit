/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * Class for serialization of {@link Component} using {@link MiniMessage}.
 */
public class ComponentGsonSerializer extends JsonSerializer<Component> {
    private static final Type MAP_TYPE = new TypeToken<Map<String, Object>>() {
    }.getType();

    private static final Gson GSON = new Gson();

    /**
     * Creates a new serializer
     */
    public ComponentGsonSerializer() {
    }

    @Override
    public void serialize(Component value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        String serialize = GsonComponentSerializer.gson().serialize(value);
        Map<String, Object> component = GSON.fromJson(serialize, MAP_TYPE);
        gen.writeObject(component);
    }
}
