/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import tools.jackson.core.JacksonException;
import tools.jackson.databind.JacksonModule;
import de.eldoria.jacksonbukkit.JacksonPaper;
import de.eldoria.jacksonbukkit.PaperSerializationTest;
import de.eldoria.jacksonbukkit.templates.ComponentTemplate;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ComponentDeserializerTest implements PaperSerializationTest {
    MiniMessage miniMessage = MiniMessage.miniMessage();

    @Override
    public JacksonModule buildModule() {
        return JacksonPaper.builder().build();
    }

    @Test
    void deserializeToJson() throws JacksonException {
        assertEquals(miniMessage.serialize(ComponentTemplate.SINGLE), miniMessage.serialize(fromJson("component", Component.class)));
        assertEquals(ComponentTemplate.LIST.stream().map(miniMessage::serialize).toList(), fromJsonList("component_list", Component.class).stream().map(miniMessage::serialize).toList());
    }

    @Test
    void deserializeToYaml() throws JacksonException {
        assertEquals(miniMessage.serialize(ComponentTemplate.SINGLE), miniMessage.serialize(fromYaml("component", Component.class)));
        assertEquals(ComponentTemplate.LIST.stream().map(miniMessage::serialize).toList(), fromYamlList("component_list", Component.class).stream().map(miniMessage::serialize).toList());
    }

    // toml can't c:
    @Test
    @Disabled
    void deserializeToToml() throws JacksonException {
        assertEquals(ComponentTemplate.SINGLE, fromToml("component", Component.class));
    }

}
