/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import com.google.gson.JsonIOException;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonParser;
import tools.jackson.core.exc.JacksonIOException;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ValueDeserializer;
import tools.jackson.databind.type.MapType;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * Class for deserialization of {@link ItemStack} as a map.
 */
public class LegacyItemStackDeserializer extends ValueDeserializer<ItemStack> {
    private static final Yaml YAML = new Yaml(new Constructor(new LoaderOptions()));

    @Override
    public ItemStack deserialize(JsonParser p, DeserializationContext ctxt) throws JacksonException {
        return parseTree(ctxt.readTree(p), ctxt);
    }

    protected ItemStack parseTree(JsonNode tree, DeserializationContext ctxt) throws JacksonException {
        MapType type = ctxt.getTypeFactory().constructMapType(HashMap.class, String.class, Object.class);

        YamlConfiguration yamlConfiguration = new YamlConfiguration();
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("map", ctxt.readTreeAsValue(tree, type));
            yamlConfiguration.loadFromString(YAML.dump(map));
        } catch (InvalidConfigurationException e) {
            throw JacksonIOException.construct(new IOException(e));
        }

        return (ItemStack) yamlConfiguration.get("map");
    }
}
