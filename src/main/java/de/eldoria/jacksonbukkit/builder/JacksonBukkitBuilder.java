package de.eldoria.jacksonbukkit.builder;

import de.eldoria.jacksonbukkit.JacksonBukkit;

public class JacksonBukkitBuilder extends ModuleBuilder<JacksonBukkitBuilder, JacksonBukkit> {
    @Override
    public JacksonBukkit build() {
        return new JacksonBukkit(hexColors);
    }
}