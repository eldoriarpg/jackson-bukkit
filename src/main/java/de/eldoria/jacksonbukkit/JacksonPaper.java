/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit;

import com.fasterxml.jackson.databind.module.SimpleDeserializers;
import com.fasterxml.jackson.databind.module.SimpleSerializers;
import de.eldoria.jacksonbukkit.builder.JacksonPaperBuilder;
import de.eldoria.jacksonbukkit.deserializer.PaperItemStackDeserializer;
import de.eldoria.jacksonbukkit.entities.InventoryWrapper;
import de.eldoria.jacksonbukkit.serializer.PaperItemStackSerializer;
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
    public JacksonPaper(boolean hexColors) {
        super(hexColors);
    }

    public JacksonPaper() {
        super();
    }

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
