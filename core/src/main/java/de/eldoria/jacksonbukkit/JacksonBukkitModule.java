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
import de.eldoria.jacksonbukkit.deserializer.AttributeModifierDeserializer;
import de.eldoria.jacksonbukkit.deserializer.BlockVectorDeserializer;
import de.eldoria.jacksonbukkit.deserializer.BoundingBoxDeserializer;
import de.eldoria.jacksonbukkit.deserializer.ExactChoiceDeserializer;
import de.eldoria.jacksonbukkit.serializer.EnchantmentSerializer;
import de.eldoria.jacksonbukkit.deserializer.FireworkEffectDeserializer;
import de.eldoria.jacksonbukkit.deserializer.LocationDeserializer;
import de.eldoria.jacksonbukkit.deserializer.MaterialChoiceDeserializer;
import de.eldoria.jacksonbukkit.deserializer.NamespacedKeyDeserializer;
import de.eldoria.jacksonbukkit.deserializer.PatternDeserializer;
import de.eldoria.jacksonbukkit.deserializer.PlayerDeserializer;
import de.eldoria.jacksonbukkit.deserializer.PotionEffectDeserializer;
import de.eldoria.jacksonbukkit.deserializer.PotionEffectTypeDeserializer;
import de.eldoria.jacksonbukkit.deserializer.RGBColorDeserializer;
import de.eldoria.jacksonbukkit.deserializer.ShapedRecipeDeserializer;
import de.eldoria.jacksonbukkit.deserializer.ShapelessRecipeDeserializer;
import de.eldoria.jacksonbukkit.deserializer.VectorDeserializer;
import de.eldoria.jacksonbukkit.serializer.AttributeModifierSerializer;
import de.eldoria.jacksonbukkit.serializer.BlockVectorSerializer;
import de.eldoria.jacksonbukkit.serializer.BoundingBoxSerializer;
import de.eldoria.jacksonbukkit.serializer.ExactChoiceSerializer;
import de.eldoria.jacksonbukkit.deserializer.EnchantmentDeserializer;
import de.eldoria.jacksonbukkit.serializer.FireworkEffectSerializer;
import de.eldoria.jacksonbukkit.serializer.LocationSerializer;
import de.eldoria.jacksonbukkit.serializer.MaterialChoiceSerializer;
import de.eldoria.jacksonbukkit.serializer.NamespacedKeySerializer;
import de.eldoria.jacksonbukkit.serializer.PatternSerializer;
import de.eldoria.jacksonbukkit.serializer.PlayerSerializer;
import de.eldoria.jacksonbukkit.serializer.PotionEffectSerializer;
import de.eldoria.jacksonbukkit.serializer.PotionEffectTypeSerializer;
import de.eldoria.jacksonbukkit.serializer.RGBColorSerializer;
import de.eldoria.jacksonbukkit.serializer.ShapedRecipeSerializer;
import de.eldoria.jacksonbukkit.serializer.ShapelessRecipeSerializer;
import de.eldoria.jacksonbukkit.serializer.VectorSerializer;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.OfflinePlayer;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.block.banner.Pattern;
import org.bukkit.inventory.RecipeChoice.ExactChoice;
import org.bukkit.inventory.RecipeChoice.MaterialChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.BlockVector;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.ApiStatus;

/**
 * Base class to implement a bukkit jackson module.
 */
@ApiStatus.Internal
public abstract class JacksonBukkitModule extends Module {
    /**
     * True when colors should be interpreted as hex strings.
     */
    protected final boolean hexColors;

    /**
     * Creates a new jackson bukkit module
     *
     * @param hexColors true to use hex colors
     */
    public JacksonBukkitModule(boolean hexColors) {
        this.hexColors = hexColors;
    }

    @Override
    public abstract String getModuleName();

    @Override
    public Version version() {
        return new Version(1, 0, 0, "", "de.eldoria.jacksonbukkit", "jackson-bukkit");
    }

