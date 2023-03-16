package de.eldoria.jacksonbukkit.entities;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;

public record ColorWrapper(int red, int green, int blue, int alpha) implements Comparable<ColorWrapper> {

    public org.bukkit.Color toBukkitColor() {
        return org.bukkit.Color.fromARGB(alpha, red, green, blue);
    }

    public static ColorWrapper of(org.bukkit.Color color) {
        return new ColorWrapper(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
    }

    @Override
    public int compareTo(@NotNull ColorWrapper o) {
        return Comparator
                .comparing(ColorWrapper::red)
                .thenComparing(ColorWrapper::green)
                .thenComparing(ColorWrapper::blue)
                .thenComparing(ColorWrapper::alpha)
                .compare(this, o);
    }
}
