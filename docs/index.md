---
title: Jackson Bukkit
sidebar_position: 1
---

# Jackson Bukkit

Jackson Bukkit is a library for plugin developers. It adds Jackson support for Bukkit and Paper types. With it, Jackson can read and write things like `Location`, `ItemStack`,
`Color`, `BlockData` or Adventure `Component` in YAML, JSON, TOML or any other format Jackson supports.

It is a library, not a plugin. You add it to your plugin's build and ship it inside your plugin jar.

Version 2 is built on Jackson 3. If you still use version 1 with Jackson 2, read
[Migrating from 1.x](./migrating.md).

## Why you want it

Jackson maps files straight to your own Java classes. That is handy for configs and saved data. But Jackson does
not know Bukkit types. A field of type `Location` or `ItemStack` makes it fail or write something you cannot read
back.

Jackson Bukkit fills that gap. You register one module on your mapper, and these types just work:

- clean, readable formats for vectors, locations, colors, keys, potion effects and more,
- item stacks in the best format the server offers,
- old data stays readable after a server update. The readers detect older formats and convert them.

It does not use server internals (NMS). Newer API features are detected at runtime.

## A first look

```java
ObjectMapper mapper = YAMLMapper.builder()
        .addModule(JacksonPaper.builder().build())
        .build();

ArenaConfig config = mapper.readValue(path, ArenaConfig.class);
```

```yaml
spawn:
  uid: "00000000-0000-0000-0000-000000000000"
  name: "world"
  xCoord: 0.0
  yCoord: 64.0
  zCoord: 0.0
  yaw: 0.0
  pitch: 0.0
marker: "minecraft:red_wool"
welcome: "<gold>Welcome to the arena!"
```

## Where to go next

- [Setup](./setup.md): requirements and how to add the library to your build.
- [Bukkit or Paper](./modules.md): which module to pick and how they differ.
- [Registering the module](./usage.md): add the module to a Jackson 3 mapper and read and write files.
- [Module options](./configuration.md): every builder option.
- [Supported types](./types/index.md): every type and how it looks in a file.
- [Full example](./example.md): a small plugin that loads its config with Jackson Bukkit.
- [Migrating from 1.x](./migrating.md): moving from Jackson 2 to Jackson 3.

The [Javadocs](https://eldoriarpg.github.io/jackson-bukkit/) list every class. The source code is on
[GitHub](https://github.com/eldoriarpg/jackson-bukkit).
