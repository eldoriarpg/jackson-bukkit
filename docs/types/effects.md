---
title: Effects and enchantments
sidebar_position: 6
---

# Effects and enchantments

## PotionEffect

```yaml
amplifier: 1
duration: 10
type:
  namespace: "minecraft"
  key: "nausea"
ambient: false
particles: true
icon: false
```

| Field | Meaning |
|---|---|
| `amplifier` | effect level, starting at 0 |
| `duration` | duration in ticks |
| `type` | the potion effect type, see below |
| `ambient` | whether the effect is ambient, like from a beacon |
| `particles` | whether particles are shown |
| `icon` | whether the icon is shown |

## PotionEffectType

A potion effect type is written as its [namespaced key](./keys-and-players.md):

```yaml
type:
  namespace: "minecraft"
  key: "blindness"
```

Before Minecraft 1.18, it was written as the effect's number. Those numbers are still read on older servers, where
the server knows them.

## Enchantment

An enchantment is written as its [namespaced key](./keys-and-players.md) as well:

```yaml
namespace: "minecraft"
key: "flame"
```

On servers without namespaced keys for enchantments, the enchantment's old Bukkit name is written as text instead.

:::warning
Potion effect types and enchantments follow the
[namespaced key format](../configuration.md#namespaced-key-format) of the module, but they can only be read back
safely from the default `OBJECT` form. Do not change the format if your files contain them.
:::

## FireworkEffect

```yaml
type: "BURST"
colors:
- red: 255
  green: 0
  blue: 0
fadeColors:
- red: 0
  green: 255
  blue: 255
flicker: false
trail: false
```

| Field | Meaning |
|---|---|
| `type` | the shape, a `FireworkEffect.Type` like `BALL`, `BALL_LARGE`, `STAR`, `BURST` or `CREEPER` |
| `colors` | list of [colors](./colors.md) |
| `fadeColors` | list of colors it fades to |
| `flicker` | whether it flickers |
| `trail` | whether it leaves a trail |

The colors follow the color form of the module. On Paper they have an `alpha` value, and with `colorAsHex()` they
are hex text.

## Pattern

A banner pattern is written as its dye color and its pattern type:

```yaml
color: "RED"
pattern: "BASE"
```

## AttributeModifier

```yaml
uuid: "78d16016-b2c3-48c0-8334-4dff96a1b42d"
name: "test"
amount: 1337.0
operation: "ADD_NUMBER"
equipmentSlot: "HAND"
```

| Field | Meaning |
|---|---|
| `uuid` | the modifier's UUID |
| `name` | the modifier's name |
| `amount` | the amount |
| `operation` | `ADD_NUMBER`, `ADD_SCALAR` or `MULTIPLY_SCALAR_1` |
| `equipmentSlot` | the slot it is active in, or `null` for any slot |

:::warning
Since Minecraft 1.21, attribute modifiers are identified by a namespaced key and apply to slot groups. This format
still uses the older UUID, name and single slot. When a modifier is read on these versions, its key is built from
the UUID, and the name is not kept. A modifier for a slot group is written with one slot of that group, for example `CHEST` for all armor slots, and
is read back for that slot only.
:::
