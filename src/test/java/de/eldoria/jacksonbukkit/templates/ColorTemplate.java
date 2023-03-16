package de.eldoria.jacksonbukkit.templates;

import org.bukkit.Color;

import java.util.List;

public class ColorTemplate {
    public static final Color SINGLE = Color.fromARGB(
            255, 255, 60, 0
    );
    public static final List<Color> LIST = List.of(
            Color.fromARGB(255, 255, 60, 0),
            Color.fromARGB(215, 20, 200, 70)
    );

}
