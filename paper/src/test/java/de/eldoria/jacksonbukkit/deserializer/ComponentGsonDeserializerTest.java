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
import de.eldoria.jacksonbukkit.serializer.ComponentGsonSerializer;
import de.eldoria.jacksonbukkit.serializer.NamespacedKeySerializer;
import de.eldoria.jacksonbukkit.templates.ComponentTemplate;
import net.kyori.adventure.text.Component;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ComponentGsonDeserializerTest implements PaperSerializationTest {

    @Override
    public JacksonModule buildModule() {
        return new JacksonPaper(false,
                false,
                new ComponentGsonDeserializer(),
                new ComponentGsonSerializer(),
                NamespacedKeySerializer.Format.OBJECT);
    }

    @Test
    void deserializeToJson() throws JacksonException {
        assertEquals(ComponentTemplate.SINGLE, fromJson("gson_component", Component.class));
        assertEquals(ComponentTemplate.LIST, fromJsonList("gson_component_list", Component.class));
    }

    @Test
    void deserializeToYaml() throws JacksonException {
        assertEquals(ComponentTemplate.SINGLE, fromYaml("gson_component", Component.class));
        assertEquals(ComponentTemplate.LIST, fromYamlList("gson_component_list", Component.class));
    }

    @Test
    void deserializeToToml() throws JacksonException {
        assertEquals(ComponentTemplate.SINGLE, fromToml("gson_component", Component.class));
    }
}
