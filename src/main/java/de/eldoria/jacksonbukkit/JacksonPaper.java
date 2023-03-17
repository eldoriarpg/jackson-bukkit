/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.module.SimpleDeserializers;
import com.fasterxml.jackson.databind.module.SimpleSerializers;
import de.eldoria.jacksonbukkit.deserializer.AttributeModifierDeserializer;
import de.eldoria.jacksonbukkit.deserializer.BlockVectorDeserializer;
import de.eldoria.jacksonbukkit.deserializer.BoundingBoxDeserializer;
import de.eldoria.jacksonbukkit.deserializer.ColorDeserializer;
import de.eldoria.jacksonbukkit.deserializer.FireworkEffectDeserializer;
import de.eldoria.jacksonbukkit.deserializer.InventoryDeserializer;
import de.eldoria.jacksonbukkit.deserializer.LocationDeserializer;
import de.eldoria.jacksonbukkit.deserializer.NamespacedKeyDeserializer;
import de.eldoria.jacksonbukkit.deserializer.PaperItemStackDeserializer;
import de.eldoria.jacksonbukkit.deserializer.PatternDeserializer;
import de.eldoria.jacksonbukkit.deserializer.PlayerDeserializer;
import de.eldoria.jacksonbukkit.deserializer.PotionEffectDeserializer;
import de.eldoria.jacksonbukkit.deserializer.VectorDeserializer;
import de.eldoria.jacksonbukkit.entities.InventoryWrapper;
import de.eldoria.jacksonbukkit.serializer.AttributeModifierSerializer;
import de.eldoria.jacksonbukkit.serializer.BlockVectorSerializer;
import de.eldoria.jacksonbukkit.serializer.BoundingBoxSerializer;
import de.eldoria.jacksonbukkit.serializer.ColorSerializer;
import de.eldoria.jacksonbukkit.serializer.FireworkEffectSerializer;
import de.eldoria.jacksonbukkit.serializer.InventorySerializer;
import de.eldoria.jacksonbukkit.serializer.LocationSerializer;
import de.eldoria.jacksonbukkit.serializer.NamespacedKeySerializer;
import de.eldoria.jacksonbukkit.serializer.PaperItemStackSerializer;
import de.eldoria.jacksonbukkit.serializer.PatternSerializer;
import de.eldoria.jacksonbukkit.serializer.PlayerSerializer;
import de.eldoria.jacksonbukkit.serializer.PotionEffectSerializer;
import de.eldoria.jacksonbukkit.serializer.VectorSerializer;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.OfflinePlayer;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.block.banner.Pattern;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.util.BlockVector;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.Vector;

/**
 * Class adding support for classes implementing {@link ConfigurationSerializable}.
 *
 * <ul>
 *     <li>{@link Vector}
 *     <li>{@link BlockVector}
 *     <li>{@link Color}
 *     <li>{@link ItemStack}
 *     <li>{@link PotionEffect}
 *     <li>{@link FireworkEffect}
 *     <li>{@link Pattern}
 *     <li>{@link BoundingBox}
 *     <li>{@link AttributeModifier}
 *     <li>{@link Location}
 * </ul>
 * <p>
 * It also provides some additional serialization for:
 * <ul>
 *     <li>{@link NamespacedKey}
 *     <li>{@link OfflinePlayer}
 *     <li>{@link Inventory} via {@link InventoryWrapper}
 * </ul>
 * <p>
 */
public class JacksonPaper extends JacksonBukkit {
    @Override
    public String getModuleName() {
        return "JacksonPaper";
    }

    @Override
    protected void addDeserializer(SimpleDeserializers deserializers) {
        super.addDeserializer(deserializers);
        deserializers.addDeserializer(ItemStack.class, new PaperItemStackDeserializer());
    }

    @Override
    protected void addSerializer(SimpleSerializers serializers) {
        super.addSerializer(serializers);
        serializers.addSerializer(ItemStack.class, new PaperItemStackSerializer());
    }
}
