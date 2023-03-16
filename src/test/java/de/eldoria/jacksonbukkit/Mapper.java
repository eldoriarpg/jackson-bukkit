package de.eldoria.jacksonbukkit;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.toml.TomlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

public class Mapper {
    public static ObjectMapper json() {
        return JsonMapper.builder()
                .build();
    }
    public static ObjectMapper yaml() {
        return YAMLMapper.builder()
                .build();
    }
    public static ObjectMapper toml() {
        return TomlMapper.builder()
                .build();
    }
}
