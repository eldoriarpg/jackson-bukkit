package de.eldoria.jacksonbukkit.entities;

import org.bukkit.util.BlockVector;

public record Vector(double x, double y, double z) {
    public org.bukkit.util.Vector toBukkitVector() {
        return new org.bukkit.util.Vector(x, y, z);
    }

    public BlockVector toBukkitBlockVector() {
        return new BlockVector(x, y, z);
    }

    public Vector of(org.bukkit.util.Vector vector) {
        return new Vector(vector.getX(), vector.getY(), vector.getZ());
    }
}
