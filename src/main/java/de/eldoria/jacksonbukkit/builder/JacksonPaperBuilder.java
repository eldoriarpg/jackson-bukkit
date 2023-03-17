package de.eldoria.jacksonbukkit.builder;

import de.eldoria.jacksonbukkit.JacksonBukkit;
import de.eldoria.jacksonbukkit.JacksonPaper;

public class JacksonPaperBuilder extends ModuleBuilder<JacksonPaperBuilder, JacksonBukkit> {
    @Override
    public JacksonBukkit build() {
        return new JacksonPaper(hexColors);
    }
}
