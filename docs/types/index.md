---
title: Supported types
sidebar_position: 1
---

# Supported types

These are all the types the modules handle. Any field, list entry or map value of one of these types is written
and read for you. The examples on these pages are YAML, as a `YAMLMapper` writes it.

| Type | Written as | Page |
|---|---|---|
| `Vector` | object with `xCoord`, `yCoord`, `zCoord` | [Positions and areas](./geometry.md) |
| `BlockVector` | object with `xCoord`, `yCoord`, `zCoord` | [Positions and areas](./geometry.md) |
| `BoundingBox` | object with two corners | [Positions and areas](./geometry.md) |
| `Location` | object with world and coordinates | [Positions and areas](./geometry.md) |
| `Color` | object with channels, or hex text | [Colors](./colors.md) |
| `ItemStack` | Base64 text (Paper) or Bukkit's item map | [Items and recipes](./items.md) |
| `ShapedRecipe` | object with key, result, shape and ingredients | [Items and recipes](./items.md) |
| `ShapelessRecipe` | object with key, result and ingredients | [Items and recipes](./items.md) |
| `RecipeChoice.MaterialChoice` | object with a list of materials | [Items and recipes](./items.md) |
| `RecipeChoice.ExactChoice` | object with a list of item stacks | [Items and recipes](./items.md) |
| `BlockData` | block state text | [Block data](./blocks.md) |
| `PotionEffect` | object | [Effects and enchantments](./effects.md) |
| `PotionEffectType` | namespaced key | [Effects and enchantments](./effects.md) |
| `Enchantment` | namespaced key | [Effects and enchantments](./effects.md) |
| `FireworkEffect` | object | [Effects and enchantments](./effects.md) |
| `Pattern` | object with color and pattern | [Effects and enchantments](./effects.md) |
| `AttributeModifier` | object | [Effects and enchantments](./effects.md) |
| `NamespacedKey` | object or text | [Keys and players](./keys-and-players.md) |
| `OfflinePlayer` | UUID text | [Keys and players](./keys-and-players.md) |
| `Component` (Paper only) | MiniMessage text or JSON object | [Text components](./text.md) |

Other `ConfigurationSerializable` classes are not covered. Jackson treats them like any other Java class.

## Declare the exact type

The module registers readers for the types in the table. Declare your fields with exactly these types. For
example, a field of type `BlockData` works, but a field of a sub type like `Stairs` has no reader. Read it as
`BlockData` and cast it.

## Enum values

Many objects contain enum values, like materials, dye colors or equipment slots. They are written with their Java
name in capitals, for example `"STONE"` or `"RED"`.
