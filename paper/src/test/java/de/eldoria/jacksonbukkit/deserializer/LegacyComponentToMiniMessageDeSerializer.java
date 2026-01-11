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
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LegacyComponentToMiniMessageDeSerializer implements PaperSerializationTest {

    MiniMessage miniMessage = MiniMessage.miniMessage();

    @Override
    public JacksonModule buildModule() {
        return JacksonPaper.builder().build();
    }

    @Test
    void deserializeToJson() throws JacksonException {
        assertEquals(miniMessage.serialize(ComponentTemplate.SINGLE), miniMessage.serialize(fromJson("gson_component", Component.class)));
        assertEquals(ComponentTemplate.LIST.stream().map(miniMessage::serialize).toList(), fromJsonList("gson_component_list", Component.class).stream().map(miniMessage::serialize).toList());
    }

    @Test
    void deserializeToYaml() throws JacksonException {
        assertEquals(miniMessage.serialize(ComponentTemplate.SINGLE), miniMessage.serialize(fromYaml("gson_component", Component.class)));
        assertEquals(ComponentTemplate.LIST.stream().map(miniMessage::serialize).toList(), fromYamlList("gson_component_list", Component.class).stream().map(miniMessage::serialize).toList());
    }

    @Test
    void deserializeToToml() throws JacksonException {
        assertEquals(ComponentTemplate.SINGLE, fromToml("gson_component", Component.class));
    }
}
