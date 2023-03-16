package de.eldoria.jacksonbukkit.entities;

import org.bukkit.DyeColor;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;

public record PatternWrapper(DyeColor color, PatternType pattern) {
    public Pattern toPattern(){
        return new Pattern(color, pattern);
    }
}
