---
title: Block data
sidebar_position: 5
---

# Block data

`BlockData` is written as one line of text: the block's key followed by its states in square brackets. This is
the text `BlockData#getAsString()` returns, the same form the `/setblock` command uses.

```yaml
marker: "minecraft:red_wool"
stairs: "minecraft:oak_stairs[facing=east,half=bottom,shape=straight,waterlogged=false]"
```

A block without states has no brackets.

## Writing block data by hand

When reading, the text is passed to `Bukkit.createBlockData(String)`, so the server parses it. That makes the
format easy to write by hand. You do not have to list every state:

```yaml
marker: "red_wool"
stairs: "minecraft:oak_stairs[facing=north]"
```

The server fills in the states you leave out, and a key without a namespace means `minecraft`. The next time the
file is written, the full text with all states is saved.

:::warning
Text the server cannot parse, like an unknown block or a state the block does not have, fails with an error while
the file is read.
:::

## Use the type `BlockData`

Declare the field as `BlockData`. A field of a more exact type like `Stairs` or `Directional` has no reader. Read
`BlockData` and check its type in code:

```java
public record Decoration(BlockData block) {
}
```

```java
if (decoration.block() instanceof Stairs stairs) {
    stairs.setFacing(BlockFace.SOUTH);
}
```
