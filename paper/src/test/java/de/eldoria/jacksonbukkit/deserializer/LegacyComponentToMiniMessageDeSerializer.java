/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.Module;
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
    public Module buildModule() {
        return JacksonPaper.builder().build();
    }

    @Test
    void deserializeToJson() throws JsonProcessingException {
        assertEquals(miniMessage.serialize(ComponentTemplate.SINGLE), miniMessage.serialize(fromJson("gson_component", Component.class)));
        assertEquals(ComponentTemplate.LIST.stream().map(miniMessage::serialize).toList(), fromJsonList("gson_component_list", Component.class).stream().map(miniMessage::serialize).toList());
    }

    @Test
    void deserializeToYaml() throws JsonProcessingException {
        assertEquals(miniMessage.serialize(ComponentTemplate.SINGLE), miniMessage.serialize(fromYaml("gson_component", Component.class)));
        assertEquals(ComponentTemplate.LIST.stream().map(miniMessage::serialize).toList(), fromYamlList("gson_component_list", Component.class).stream().map(miniMessage::serialize).toList());
    }

    @Test
    void deserializeToToml() throws JsonProcessingException {
        assertEquals(ComponentTemplate.SINGLE, fromToml("gson_component", Component.class));
    }
}
