---
title: Full example
sidebar_position: 7
---

# Full example

This small Paper plugin keeps its arena settings in `arena.yml`. On the first start it writes a default file.
When a player joins, they are sent to the arena spawn, get a welcome message, a reward and some potion effects.

## Build file

```kotlin
plugins {
    java
    id("com.gradleup.shadow") version "9.6.1"
}

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.20-R0.1-SNAPSHOT")

    implementation("de.eldoria.jacksonbukkit:paper:2.0.0")
    implementation(platform("tools.jackson:jackson-bom:3.0.3"))
    implementation("tools.jackson.dataformat:jackson-dataformat-yaml")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}
```

Use the Paper API version of your server. Build the plugin with the `shadowJar` task, so Jackson and Jackson Bukkit
end up in the jar.

## plugin.yml

```yaml
name: Arena
version: 1.0.0
main: com.example.arena.ArenaPlugin
api-version: "1.20"
```

## The config class

A record with Bukkit and Adventure types. Jackson reads and writes records without any annotations.

```java
package com.example.arena;

import java.util.List;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.data.BlockData;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.BoundingBox;

public record ArenaConfig(
        Location spawn,
        BoundingBox area,
        BlockData marker,
        Color teamColor,
        ItemStack reward,
        List<PotionEffect> startEffects,
        Component welcome) {

    public static ArenaConfig defaults(World world) {
        return new ArenaConfig(
                new Location(world, 0.5, 64, 0.5),
                new BoundingBox(-20, 60, -20, 20, 80, 20),
                Bukkit.createBlockData(Material.RED_WOOL),
                Color.fromRGB(255, 60, 0),
                new ItemStack(Material.DIAMOND, 3),
                List.of(new PotionEffect(PotionEffectType.SPEED, 200, 0)),
                Component.text("Welcome to the arena!", NamedTextColor.GOLD));
    }
}
```

## The plugin

```java
package com.example.arena;

import de.eldoria.jacksonbukkit.JacksonPaper;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.dataformat.yaml.YAMLMapper;

public final class ArenaPlugin extends JavaPlugin implements Listener {
    private final ObjectMapper yaml = YAMLMapper.builder()
            .addModule(JacksonPaper.builder().colorAsHex().build())
            .build();
    private ArenaConfig arena;

    @Override
    public void onEnable() {
        Path file = getDataFolder().toPath().resolve("arena.yml");
        if (Files.notExists(file)) {
            writeDefaults(file);
        }
        arena = yaml.readValue(file, ArenaConfig.class);
        getServer().getPluginManager().registerEvents(this, this);
    }

    private void writeDefaults(Path file) {
        try {
            Files.createDirectories(file.getParent());
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        yaml.writeValue(file, ArenaConfig.defaults(getServer().getWorlds().getFirst()));
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.teleport(arena.spawn());
        player.sendMessage(arena.welcome());
        player.getInventory().addItem(arena.reward().clone());
        player.addPotionEffects(arena.startEffects());
    }
}
```

The config is read in `onEnable`. At that point the worlds are loaded, so the spawn finds its world.

## The file it writes

On the first start, `plugins/Arena/arena.yml` looks like this (on Paper 1.19 or newer, so the color has an alpha
value):

```yaml
---
spawn:
  uid: "<UUID of the world>"
  name: "world"
  xCoord: 0.5
  yCoord: 64.0
  zCoord: 0.5
  yaw: 0.0
  pitch: 0.0
area:
  corner1:
    xCoord: -20.0
    yCoord: 60.0
    zCoord: -20.0
  corner2:
    xCoord: 20.0
    yCoord: 80.0
    zCoord: 20.0
marker: "minecraft:red_wool"
teamColor: "FF3C00FF"
reward: "<Base64 text>"
startEffects:
- amplifier: 0
  duration: 200
  type:
    namespace: "minecraft"
    key: "speed"
  ambient: false
  particles: true
  icon: true
welcome: "<gold>Welcome to the arena!"
```

The server owner can now change the spawn, the area, the marker block, the color, the effects or the welcome text
in the file. The reward item is Base64 text and is not meant to be edited by hand. See
[Items and recipes](./types/items.md) for the item formats.
