# Jackson Bukkit

Jackson 3 modules that read and write Bukkit and Paper types such as `Location`, `ItemStack`, `Color`, `BlockData`
and Adventure `Component`, in YAML, JSON, TOML or any other format Jackson supports.

[![Maven Central](https://img.shields.io/maven-central/v/de.eldoria.jacksonbukkit/jackson-bukkit?style=for-the-badge&label=Release)](https://central.sonatype.com/artifact/de.eldoria.jacksonbukkit/jackson-bukkit)
[![Snapshot](https://img.shields.io/nexus/s/de.eldoria.jacksonbukkit/jackson-bukkit?server=https%3A%2F%2Feldonexus.de&style=for-the-badge&label=Snapshot&color=orange)](https://eldonexus.de/#browse/browse:maven-snapshots:de%2Feldoria%2Fjacksonbukkit)

## Requirements

- Java 21 or newer.
- Jackson 3.
- A server that runs on Java 21: officially Minecraft 1.20.5 or newer. Older versions may work but are not tested.

## Dependency

Pick `paper` for Paper plugins or `bukkit` for plugins that must also run on Spigot.

```kotlin
dependencies {
    implementation("de.eldoria.jacksonbukkit:paper:2.0.0")
}
```

```xml
<dependency>
    <groupId>de.eldoria.jacksonbukkit</groupId>
    <artifactId>paper</artifactId>
    <version>2.0.0</version>
</dependency>
```

Snapshots are on EldoNexus: `https://eldonexus.de/repository/maven-snapshots/`.

## Documentation

https://docs.eldoria.de/jackson-bukkit
