/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.configuration.file.YamlConstructor;
import org.bukkit.configuration.file.YamlRepresenter;
import org.bukkit.inventory.ItemStack;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.IOException;
import java.util.Map;

/**
 * Class for serialization of {@link ItemStack}.
 */
public class LegacyItemStackSerializer extends JsonSerializer<ItemStack> {
    private static final Yaml YAML = new Yaml(new Constructor(Container.class));

    @Override
    public void serialize(ItemStack value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        YamlConfiguration yamlConfiguration = new YamlConfiguration();
        yamlConfiguration.set("map", value);
        String s = yamlConfiguration.saveToString();

        Container items = YAML.load(s);

        gen.writeObject(items.map);
    }

    private class Container {
        public Map<String, Object> map;
    }
}
