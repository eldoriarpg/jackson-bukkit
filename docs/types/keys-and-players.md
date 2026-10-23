---
title: Keys and players
sidebar_position: 7
---

# Keys and players

## NamespacedKey

How a namespaced key is written depends on the [namespaced key format](../configuration.md#namespaced-key-format)
of the module. With the builder, the default is `OBJECT`:

```yaml
namespace: "myplugin"
key: "arena"
```

With `FULL`, the key is one text with the namespace in front:

```yaml
arena: "myplugin:arena"
block: "minecraft:stone"
```

With `SHORT`, keys in the `minecraft` namespace leave the namespace out. Other keys are written in full:

```yaml
arena: "myplugin:arena"
block: "stone"
```

All three forms are read, whatever format you set. Text without a colon gets the `minecraft` namespace. So you can
switch the format later, and files written by hand may use any form.

The format also applies to keys inside other types, like the key of a recipe or the type of a potion effect.

## OfflinePlayer

A player is written as their UUID:

```yaml
owner: "00000000-0000-0000-0000-000000000001"
```

This works for `Player` too, since every `Player` is an `OfflinePlayer`.

:::warning
When reading, the UUID is looked up among the players who are online right now. If the player is offline, you get
`null`. To keep players who may be offline, store their `UUID` in your class instead and call
`Bukkit.getOfflinePlayer(uuid)` when you need the player.
:::
