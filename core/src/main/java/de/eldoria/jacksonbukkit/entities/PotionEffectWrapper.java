/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 * Class for wrapping a {@link PotionEffect}.
 *
 * @param amplifier Effect amplifier
 * @param duration  Effect duration
 * @param type      Effect type
 * @param ambient   Indicates ambient effect
 * @param particles Indicates particles on effect
 * @param icon      Indicates effect with icon
 */
@JsonPropertyOrder({"amplifier", "duration", "type", "ambient", "particles", "icon"})
public record PotionEffectWrapper(int amplifier, int duration, PotionEffectType type, boolean ambient,
                                  boolean particles, boolean icon) {
    /**
     * Create a new base potion wrapper.
     *
     * @param amplifier the amplifier, see {@link PotionEffect#getAmplifier()}
     * @param duration  measured in ticks, see {@link PotionEffect#getDuration()}
     * @param type      effect type as id as defined in {@link PotionEffectType#getId()}
     * @param ambient   the ambient status, see {@link PotionEffect#isAmbient()}
     * @param particles the particle status, see {@link PotionEffect#hasParticles()}
     * @param icon      the icon status, see {@link PotionEffect#hasIcon()}
     */

    public PotionEffectWrapper(@JsonProperty("amplifier") int amplifier,
                               @JsonProperty("duration") int duration,
                               @JsonProperty("type") PotionEffectType type,
                               @JsonProperty("ambient") boolean ambient,
                               @JsonProperty("particles") boolean particles,
                               @JsonProperty("icon") boolean icon) {
        this.amplifier = amplifier;
        this.duration = duration;
        this.type = type;
        this.ambient = ambient;
        this.particles = particles;
        this.icon = icon;
    }

    /**
     * Effect amplifier
     *
     * @return amplifier
     */
    @Override
    @JsonProperty
    public int amplifier() {
        return amplifier;
    }

    /**
     * Effect duration
     *
     * @return duration
     */
    @Override
    @JsonProperty
    public int duration() {
        return duration;
    }

    /**
     * Effect type
     *
     * @return type
     */
    @Override
    @JsonProperty
    public PotionEffectType type() {
        return type;
    }

    /**
     * Indicates ambient effect
     *
     * @return true when ambient
     */
    @Override
    @JsonProperty
    public boolean ambient() {
        return ambient;
    }

    /**
     * Indicates particles on effect
     *
     * @return true when particles are visible
     */
    @Override
    @JsonProperty
    public boolean particles() {
        return particles;
    }

    /**
     * Indicates effect with icon
     *
     * @return true when icon visible
     */
    @Override
    @JsonProperty
    public boolean icon() {
        return icon;
    }

    /**
     * Create a new {@link PotionEffectWrapper} based on a {@link PotionEffect}.
     *
     * @param effect potion effect instance
     * @return new {@link PotionEffectWrapper} instance
     */
    public static PotionEffectWrapper of(PotionEffect effect) {
        int amplifier = effect.getAmplifier();
        int duration = effect.getDuration();
        PotionEffectType type = effect.getType();
        boolean ambient = effect.isAmbient();
        boolean icon = effect.hasIcon();
        boolean particles = effect.hasParticles();
        return new PotionEffectWrapper(amplifier, duration, type, ambient, particles, icon);

    }

    /**
     * Constructs a new {@link PotionEffect} based on wrapper values.
     *
     * @return new {@link PotionEffect} instance
     */
    public PotionEffect toBukkitPotionEffect() {
        return new PotionEffect(type, duration, amplifier, ambient, particles, icon);
    }
}
