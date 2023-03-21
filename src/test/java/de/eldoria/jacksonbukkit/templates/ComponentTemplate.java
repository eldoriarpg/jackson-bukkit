package de.eldoria.jacksonbukkit.templates;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.Style;
import net.kyori.adventure.text.format.TextDecoration;

import java.util.List;

public class ComponentTemplate {
    public static final Component SINGLE = Component.text("Awesome")
            .appendSpace()
            .append(Component.text("text")
                    .style(Style.style()
                            .decorate(TextDecoration.BOLD)
                            .color(NamedTextColor.AQUA)));

    public static final List<Component> LIST = List.of(
            Component.text("Another")
            .appendSpace()
            .append(Component.text("truly")
                    .style(Style.style()
                            .decorate(TextDecoration.BOLD)
                            .color(NamedTextColor.AQUA)))
                    .append(Component.text("awesome").style(Style.style(NamedTextColor.RED)))
                    .append(Component.text("text")),
            SINGLE
    );
}
