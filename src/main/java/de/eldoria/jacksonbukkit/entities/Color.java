package de.eldoria.jacksonbukkit.entities;

public record Color(int red, int green, int blue, int alpha) {

    public org.bukkit.Color toBukkitColor() {
        return org.bukkit.Color.fromARGB(alpha, red, green, blue);
    }

    public static Color of(org.bukkit.Color color) {
        return new Color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
    }
}
