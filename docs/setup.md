---
title: Setup
sidebar_position: 2
---

# Setup

## Requirements

| What | Version |
|---|---|
| Java | 21 or newer. The library is compiled for Java 21. |
| Jackson | 3. Version 2.0.0 is built against Jackson 3.0.3 (`tools.jackson`). |
| Server for `bukkit` | Spigot or any server based on it. Built against the Spigot API 1.13.2. |
| Server for `paper` | Paper. Built against the Paper API 1.20. |

The library only uses the public server API. Features of newer versions, like alpha in colors or item stacks as
bytes, are detected at runtime. See [Bukkit or Paper](./modules.md) for what each module does on which version.

## Pick a module

There is one artifact per server type. Pick exactly one of them for your plugin:

| Artifact | Use it when | Module class |
|---|---|---|
| `paper` | your plugin runs on Paper | `JacksonPaper` |
| `bukkit` | your plugin must also run on Spigot | `JacksonBukkit` |

Both bring the shared `core` artifact with them, so you never add `core` on your own. If your plugin runs on
Paper, use `paper`. [Bukkit or Paper](./modules.md) explains the differences.

There is also an artifact called `jackson-bukkit`. It only pulls in both `paper` and `bukkit`. You do not need it.

## Add the dependency

All artifacts are published to Maven Central.

| | |
|---|---|
| Repository | Maven Central |
| Group | `de.eldoria.jacksonbukkit` |
| Artifact | `paper` or `bukkit` |
| Version | `2.0.0` |

Jackson Bukkit brings `jackson-core` and `jackson-databind` with it. It does not bring a data format. Add the one
you want to write, for example `jackson-dataformat-yaml` for YAML files. The Jackson BOM keeps all Jackson parts
on the same version.

### Gradle (Kotlin DSL)

```kotlin
repositories {
    mavenCentral()
}

dependencies {
    implementation("de.eldoria.jacksonbukkit:paper:2.0.0")

    implementation(platform("tools.jackson:jackson-bom:3.0.3"))
    implementation("tools.jackson.dataformat:jackson-dataformat-yaml")
}
```

For a Spigot plugin, use `de.eldoria.jacksonbukkit:bukkit:2.0.0` instead.

### Maven

```xml
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>tools.jackson</groupId>
            <artifactId>jackson-bom</artifactId>
            <version>3.0.3</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>

<dependencies>
    <dependency>
        <groupId>de.eldoria.jacksonbukkit</groupId>
        <artifactId>paper</artifactId>
        <version>2.0.0</version>
    </dependency>
    <dependency>
        <groupId>tools.jackson.dataformat</groupId>
        <artifactId>jackson-dataformat-yaml</artifactId>
    </dependency>
</dependencies>
```

For a Spigot plugin, use the artifact `bukkit` instead of `paper`.

### EldoNexus mirror

Maven Central is all you need. The artifacts can also be fetched through the EldoNexus proxy at
`https://eldonexus.de/repository/maven-proxies/`, which mirrors Maven Central.

## Ship it with your plugin

The server does not come with Jackson 3 or Jackson Bukkit. Your plugin jar has to contain them. Add them with
`implementation` (Gradle) or the default `compile` scope (Maven) and shade them into your jar, for example with
the Shadow plugin for Gradle or the `maven-shade-plugin` for Maven.

Do not shade the server API or Adventure. Paper already provides them, and the `paper` module uses the server's
copy.

Jackson 3 still uses the annotations from `com.fasterxml.jackson.annotation` (the `jackson-annotations`
artifact). It comes in with `jackson-databind`. If you relocate, move `de.eldoria.jacksonbukkit`, `tools.jackson`
and `com.fasterxml.jackson.annotation` together.
