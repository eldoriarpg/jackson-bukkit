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
import de.eldoria.jacksonbukkit.entities.MapContainer;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.constructor.SafeConstructor;

import java.io.IOException;
import java.util.HashMap;

/**
 * Class for deserialization of {@link ItemStack} as a map.
 */
public class LegacyItemStackDeserializer extends JsonDeserializer<ItemStack> {
    private static final Yaml YAML = new Yaml(new Constructor(new LoaderOptions()));

    @Override
    public ItemStack deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return parseTree(ctxt.readTree(p), ctxt);
    }

    protected ItemStack parseTree(JsonNode tree, DeserializationContext ctxt) throws IOException {
        MapType type = ctxt.getTypeFactory().constructMapType(HashMap.class, String.class, Object.class);

        YamlConfiguration yamlConfiguration = new YamlConfiguration();
        try {
            yamlConfiguration.loadFromString(YAML.dump(new MapContainer(ctxt.readTreeAsValue(tree, type))));
        } catch (InvalidConfigurationException e) {
            throw new IOException(e);
        }

        return (ItemStack) yamlConfiguration.get("map");
    }
}
