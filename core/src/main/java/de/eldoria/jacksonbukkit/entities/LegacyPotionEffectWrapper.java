/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 * Class for wrapping a {@link PotionEffect}.
 * <p>
 * This class is used to handle PotionEffects prior to 1.16 where the number id was replaced by a {@link org.bukkit.NamespacedKey}.
 */
public final class LegacyPotionEffectWrapper extends BasePotionEffectWrapper<Integer> {

    /**
     * @param amplifier the amplifier, see {@link PotionEffect#getAmplifier()}
     * @param duration  measured in ticks, see {@link PotionEffect#getDuration()}
     * @param type      effect type as id as defined in {@link PotionEffectType#getId()}
     * @param ambient   the ambient status, see {@link PotionEffect#isAmbient()}
     * @param particles the particle status, see {@link PotionEffect#hasParticles()}
     * @param icon      the icon status, see {@link PotionEffect#hasIcon()}
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
