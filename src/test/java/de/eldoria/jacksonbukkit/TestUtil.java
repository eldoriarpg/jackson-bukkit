package de.eldoria.jacksonbukkit;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.toml.TomlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.IOException;

public interface TestUtil {
    ObjectMapper JSON = JsonMapper.builder()
            .defaultPrettyPrinter(new DefaultPrettyPrinter())
            .addModule(new JacksonSpigot())
            .build();
    ObjectMapper YAML = YAMLMapper.builder()
            .addModule(new JacksonSpigot())
            .build();
    ObjectMapper TOML = TomlMapper.builder()
            .defaultPrettyPrinter(new DefaultPrettyPrinter())
            .addModule(new JacksonSpigot())
            .build();

    default ObjectWriter json() {
        return JSON.writerWithDefaultPrettyPrinter();
    }

    default ObjectMapper yaml() {
        return YAML;
    }

    default ObjectWriter toml() {
        return TOML.writerWithDefaultPrettyPrinter();
    }

    default String toJson(Object object) throws JsonProcessingException {
        return ensureLinebreak(json().writeValueAsString(object));
    }

    default String toYaml(Object object) throws JsonProcessingException {
        return yaml().writeValueAsString(object);
    }

    default String toToml(Object object) throws JsonProcessingException {
        return ensureLinebreak(toml().writeValueAsString(object));
    }

    private String ensureLinebreak(String string) {
        if(string.endsWith("\n")){
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

    private String read(String path) {
        try (var in = getClass().getResourceAsStream(path)) {
            if (in == null) throw new RuntimeException("File %s not in resources".formatted(path));
            return new String(in.readAllBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
