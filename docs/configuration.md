---
title: Module options
sidebar_position: 5
---

# Module options

You set options on the module builder before you call `build()`. Without any option, the defaults below apply.

```java
JacksonPaper module = JacksonPaper.builder()
        .colorAsHex()
        .withNamespacedKeyFormat(NamespacedKeySerializer.Format.SHORT)
        .build();
```

## Options of both modules

| Method | Default | What it does |
|---|---|---|
| `colorAsHex()` | off | Writes and reads colors as hex text instead of an object. |
| `colorAsHex(boolean)` | `false` | Same as above, but you pass `true` or `false`. |
| `withNamespacedKeyFormat(Format)` | `OBJECT` | Sets how namespaced keys are written. |

### Colors as hex

By default, a color is an object with one number per channel. With `colorAsHex()`, it is one hex text, like
`"FF3C00"` on Bukkit or `"FF3C00FF"` on Paper. See [Colors](./types/colors.md) for both forms.

:::warning
The setting decides how colors are read, too. With hex on, colors written as objects cannot be read, and the other
way around. Do not change this setting for existing files.
:::

### Namespaced key format

`Format` is `de.eldoria.jacksonbukkit.serializer.NamespacedKeySerializer.Format`. It has three values:

| Value | `minecraft:stone` is written as | `myplugin:arena` is written as |
|---|---|---|
| `OBJECT` | an object with `namespace` and `key` | an object with `namespace` and `key` |
| `FULL` | `"minecraft:stone"` | `"myplugin:arena"` |
| `SHORT` | `"stone"` | `"myplugin:arena"` |

The format only changes how keys are written. All three forms are always read. See
[Keys and players](./types/keys-and-players.md) for examples.

:::warning
Enchantments and potion effect types are written as namespaced keys too, so they follow this format. With `FULL`
or `SHORT`, a potion effect type written as text cannot be read back, and reading fails. An enchantment written as
text is looked up by its old Bukkit name, which comes back as `null` on older server versions. Keep `OBJECT` if
your files contain potion effects or enchantments.
:::

## Options of the Paper module

| Method | Default | What it does |
|---|---|---|
| `useLegacyItemStackSerialization()` | off | Writes item stacks as Bukkit's map instead of bytes. |
| `withMiniMessages()` | on when MiniMessage is present | Writes components as MiniMessage text. |
| `withMiniMessages(MiniMessage)` | | Same, with your own `MiniMessage` instance. |

### Legacy item stacks

`useLegacyItemStackSerialization()` makes the Paper module write item stacks the way the Bukkit module does. This
is not recommended. It does not work in [Paper plugins](./modules.md#paper-plugins). See
[Items and recipes](./types/items.md) for both formats.

### Components

Without any call, the Paper module picks the component format by itself:

- MiniMessage is present (Paper 1.18.2 and newer): components are MiniMessage text.
- Only Adventure is present (Paper 1.16 to 1.18.1): components are JSON objects.
- No Adventure: components are not supported.

`withMiniMessages(MiniMessage)` lets you pass your own instance, for example one with extra tags. That instance is
used for writing and reading. See [Text components](./types/text.md) for both formats.

## Creating the module without the builder

`JacksonBukkit` and `JacksonPaper` also have constructors. They are marked as internal, and their defaults differ
from the builder: `new JacksonBukkit()` and `new JacksonPaper()` write namespaced keys in the `FULL` format, and
`new JacksonPaper()` does not support components at all. Use the builder.
