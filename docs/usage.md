---
title: Registering the module
sidebar_position: 4
---

# Registering the module

In Jackson 3, a mapper cannot be changed once it is built. You add the module while you build the mapper.

## Create the module

Each module has a builder. Call `builder()` on the module class, set the options you want and call `build()`:

```java
JacksonPaper paperModule = JacksonPaper.builder().build();
JacksonBukkit bukkitModule = JacksonBukkit.builder().build();
```

Both classes live in the package `de.eldoria.jacksonbukkit`. The options are explained in
[Module options](./configuration.md).

## Add it to a mapper

For YAML, use `YAMLMapper` from `jackson-dataformat-yaml`:

```java
import de.eldoria.jacksonbukkit.JacksonPaper;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.dataformat.yaml.YAMLMapper;

ObjectMapper yaml = YAMLMapper.builder()
        .addModule(JacksonPaper.builder().build())
        .build();
```

For JSON, use `JsonMapper` from `jackson-databind`:

```java
import tools.jackson.databind.json.JsonMapper;

ObjectMapper json = JsonMapper.builder()
        .addModule(JacksonPaper.builder().build())
        .build();
```

Any other Jackson 3 format works the same way, for example `TomlMapper` from `jackson-dataformat-toml`.

If you already have a mapper, `rebuild()` gives you a builder with all its settings. Add the module there and build
a new mapper:

```java
ObjectMapper withBukkit = existing.rebuild()
        .addModule(JacksonPaper.builder().build())
        .build();
```

Build the mapper once, for example in `onEnable`, and keep it. A mapper is safe to use from several threads.

## Read and write

Now Bukkit types work anywhere in your classes, as fields, in lists and in maps:

```java
public record Warp(String name, Location location, ItemStack icon) {
}
```

```java
Path file = getDataFolder().toPath().resolve("warps.yml");

List<Warp> warps = yaml.readValue(file, new TypeReference<List<Warp>>() {});

yaml.writeValue(file, warps);
```

`TypeReference` is `tools.jackson.core.type.TypeReference`. In Jackson 3, `readValue` and `writeValue` throw
`JacksonException`, which is an unchecked exception.

## When to read

Some types look things up on the server while they are read:

- a `Location` looks up its world,
- an `OfflinePlayer` looks up the player,
- `BlockData`, enchantments and potion effect types are looked up in the server's registries.

Read files that contain these types after the server has started, for example in `onEnable`. Worlds must be loaded
before you read a `Location`, or its world is `null`. See [Supported types](./types/index.md) for the details of
each type.
