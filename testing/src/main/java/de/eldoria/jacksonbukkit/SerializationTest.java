/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit;

import org.assertj.core.api.Assertions;
import org.bukkit.World;
import tools.jackson.core.JacksonException;
import tools.jackson.core.util.DefaultPrettyPrinter;
import tools.jackson.databind.JacksonModule;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.json.JsonMapper;
import tools.jackson.databind.type.CollectionType;
import tools.jackson.dataformat.toml.TomlMapper;
import tools.jackson.dataformat.yaml.YAMLMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public interface SerializationTest {
    default ObjectMapper json() {
        return buildJson();
    }

    default ObjectMapper yaml() {
        return buildYaml();
    }

    default ObjectMapper toml() {
        return buildToml();
    }

    JacksonModule buildModule();

    default List<JacksonModule> additionalModules() {
        return Collections.emptyList();
    }

    default ObjectMapper buildJson() {
        JsonMapper.Builder builder = JsonMapper.builder()
                .defaultPrettyPrinter(new DefaultPrettyPrinter())
                .addModule(buildModule());
        for (JacksonModule module : additionalModules()) builder.addModule(module);
        return builder.build();
    }

    default ObjectMapper buildYaml() {
        YAMLMapper.Builder builder = YAMLMapper.builder()
                .addModule(buildModule());
        for (JacksonModule module : additionalModules()) builder.addModule(module);
        return builder.build();
    }

    default ObjectMapper buildToml() {
        TomlMapper.Builder builder = TomlMapper.builder()
                .addModule(buildModule());
        for (JacksonModule module : additionalModules()) builder.addModule(module);
        return builder.build();
    }

    default String toJson(Object object) throws JacksonException {
        return ensureLinebreak(json().writerWithDefaultPrettyPrinter().writeValueAsString(object));
    }

    default String toYaml(Object object) throws JacksonException {
        return yaml().writeValueAsString(object);
    }

    default String toToml(Object object) throws JacksonException {
        return ensureLinebreak(toml().writeValueAsString(object));
    }

    default <T> T fromJson(String path, Class<T> clazz) throws JacksonException {
        return json().readValue(json(path), clazz);
    }

    default <T> List<T> fromJsonList(String path, Class<T> clazz) throws JacksonException {
        CollectionType type = json().getTypeFactory().constructCollectionType(ArrayList.class, clazz);
        return json().readValue(json(path), type);
    }

    default <T> T fromYaml(String path, Class<T> clazz) throws JacksonException {
        return yaml().readValue(yaml(path), clazz);
    }

    default <T> List<T> fromYamlList(String path, Class<T> clazz) throws JacksonException {
        CollectionType type = yaml().getTypeFactory().constructCollectionType(ArrayList.class, clazz);
        return yaml().readValue(yaml(path), type);
    }

    default <T> T fromToml(String path, Class<T> clazz) throws JacksonException {
        return toml().readValue(toml(path), clazz);
    }

    default <T> List<T> fromTomlList(String path, Class<T> clazz) throws JacksonException {
        CollectionType type = yaml().getTypeFactory().constructCollectionType(ArrayList.class, clazz);
        return toml().readValue(toml(path), type);
    }

    private String ensureLinebreak(String string) {
        if (string.endsWith("\n")) {
            return string;
        }
        return string + "\n";
    }

    default String json(String name) {
        return read("/json/%s.json".formatted(name));
    }

    default String toml(String name) {
        return read("/toml/%s.toml".formatted(name));
    }

    default String yaml(String name) {
        return read("/yaml/%s.yaml".formatted(name));
    }

    default <T> void assertEqualsIgnoring(T expected, T actual) {
        Assertions.assertThat(actual)
                .usingRecursiveComparison()
                .withComparatorForType(
                        Comparator.comparing(World::getUID).thenComparing(World::getName), World.class)
                .isEqualTo(expected);
    }


    private String read(String path) {
        try (var in = getClass().getResourceAsStream(path)) {
            if (in == null) throw new RuntimeException("File %s not in resources".formatted(path));
            return new String(in.readAllBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