    @Override
    public void setupModule(SetupContext context) {
        SimpleSerializers serializers = new SimpleSerializers();
        addSerializer(serializers);

        SimpleDeserializers deserializers = new SimpleDeserializers();
        addDeserializer(deserializers);

        context.addSerializers(serializers);
        context.addDeserializers(deserializers);
    }

    /**
     * Add serializer to the serializers
     *
     * @param serializers serializers
     */
    protected final void addSerializer(SimpleSerializers serializers) {
        serializers.addSerializer(Vector.class, new VectorSerializer());
        serializers.addSerializer(BlockVector.class, new BlockVectorSerializer());
        serializers.addSerializer(NamespacedKey.class, new NamespacedKeySerializer());
        serializers.addSerializer(PotionEffect.class, new PotionEffectSerializer());
        serializers.addSerializer(PotionEffectType.class, new PotionEffectTypeSerializer());
        serializers.addSerializer(FireworkEffect.class, new FireworkEffectSerializer());
        serializers.addSerializer(Pattern.class, new PatternSerializer());
        serializers.addSerializer(BoundingBox.class, new BoundingBoxSerializer());
        serializers.addSerializer(Enchantment.class, new EnchantmentSerializer());
        serializers.addSerializer(AttributeModifier.class, new AttributeModifierSerializer());
        serializers.addSerializer(Location.class, new LocationSerializer());
        serializers.addSerializer(OfflinePlayer.class, new PlayerSerializer());
        serializers.addSerializer(Color.class, new RGBColorSerializer());
        serializers.addSerializer(ExactChoice.class, new ExactChoiceSerializer());
        serializers.addSerializer(MaterialChoice.class, new MaterialChoiceSerializer());
        serializers.addSerializer(ShapedRecipe.class, new ShapedRecipeSerializer());
        serializers.addSerializer(ShapelessRecipe.class, new ShapelessRecipeSerializer());
        registerSerializer(serializers);
    }

    /**
     * Register serializer of the inheriting class
     * <p>
     * Will be called after default serializer were registered.
     *
     * @param serializers serializers
     */
    protected abstract void registerSerializer(SimpleSerializers serializers);

    /**
     * Add deserializer to the deserializers
     *
     * @param deserializers deserializers
     */
    protected final void addDeserializer(SimpleDeserializers deserializers) {
        deserializers.addDeserializer(Vector.class, new VectorDeserializer());
        deserializers.addDeserializer(BlockVector.class, new BlockVectorDeserializer());
        deserializers.addDeserializer(NamespacedKey.class, new NamespacedKeyDeserializer());
        deserializers.addDeserializer(PotionEffect.class, new PotionEffectDeserializer());
        deserializers.addDeserializer(PotionEffectType.class, new PotionEffectTypeDeserializer());
        deserializers.addDeserializer(FireworkEffect.class, new FireworkEffectDeserializer());
        deserializers.addDeserializer(Pattern.class, new PatternDeserializer());
        deserializers.addDeserializer(BoundingBox.class, new BoundingBoxDeserializer());
        deserializers.addDeserializer(Enchantment.class, new EnchantmentDeserializer());
        deserializers.addDeserializer(AttributeModifier.class, new AttributeModifierDeserializer());
        deserializers.addDeserializer(Location.class, new LocationDeserializer());
        deserializers.addDeserializer(OfflinePlayer.class, new PlayerDeserializer());
        deserializers.addDeserializer(Color.class, new RGBColorDeserializer());
        deserializers.addDeserializer(ExactChoice.class, new ExactChoiceDeserializer());
        deserializers.addDeserializer(MaterialChoice.class, new MaterialChoiceDeserializer());
        deserializers.addDeserializer(ShapedRecipe.class, new ShapedRecipeDeserializer());
        deserializers.addDeserializer(ShapelessRecipe.class, new ShapelessRecipeDeserializer());
        registerDeserializer(deserializers);
    }

    /**
     * Register deserializers of the inheriting class.
     * <p>
     * Will be called after default deserializer were registered.
     *
     * @param deserializers deserializers
     */
    protected abstract void registerDeserializer(SimpleDeserializers deserializers);
}
