/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit;

import com.fasterxml.jackson.databind.module.SimpleDeserializers;
import com.fasterxml.jackson.databind.module.SimpleSerializers;
import de.eldoria.jacksonbukkit.builder.JacksonBukkitBuilder;
import de.eldoria.jacksonbukkit.deserializer.HexRGBColorDeserializer;
import de.eldoria.jacksonbukkit.deserializer.LegacyItemStackDeserializer;
import de.eldoria.jacksonbukkit.deserializer.RGBColorDeserializer;
import de.eldoria.jacksonbukkit.serializer.HexRGBColorSerializer;
import de.eldoria.jacksonbukkit.serializer.LegacyItemStackSerializer;
import de.eldoria.jacksonbukkit.serializer.RGBColorSerializer;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.OfflinePlayer;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.block.banner.Pattern;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.util.BlockVector;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.ApiStatus;

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
 * </ul>
 */
public class JacksonBukkit extends JacksonBukkitModule {

    /**
     * Create a new JacksonBukkit module.
     *
     * @param hexColors true to serialize colors as hex by default
     */
    @ApiStatus.Internal
    public JacksonBukkit(boolean hexColors) {
        super(hexColors);
    }

    @Override
    public String getModuleName() {
        return "JacksonBukkit";
    }

    /**
     * Create a new JacksonPaper module.
     */
    @ApiStatus.Internal
    public JacksonBukkit() {
        this(false);
    }

    @Override
    protected void registerDeserializer(SimpleDeserializers deserializers) {
        deserializers.addDeserializer(ItemStack.class, new LegacyItemStackDeserializer());
        deserializers.addDeserializer(Color.class, hexColors ? new HexRGBColorDeserializer() : new RGBColorDeserializer());
    }

    @Override
    protected void registerSerializer(SimpleSerializers serializers) {
        serializers.addSerializer(ItemStack.class, new LegacyItemStackSerializer());
        serializers.addSerializer(Color.class, hexColors ? new HexRGBColorSerializer() : new RGBColorSerializer());
    }

    /**
     * Creates a new builder for a {@link JacksonBukkit} module
     * @return builder instance
     */
    public static JacksonBukkitBuilder builder() {
        return new JacksonBukkitBuilder();
    }
}
