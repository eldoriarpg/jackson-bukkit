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
 * @param <T> type of type identifier
 */
@JsonPropertyOrder({"amplifier", "duration", "type", "ambient", "particles", "icon"})
public class BasePotionEffectWrapper<T> {
    /**
     * Effect amplifier
     */
    protected final int amplifier;
    /**
     * Effect duration
     */
    protected final int duration;
    /**
     * Effect type
     */
    protected final T type;
    /**
     * Indicates ambient effect
     */
    protected final boolean ambient;
    /**
     * Indicates particles on effect
     */
    protected final boolean particles;
    /**
     * Indicates effect with icon
     */
    protected final boolean icon;

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

    public BasePotionEffectWrapper(int amplifier, int duration, T type, boolean ambient, boolean particles, boolean icon) {
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
    @JsonProperty
    public int amplifier() {
        return amplifier;
    }

    /**
     * Effect duration
     *
     * @return duration
     */
    @JsonProperty
    public int duration() {
        return duration;
    }

    /**
     * Effect type
     *
     * @return type
     */
    @JsonProperty
    public T type() {
        return type;
    }

    /**
     * Indicates ambient effect
     *
     * @return true when ambient
     */
    @JsonProperty
    public boolean ambient() {
        return ambient;
    }

    /**
     * Indicates particles on effect
     *
     * @return true when particles are visible
     */
    @JsonProperty
    public boolean particles() {
        return particles;
    }

    /**
     * Indicates effect with icon
     *
     * @return true when icon visible
     */
    @JsonProperty
    public boolean icon() {
        return icon;
    }
}
