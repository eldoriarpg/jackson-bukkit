---
title: Text components
sidebar_position: 8
---

# Text components

Only the Paper module supports Adventure `Component`s. The Bukkit module has no support for them.

The format depends on what the server offers. See [Module options](../configuration.md#components) for how the
module picks it.

## MiniMessage text

On Paper 1.18.2 and newer, MiniMessage is part of the server. Components are then written as MiniMessage text:

```yaml
welcome: "Awesome <bold><aqua>text"
```

This is easy to read and to edit by hand. It is also the default.

To use your own MiniMessage instance, for example one with your own tags, pass it to the builder:

```java
MiniMessage miniMessage = MiniMessage.builder()
        .tags(TagResolver.standard())
        .build();

JacksonPaper module = JacksonPaper.builder()
        .withMiniMessages(miniMessage)
        .build();
```

## JSON object

Without MiniMessage, but with Adventure (Paper 1.16 up to 1.18.1), components are written as Adventure's JSON
structure:

```yaml
extra:
- text: " "
- bold: true
  color: "aqua"
  text: "text"
text: "Awesome"
```

## Moving to MiniMessage

With MiniMessage, the module still reads components written as JSON objects. After a server update to 1.18.2 or
newer, old files load, and each component is saved as MiniMessage text the next time you write the file.
