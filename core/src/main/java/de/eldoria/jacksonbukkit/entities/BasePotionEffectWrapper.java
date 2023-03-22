/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"amplifier", "duration", "type", "ambient", "particles", "icon"})
public class BasePotionEffectWrapper<T> {
    protected final int amplifier;
    protected final int duration;
    protected final T type;
    protected final boolean ambient;
    protected final boolean particles;
    protected final boolean icon;
    public BasePotionEffectWrapper(int amplifier, int duration, T type, boolean ambient, boolean particles, boolean icon) {
        this.amplifier = amplifier;
        this.duration = duration;
        this.type = type;
        this.ambient = ambient;
        this.particles = particles;
        this.icon = icon;
    }
    @JsonProperty
    public int amplifier() {
        return amplifier;
    }

    @JsonProperty
    public int duration() {
        return duration;
    }

    @JsonProperty
    public T type() {
        return type;
    }

    @JsonProperty
    public boolean ambient() {
        return ambient;
    }

    @JsonProperty
    public boolean particles() {
        return particles;
    }

    @JsonProperty
    public boolean icon() {
        return icon;
    }
}
