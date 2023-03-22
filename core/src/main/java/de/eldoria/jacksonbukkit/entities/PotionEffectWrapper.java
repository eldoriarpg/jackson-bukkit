/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.bukkit.NamespacedKey;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 * Class for wrapping a {@link PotionEffect}.
 * <p>
 * This class is for version 1.16 and newer and uses a {@link NamespacedKey} instead of integer id.
 */
public final class PotionEffectWrapper extends BasePotionEffectWrapper<NamespacedKey> {
    /**
     * Create a new potion wrapper instance.
     *
     * @param amplifier the amplifier, see {@link PotionEffect#getAmplifier()}
     * @param duration  measured in ticks, see {@link PotionEffect#getDuration()}
     * @param type      effect type as {@link NamespacedKey}
     * @param ambient   the ambient status, see {@link PotionEffect#isAmbient()}
     * @param particles the particle status, see {@link PotionEffect#hasParticles()}
     * @param icon      the icon status, see {@link PotionEffect#hasIcon()}
     */
    public PotionEffectWrapper(@JsonProperty("amplifier") int amplifier,
                               @JsonProperty("duration") int duration,
                               @JsonProperty("type") NamespacedKey type,
                               @JsonProperty("ambient") boolean ambient,
                               @JsonProperty("particles") boolean particles,
                               @JsonProperty("icon") boolean icon) {
        super(amplifier, duration, type, ambient, particles, icon);
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
        return new PotionEffectWrapper(amplifier, duration, type.getKey(), ambient, particles, icon);

    }

    /**
     * Constructs a new {@link PotionEffect} based on wrapper values.
     *
     * @return new {@link PotionEffect} instance
     */
    public PotionEffect toBukkitPotionEffect() {
        return new PotionEffect(PotionEffectType.getByKey(type()), duration, amplifier, ambient, particles, icon);
    }
}
