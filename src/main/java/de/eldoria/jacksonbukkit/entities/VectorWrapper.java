package de.eldoria.jacksonbukkit.entities;

import org.bukkit.util.BlockVector;

public record VectorWrapper(double xCoord, double yCoord, double zCoord) {
    public org.bukkit.util.Vector toBukkitVector() {
        return new org.bukkit.util.Vector(xCoord, yCoord, zCoord);
    }

    public BlockVector toBukkitBlockVector() {
        return new BlockVector(xCoord, yCoord, zCoord);
    }

    public static VectorWrapper of(org.bukkit.util.Vector vector) {
        return new VectorWrapper(vector.getX(), vector.getY(), vector.getZ());
    }
}
