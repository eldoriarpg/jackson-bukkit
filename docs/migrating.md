---
title: Migrating from 1.x
sidebar_position: 8
---

# Migrating from 1.x

Version 2 moves Jackson Bukkit from Jackson 2 to Jackson 3. The builders, their options and the file formats stay
the same. What changes is Jackson itself.

## Your files keep working

The format of every type is unchanged. Files written with version 1 are read by version 2, and version 2 writes
them the same way. You do not need to convert any data.

## Update the dependencies

Change the Jackson Bukkit version to `2.0.0`. The artifacts and their group stay the same.

Jackson 3 has new group ids. Replace every Jackson 2 dependency in your build:

| Jackson 2 | Jackson 3 |
|---|---|
| `com.fasterxml.jackson:jackson-bom` | `tools.jackson:jackson-bom` |
| `com.fasterxml.jackson.core:jackson-core` | `tools.jackson.core:jackson-core` |
| `com.fasterxml.jackson.core:jackson-databind` | `tools.jackson.core:jackson-databind` |
| `com.fasterxml.jackson.dataformat:jackson-dataformat-yaml` | `tools.jackson.dataformat:jackson-dataformat-yaml` |
| `com.fasterxml.jackson.dataformat:jackson-dataformat-toml` | `tools.jackson.dataformat:jackson-dataformat-toml` |

Jackson Bukkit 2.0.0 is built against Jackson 3.0.3. Like version 1.4, it needs Java 21.

```kotlin
dependencies {
    implementation("de.eldoria.jacksonbukkit:paper:2.0.0")
    implementation(platform("tools.jackson:jackson-bom:3.0.3"))
    implementation("tools.jackson.dataformat:jackson-dataformat-yaml")
}
```

## Update the imports

Jackson 3 moved its packages from `com.fasterxml.jackson` to `tools.jackson`:

| Jackson 2 | Jackson 3 |
|---|---|
| `com.fasterxml.jackson.databind.ObjectMapper` | `tools.jackson.databind.ObjectMapper` |
| `com.fasterxml.jackson.databind.json.JsonMapper` | `tools.jackson.databind.json.JsonMapper` |
| `com.fasterxml.jackson.dataformat.yaml.YAMLMapper` | `tools.jackson.dataformat.yaml.YAMLMapper` |
| `com.fasterxml.jackson.core.type.TypeReference` | `tools.jackson.core.type.TypeReference` |
| `com.fasterxml.jackson.databind.Module` | `tools.jackson.databind.JacksonModule` |

The annotations did not move. `@JsonProperty`, `@JsonCreator` and the others are still in
`com.fasterxml.jackson.annotation`.

The Jackson Bukkit classes keep their names and packages: `de.eldoria.jacksonbukkit.JacksonBukkit`,
`de.eldoria.jacksonbukkit.JacksonPaper` and their builders.

## Register the module on the builder

In Jackson 3, a mapper cannot be changed after it was built. `registerModule` is gone. Add the module while you
build the mapper.

Before, with version 1:

```java
ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
mapper.registerModule(JacksonPaper.builder().build());
```

Now, with version 2:

```java
ObjectMapper mapper = YAMLMapper.builder()
        .addModule(JacksonPaper.builder().build())
        .build();
```

If you have an existing mapper, `mapper.rebuild()` returns a builder you can add the module to. See
[Registering the module](./usage.md).

## Exceptions

In Jackson 3, `readValue` and `writeValue` throw `JacksonException`. It is an unchecked exception. You no longer
have to catch `IOException` or `JsonProcessingException` around them. Catch `JacksonException` where you want to
handle broken files.

## Own serializers

If you wrote your own serializers or deserializers next to Jackson Bukkit, the Jackson 3 names apply:

| Jackson 2 | Jackson 3 |
|---|---|
| `JsonSerializer` | `ValueSerializer` |
| `JsonDeserializer` | `ValueDeserializer` |
| `SerializerProvider` | `SerializationContext` |
| `gen.writeObject(value)` | `gen.writePOJO(value)` |
| `throws IOException` | `throws JacksonException` |
