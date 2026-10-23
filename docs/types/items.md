---
title: Items and recipes
sidebar_position: 4
---

# Items and recipes

## ItemStack

How an item stack is written depends on the module.

### Paper: Base64 text

The Paper module writes an item stack as one line of Base64 text. It holds the bytes Paper creates with
`ItemStack#serializeAsBytes()` and reads back with `ItemStack.deserializeBytes()`.

```yaml
reward: "<Base64 text>"
```

The text is not meant to be edited by hand. Create the item in game or in code and save it.

This format needs Paper 1.16 or newer. On older Paper versions, the module falls back to the map below.

When reading, the Paper module accepts both forms. Text is read as bytes, an object is read as Bukkit's map. So
files written by the Bukkit module keep working, and each item is saved as bytes the next time you write the file.

### Bukkit: the item map

The Bukkit module writes an item stack as the same map Bukkit uses for items in a `config.yml`. That includes the
`==` entry Bukkit uses to mark the type. The keys inside the map are Bukkit's own and depend on the server
version.

The Paper module writes this map too when you call
[`useLegacyItemStackSerialization()`](../configuration.md#legacy-item-stacks).

:::warning
This map does not work in [Paper plugins](../modules.md#paper-plugins). Use the Paper module with its default
format there.
:::

## Recipes

In the examples below, `<item>` stands for an item stack in one of the forms above.

### ShapedRecipe

```yaml
key:
  namespace: "minecraft"
  key: "test"
result: "<item>"
shape:
- "aaa"
- " b "
- " b "
group: ""
ingredients:
  ' ': null
  a: !<MaterialChoice>
    choices:
    - "STONE"
    - "COBBLED_DEEPSLATE"
  b: !<MaterialChoice>
    choices:
    - "STICK"
```

| Field | Meaning |
|---|---|
| `key` | the recipe's [namespaced key](./keys-and-players.md) |
| `result` | the item the recipe makes |
| `shape` | up to three rows of up to three characters |
| `group` | the recipe group, empty for none |
| `ingredients` | one recipe choice per character in the shape |

A character without an ingredient, like the space above, is `null`.

### ShapelessRecipe

```yaml
key:
  namespace: "minecraft"
  key: "test1"
result: "<item>"
group: ""
choiceList:
- !<ExactChoice>
  choices:
  - "<item>"
- !<MaterialChoice>
  choices:
  - "STICK"
```

`choiceList` holds one recipe choice per ingredient.

### Recipe choices

Inside a recipe, every choice carries its type, so the reader knows which one it is. In YAML this is a tag in front
of the object:

| Tag | Type | `choices` holds |
|---|---|---|
| `!<MaterialChoice>` | `RecipeChoice.MaterialChoice` | material names |
| `!<ExactChoice>` | `RecipeChoice.ExactChoice` | item stacks |

Formats without tags, like JSON, use an extra field instead:

```json
{
  "@clazz" : "MaterialChoice",
  "choices" : [ "STICK" ]
}
```

A field of type `MaterialChoice` or `ExactChoice` on its own is written without the tag, as an object with
`choices` only.
