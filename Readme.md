![GitHub Workflow Status](https://img.shields.io/github/actions/workflow/status/eldoriarpg/jackson-bukkit/verify.yml?branch=main&style=for-the-badge&label=Building)
![GitHub Workflow Status](https://img.shields.io/github/actions/workflow/status/eldoriarpg/jackson-bukkit/publish_to_nexus.yml?branch=main&style=for-the-badge&label=Publishing) \
![Sonatype Nexus (Releases)](https://img.shields.io/nexus/maven-releases/de.eldoria/jackson-bukkit?label=Release&logo=Release&server=https%3A%2F%2Feldonexus.de&style=for-the-badge)
![Sonatype Nexus (Development)](https://img.shields.io/nexus/maven-dev/de.eldoria/jackson-bukkit?label=DEV&logo=Release&server=https%3A%2F%2Feldonexus.de&style=for-the-badge)
![Sonatype Nexus (Snapshots)](https://img.shields.io/nexus/s/de.eldoria/jackson-bukkit?color=orange&label=Snapshot&server=https%3A%2F%2Feldonexus.de&style=for-the-badge)

### [Javadocs](https://rainbowdashlabs.github.io/jackson-bukkit/)

## Dependency

**Gradle**

``` kotlin
repositories {
    maven("https://eldonexus.de/repository/maven-public")
}

dependencies {
    compileOnly("de.eldoria", "jackson-bukkit", "version")
}
```

**Maven**

``` xml
<repository>
    <id>EldoNexus</id>
    <url>https://eldonexus.de/repository/maven-public/</url>
</repository>

<dependency>
    <groupId>de.eldoria</groupId>
    <artifactId>jackson-bukkit</artifactId>
    <version>version</version>
</dependency>
```

## Module Creation

You can either create the `JacksonBukkit` and `JacksonPaper` module directly or use the builder for easy modification. 
Usage of the builder is recommended.
Builder for spigot and paper can both be accessed via the `JacksonBukkit` class.

```java
    ObjectMapper JSON=JsonMapper.builder()
        .addModule(JacksonBukkit.spigot().build())
        .build();
```

## Supported Classes

We support all classes implementing `ConfigurationSerializable`. To be precise we support the following classes:

- Vector
- BlockVector
- Color (Can be serialized as object or as hex string)
- ItemStack (Serialized as map for `JacksonBukkit`. Serialized as Base64 encoded bytes for `JacksonPaper`)
- PotionEffect
- FireworkEffect
- Pattern
- BoundingBox
- AttributeModifier
- Location

**Additional Support for:**

- NamespacedKey
- OfflinePlayer
- Inventory via `InventoryWrapper` class
