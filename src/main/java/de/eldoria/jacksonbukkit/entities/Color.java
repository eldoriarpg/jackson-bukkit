package de.eldoria.jacksonbukkit.entities;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;

public record Color(int red, int green, int blue, int alpha) implements Comparable<Color> {

    public org.bukkit.Color toBukkitColor() {
        return org.bukkit.Color.fromARGB(alpha, red, green, blue);
    }

    public static Color of(org.bukkit.Color color) {
        return new Color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
    }

    @Override
    public int compareTo(@NotNull Color o) {
        return Comparator
                .comparing(Color::red)
                .thenComparing(Color::green)
                .thenComparing(Color::blue)
                .thenComparing(Color::alpha)
                .compare(this, o);
    }
}
