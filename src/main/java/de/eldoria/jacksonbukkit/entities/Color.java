package de.eldoria.jacksonbukkit.entities;

public record Color(int r, int g, int b, int a) {

    public org.bukkit.Color toBukkitColor() {
        return org.bukkit.Color.fromARGB(a, r, g, b);
    }

    public static Color of(org.bukkit.Color color) {
        return new Color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
    }
}
