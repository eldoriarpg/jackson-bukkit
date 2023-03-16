package de.eldoria.jacksonbukkit.entities;

public record BoundingBox(VectorWrapper corner1, VectorWrapper corner2) {

    public static BoundingBox of(org.bukkit.util.BoundingBox boundingBox){
        return new BoundingBox(
                VectorWrapper.of(boundingBox.getMin()),
                VectorWrapper.of(boundingBox.getMax())
        );
    }

    public org.bukkit.util.BoundingBox toBukkitBoundingBox(){
        return org.bukkit.util.BoundingBox.of(
          corner1.toBukkitVector(),
          corner2.toBukkitVector()
        );
    }

}
