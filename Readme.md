![GitHub Workflow Status](https://img.shields.io/github/actions/workflow/status/eldoriarpg/jackson-bukkit/verify.yml?branch=main&style=for-the-badge&label=Building)
![GitHub Workflow Status](https://img.shields.io/github/actions/workflow/status/eldoriarpg/jackson-bukkit/publish_to_nexus.yml?branch=main&style=for-the-badge&label=Publishing) \
![Sonatype Nexus (Releases)](https://img.shields.io/nexus/maven-releases/de.eldoria.jacksonbukkit/jackson-bukkit?label=Release&logo=Release&server=https%3A%2F%2Feldonexus.de&style=for-the-badge)
![Sonatype Nexus (Development)](https://img.shields.io/nexus/maven-dev/de.eldoria.jacksonbukkit/jackson-bukkit?label=DEV&logo=Release&server=https%3A%2F%2Feldonexus.de&style=for-the-badge)
![Sonatype Nexus (Snapshots)](https://img.shields.io/nexus/s/de.eldoria.jacksonbukkit/jackson-bukkit?color=orange&label=Snapshot&server=https%3A%2F%2Feldonexus.de&style=for-the-badge)

### [Javadocs](https://eldoriarpg.github.io/jackson-bukkit/)

This is a module supporting serialization of common bukkit objects and some more on Spigot and Paper servers.
The library should always support every version between 1.13 and the latest minecraft version. 
We do not use any NMS, therefore it should not be required to update this library often.
It might work on earlier versions as well, but we do not check for this.
The library takes format changes into account between versions. 
It is therefore safe to read old data on a newer version.
Reading new data on an older version is not explicitly supported.

We provide two modules for Bukkit/Spigot and one for Paper.
To use the full feature set we recommend Paper.
Make sure to use the Paper module when your plugin is running on paper.
Switching from Spigot to Paper will always work, but going back might cause errors.

### Known and implemented changes

Those are the format changes we support when updating to a newer version.
The deserializer detect the current used format automatically and will parse it into the requested type.
When serializing the data the currently used serializer will be used. 

#### General

- In 1.16 the type of PotionEffect changed from a numeric integer to a namespaced key.

#### Paper

- In 1.16 Paper added the `serializeAsBytes` method to item stacks. This method will be used by default when available.
- In 1.16 Paper added Adventure. If you haven't shaded it yet, you are now able to serialize Components as Objects.
- In 1.18.2 Paper included MiniMessages. If you haven't shaded it yet, Components will be serialized using MiniMessages from here on.
- In 1.19 Paper added an alpha value to `Color`. The value will be automatically added.

## Dependency

**Gradle**

```kts
repositories {
    maven("https://eldonexus.de/repository/maven-public")
}

dependencies {
    // Spigot server
    compileOnly("de.eldoria.jacksonbukkit", "spigot", "version")
    // Paper server
    compileOnly("de.eldoria.jacksonbukkit", "paper", "version")
}
```

**Maven**

<!-- @formatter:off -->

```xml

<repositories>
    <repository>
        <id>EldoNexus</id>
        <url>https://eldonexus.de/repository/maven-public/</url>
    </repository>
</repositories>

<dependencies>
    <!-- Spigot Server -->
    <dependency>
        <groupId>de.eldoria.jacksonbukkit</groupId>
        <artifactId>spigot</artifactId>
        <version>version</version>
    </dependency>

    <!-- Paper Server-->
    <dependency>
        <groupId>de.eldoria.jacksonbukkit</groupId>
        <artifactId>paper</artifactId>
        <version>version</version>
    </dependency>
</dependencies>
```

<!-- @formatter:on -->

## Module Creation

You can either create the `JacksonBukkit` and `JacksonPaper` module directly or use the builder for easy modification.
Usage of the builder is recommended.
Builder for spigot and paper can both be accessed via the corresponding class.

### Creating a Spigot/Bukkit Module

```java
ObjectMapper JSON = JsonMapper.builder()
    .addModule(JacksonBukkit.builder().build())
    .build();
```

### Creating a Paper Module

```java
ObjectMapper JSON = JsonMapper.builder()
    .addModule(JacksonPaper.builer().build())
    .build();
```

Of course, you can use TOML or YAML or whatever else jackson supports as well

### Difference between Paper and Bukkit module

The paper module tries to support all features available by paper.
The deserializer will automatically detect the current format when a legacy format is used and convert it into the new format when saved.
Therefore, a config created on 1.15 will contain the legacy map and once teh server is running on 1.16 the byte array will be used instead.

Paper serializes `ItemStack`s to a Base64 encoded byte array instead of using spigots serialization.
This will only work on paper servers on 1.16 or newer and not on spigot servers.
The builder allows to use spigots serialization on paper servers as well, but this is not recommended.

When creating a [paper plugin](https://docs.papermc.io/paper/reference/paper-plugins) the `JacksonBukkit` module is no longer able to serialize `ItemStacks`.
You need to use `JacksonPaper` in that case and make sure that you are not using legacy serialization.

| Class     | Paper                                                                   | Spigot         |
|-----------|-------------------------------------------------------------------------|----------------|
| Color     | RGB or HEX RGB < 1.19 <= RGBA or HEX RGBA                               | RGB or HEX RGB |
| ItemStack | legacy Map < 1.16 <= NBT byte array                                     | Legacy Map     |
| Component | MiniMessage String when MiniMessages is present. Otherwise Json Object. | Nope c:        |

### More customization

There are some more customizations

#### Color

Colors will be read and written to an object containing a value for red, green, blue and alpha (Paper only) by default.
By calling `ModuleBuilder#colorAsHex()` you can enable hex codes.
This will attempt to read each color as a HEX string with RGBA (Paper) or RGB (Spigot) format.
It will also write colors as RGBA (Paper) or RGB (Spigot).

**Warning:** As of now you can use either way, but not both at the same time. Mixing up format will cause errors.

## Supported Classes

We support all classes implementing `ConfigurationSerializable`. To be precise we support the following classes:

- Vector
- BlockVector
- Color (Can be serialized as object or as hex string)
- ItemStack (Serialized as map for `JacksonBukkit`. Serialized as Base64 encoded bytes for `JacksonPaper`, when possible)
- PotionEffect
- FireworkEffect
- Pattern
- BoundingBox
- AttributeModifier
- Location

**Additional Support for:**

- NamespacedKey
- OfflinePlayer
- Components (Paper only as MiniMessage string)
