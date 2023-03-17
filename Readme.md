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

## Usage

Simply add the JacksonBukkit module to the builder of your choice.

```java
    ObjectMapper JSON = JsonMapper.builder()
            .addModule(new JacksonBukkit())
            .build();

```

## Supported Classes

We support all classes implementing `ConfigurationSerializable`. To be precise we support the following classes:

- Vector
- BlockVector
- Color
- ItemStack (Serialized as Base64 encoded bytes as recommended by [paper](https://jd.papermc.io/paper/1.19/org/bukkit/inventory/ItemStack.html#serializeAsBytes()))
- PotionEffect
- FireworkEffect
- Pattern
- BoundingBox
- AttributeModifier
- Location

**Additional Support for:**

- NamespacedKey
- OfflinePlayer
- Inventory via InventoryWrapper class
