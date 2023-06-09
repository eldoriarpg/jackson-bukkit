/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.dataformat.toml.TomlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.assertj.core.api.Assertions;
import org.bukkit.World;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public interface CoreSerializationTest extends SerializationTest {

    default Module buildModule() {
        return new JacksonBukkit();
    }

    @Override
    default List<Module> additionalModules() {
        return List.of(new DummyItemStackSerialization());
    }
}
