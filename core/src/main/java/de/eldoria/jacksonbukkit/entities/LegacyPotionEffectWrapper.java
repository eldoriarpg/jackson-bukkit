/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bukkit.NamespacedKey;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Objects;

/**
 * Class for wrapping a {@link PotionEffect}.
 */
public final class LegacyPotionEffectWrapper extends BasePotionEffectWrapper<Integer> {

    /**
     *
     */
    @JsonCreator
    public LegacyPotionEffectWrapper(@JsonProperty("amplifier") int amplifier,
                                     @JsonProperty("duration") int duration,
                                     @JsonProperty("type") int type,
                                     @JsonProperty("ambient") boolean ambient,
                                     @JsonProperty("particles") boolean particles,
                                     @JsonProperty("icon") boolean icon) {
        super(amplifier, duration, type, ambient, particles, icon);
    }

    /**
     * Create a new {@link LegacyPotionEffectWrapper} based on a {@link PotionEffect}.
     *
     * @param effect potion effect instance
     * @return new {@link LegacyPotionEffectWrapper} instance
     */
    public static LegacyPotionEffectWrapper of(PotionEffect effect) {
        int amplifier = effect.getAmplifier();
        int duration = effect.getDuration();
        PotionEffectType type = effect.getType();
        boolean ambient = effect.isAmbient();
        boolean icon = effect.hasIcon();
        boolean particles = effect.hasParticles();
        return new LegacyPotionEffectWrapper(amplifier, duration, type.getId(), ambient, particles, icon);

    }

    /**
     * Constructs a new {@link PotionEffect} based on wrapper values.
     *
     * @return new {@link PotionEffect} instance
     */
    public PotionEffect toBukkitPotionEffect() {
        return new PotionEffect(PotionEffectType.getById(type()), duration, amplifier, ambient, particles, icon);
    }
}
