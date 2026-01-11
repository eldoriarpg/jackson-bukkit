/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonGenerator;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.ValueSerializer;

import java.util.Map;

/**
 * Class for serialization of {@link ItemStack}.
 */
public class LegacyItemStackSerializer extends ValueSerializer<ItemStack> {
    private static final Yaml YAML = new Yaml(new Constructor(new LoaderOptions()));

    @Override
    public void serialize(ItemStack value, JsonGenerator gen, SerializationContext serializers) throws JacksonException {
        YamlConfiguration yamlConfiguration = new YamlConfiguration();
        yamlConfiguration.set("map", value);
        Map<String, Object> items = YAML.load(yamlConfiguration.saveToString());
        gen.writePOJO(items.get("map"));
    }
}
