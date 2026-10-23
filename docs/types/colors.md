---
title: Colors
sidebar_position: 3
---

# Colors

`org.bukkit.Color` has two forms: an object, which is the default, and hex text, which you turn on with
[`colorAsHex()`](../configuration.md#colors-as-hex). The module decides between them. You cannot mix both forms in
one mapper.

Colors inside other types, like the colors of a firework effect, use the same form.

## As an object

The Bukkit module writes red, green and blue, each from 0 to 255:

```yaml
red: 255
green: 60
blue: 0
```

The Paper module adds the alpha value on Paper 1.19 and newer:

```yaml
red: 255
green: 60
blue: 0
alpha: 255
```

The Paper module also reads colors without `alpha`. They get full alpha (255).

## As hex text

With `colorAsHex()`, the Bukkit module writes six hex digits for red, green and blue:

```yaml
color: "FF3C00"
```

The Paper module writes eight digits on Paper 1.19 and newer. The last two are alpha:

```yaml
color: "FF3C00FF"
```

The Paper module reads both six and eight digits. Six digits get full alpha. The Bukkit module only uses the first
six digits.

:::note
Write the digits without a leading `#`. A value like `"#FF3C00"` cannot be read. Upper and lower case both work.
:::

In a list, each color is one entry:

```yaml
- "FF3C00FF"
- "14C846D7"
```
