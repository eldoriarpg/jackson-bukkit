/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.module.SimpleDeserializers;
import com.fasterxml.jackson.databind.module.SimpleSerializers;
import de.eldoria.jacksonbukkit.deserializer.BlockVectorDeserializer;
import de.eldoria.jacksonbukkit.deserializer.ColorDeserializer;
import de.eldoria.jacksonbukkit.deserializer.ItemStackDeserializer;
import de.eldoria.jacksonbukkit.deserializer.NamespacedKeyDeserializer;
import de.eldoria.jacksonbukkit.deserializer.PotionEffectDeserializer;
import de.eldoria.jacksonbukkit.deserializer.VectorDeserializer;
import de.eldoria.jacksonbukkit.serializer.BlockVectorSerializer;
import de.eldoria.jacksonbukkit.serializer.ColorSerializer;
import de.eldoria.jacksonbukkit.serializer.ItemStackSerializer;
import de.eldoria.jacksonbukkit.serializer.NamespacedKeySerializer;
import de.eldoria.jacksonbukkit.serializer.PotionEffectSerializer;
import de.eldoria.jacksonbukkit.serializer.VectorSerializer;
import org.bukkit.Color;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.util.BlockVector;
import org.bukkit.util.Vector;

public class JacksonSpigot extends Module {
    @Override
    public String getModuleName() {
        return "JacksonBukkit";
    }

    @Override
    public Version version() {
        return new Version(1, 0, 0, "", "de.eldoria", "jackson-bukkit");
    }

    @Override
    public void setupModule(SetupContext context) {

        SimpleSerializers serializers = new SimpleSerializers();
        serializers.addSerializer(Vector.class, new VectorSerializer());
        serializers.addSerializer(BlockVector.class, new BlockVectorSerializer());
        serializers.addSerializer(Color.class, new ColorSerializer());
        serializers.addSerializer(ItemStack.class, new ItemStackSerializer());
        serializers.addSerializer(NamespacedKey.class, new NamespacedKeySerializer());
        serializers.addSerializer(PotionEffect.class, new PotionEffectSerializer());

        SimpleDeserializers deserializers = new SimpleDeserializers();
        deserializers.addDeserializer(Vector.class, new VectorDeserializer());
        deserializers.addDeserializer(BlockVector.class, new BlockVectorDeserializer());
        deserializers.addDeserializer(Color.class, new ColorDeserializer());
        deserializers.addDeserializer(ItemStack.class, new ItemStackDeserializer());
        deserializers.addDeserializer(NamespacedKey.class, new NamespacedKeyDeserializer());
        deserializers.addDeserializer(PotionEffect.class, new PotionEffectDeserializer());

        context.addSerializers(serializers);
        context.addDeserializers(deserializers);
    }
}

/*

- Vector
- BlockVector
- ItemStack
- Color
- PotionEffect
- FireworkEffect
- Pattern
- Location
- AttributeModifier
- BoundingBox

 */
