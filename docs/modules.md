---
title: Bukkit or Paper
sidebar_position: 3
---

# Bukkit or Paper

Jackson Bukkit comes as two modules. Both support the same [types](./types/index.md). They differ in how they
write colors and item stacks, and only Paper can handle Adventure components.

| | `JacksonPaper` (artifact `paper`) | `JacksonBukkit` (artifact `bukkit`) |
|---|---|---|
| Runs on | Paper | Spigot and Paper |
| `Color` | red, green, blue and alpha (alpha from 1.19 on) | red, green, blue |
| `ItemStack` | Base64 text of the item's bytes (from 1.16 on) | Bukkit's own item map |
| `Component` | MiniMessage text, or a JSON object without MiniMessage | not supported |
| Paper plugins | works | cannot handle `ItemStack` |

## Use Paper when you can

If your plugin runs on Paper, use `JacksonPaper`. It writes item stacks in Paper's byte format, keeps the alpha
value of colors and supports components.

The Paper module needs Paper. It uses Paper and Adventure classes, so it does not work on plain Spigot.

## Moving between them

Switching a plugin from the Bukkit module to the Paper module is safe. The Paper module reads everything the Bukkit
module writes:

- item stacks written as a map are read and saved as bytes the next time you write the file,
- colors without an alpha value get full alpha (255).

Going back from Paper to Bukkit is not supported. The Bukkit module cannot read item stacks written as bytes, and
colors with an alpha value may fail to load.

## Version changes the modules handle

Both modules detect old formats while reading and write the current one:

- **Potion effect types.** Before 1.18 they were written as a number, now as a [namespaced key](./types/keys-and-players.md).
- **Item stacks (Paper).** From 1.16, Paper item stacks are written as bytes. Older maps are still read.
- **Components (Paper).** From 1.16, Paper has Adventure. From 1.18.2 it has MiniMessage, and components are written
  as MiniMessage text. Components written as JSON objects are still read.
- **Colors (Paper).** From 1.19, colors have an alpha value. It is added on its own.

Reading data written on a newer server version with an older one is not supported.

## Paper plugins

If your plugin is a [Paper plugin](https://docs.papermc.io/paper/reference/paper-plugins) (it has a
`paper-plugin.yml`), Bukkit's map format for item stacks does not work. Use `JacksonPaper` and keep the default item
stack format. Do not call `useLegacyItemStackSerialization()` on the builder.
