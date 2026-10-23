---
title: Positions and areas
sidebar_position: 2
---

# Positions and areas

## Vector and BlockVector

A `Vector` is written as an object with three coordinates:

```yaml
xCoord: 1.549687
yCoord: 58.52578
zCoord: 8421257.577845
```

A `BlockVector` uses the same three fields. A field of type `BlockVector` is read back as a `BlockVector`.

## BoundingBox

A `BoundingBox` is written as its two corners. `corner1` is the smallest corner and `corner2` the largest. Each
corner is a vector:

```yaml
corner1:
  xCoord: 10.0
  yCoord: 20.0
  zCoord: 10.0
corner2:
  xCoord: 60.0
  yCoord: 40.0
  zCoord: 300.0
```

When you write a file by hand, the order of the corners does not matter. The box is built from both points.

## Location

A `Location` is written with its world and its position:

```yaml
uid: "00000000-0000-0000-0000-000000000000"
name: "world"
xCoord: 0.0
yCoord: 0.0
zCoord: 0.0
yaw: 0.0
pitch: 0.0
```

| Field | Meaning |
|---|---|
| `uid` | UUID of the world |
| `name` | name of the world |
| `xCoord`, `yCoord`, `zCoord` | position |
| `yaw`, `pitch` | rotation |

The world is stored twice, as UUID and as name. When the location is read:

1. the world is looked up by its UUID,
2. if no world has that UUID, it is looked up by its name.

So a location still finds its world when the world was created anew under the same name. You may also leave out
one of the two fields. A location with only `name: "world"` is fine for files you write by hand.

A location without a world is written with `uid: null` and `name: null`, and is read back without a world.

:::note
The world must be loaded when the location is read. If neither the UUID nor the name matches a loaded world, the
location is read with a `null` world.
:::
