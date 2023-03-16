package de.eldoria.jacksonbukkit.entities;

import org.bukkit.NamespacedKey;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public record PotionEffectWrapper(int amplifier, int duration, NamespacedKey type, boolean ambient, boolean particles,
                                  boolean icon) {
    public PotionEffect toPotionEffect(){
        return new PotionEffect(PotionEffectType.getByKey(type), duration, amplifier, ambient, particles, icon);
    }
}
