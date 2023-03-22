/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.module.SimpleDeserializers;
import com.fasterxml.jackson.databind.module.SimpleSerializers;
import de.eldoria.jacksonbukkit.builder.JacksonPaperBuilder;
import de.eldoria.jacksonbukkit.deserializer.ComponentGsonDeserializer;
import de.eldoria.jacksonbukkit.deserializer.HexRGBAColorDeserializer;
import de.eldoria.jacksonbukkit.deserializer.LegacyItemStackDeserializer;
import de.eldoria.jacksonbukkit.deserializer.PaperItemStackDeserializer;
import de.eldoria.jacksonbukkit.deserializer.RGBAColorDeserializer;
import de.eldoria.jacksonbukkit.serializer.ComponentGsonSerializer;
import de.eldoria.jacksonbukkit.serializer.HexPaperColorSerializer;
import de.eldoria.jacksonbukkit.serializer.LegacyItemStackSerializer;
import de.eldoria.jacksonbukkit.serializer.PaperColorSerializer;
import de.eldoria.jacksonbukkit.serializer.PaperItemStackSerializer;
import net.kyori.adventure.text.Component;
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
 *     <li>{@link Component}
 * </ul>
 */
public class JacksonPaper extends JacksonBukkitModule {
    private final boolean legacyItemStackSerialization;
    private final JsonDeserializer<Component> componentDeserializer;
    private final JsonSerializer<Component> componentSerializer;

    /**
     * Create a new JacksonPaper module.
     *
     * @param hexColors                    true to serialize colors as hex by default
     * @param legacyItemStackSerialization true to use spigot based serialization
     */
    @ApiStatus.Internal
    public JacksonPaper(boolean hexColors, boolean legacyItemStackSerialization,
                        JsonDeserializer<Component> componentDeserializer, JsonSerializer<Component> componentSerializer) {
        super(hexColors);
        this.legacyItemStackSerialization = legacyItemStackSerialization;
        this.componentDeserializer = componentDeserializer;
        this.componentSerializer = componentSerializer;
    }

    /**
     * Create a new JacksonPaper module.
     */
    @ApiStatus.Internal
    public JacksonPaper() {
        super(false);
        legacyItemStackSerialization = false;
        componentDeserializer = new ComponentGsonDeserializer();
        componentSerializer = new ComponentGsonSerializer();
    }

    /**
     * Get a new builder to create a {@link JacksonPaper} module.
     *
     * @return builder instance
     */
    public static JacksonPaperBuilder builder() {
        return new JacksonPaperBuilder();
    }

    @Override
    public String getModuleName() {
        return "JacksonPaper";
    }

    @Override
    protected void registerSerializer(SimpleSerializers serializers) {
        if (!legacyItemStackSerialization) {
            serializers.addSerializer(ItemStack.class, new PaperItemStackSerializer());
        }else {
            serializers.addSerializer(ItemStack.class, new LegacyItemStackSerializer());
        }
        serializers.addSerializer(Color.class, hexColors ? new HexPaperColorSerializer() : new PaperColorSerializer());
        serializers.addSerializer(Component.class, componentSerializer);
    }

    @Override
    protected void registerDeserializer(SimpleDeserializers deserializers) {
        if (!legacyItemStackSerialization) {
            deserializers.addDeserializer(ItemStack.class, new PaperItemStackDeserializer());
        }else {
            deserializers.addDeserializer(ItemStack.class, new LegacyItemStackDeserializer());
        }
        deserializers.addDeserializer(Color.class, hexColors ? new HexRGBAColorDeserializer() : new RGBAColorDeserializer());
        deserializers.addDeserializer(Component.class, componentDeserializer);
    }
}
