/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import tools.jackson.core.JacksonException;
import tools.jackson.databind.JacksonModule;
import de.eldoria.jacksonbukkit.JacksonPaper;
import de.eldoria.jacksonbukkit.PaperSerializationTest;
import de.eldoria.jacksonbukkit.deserializer.ComponentGsonDeserializer;
import de.eldoria.jacksonbukkit.templates.ComponentTemplate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ComponentGsonSerializerTest implements PaperSerializationTest {

    @Override
    public JacksonModule buildModule() {
        return new JacksonPaper(false,
                false,
                new ComponentGsonDeserializer(),
                new ComponentGsonSerializer(),
                NamespacedKeySerializer.Format.OBJECT);
    }

    @Test
    void serializeToJson() throws JacksonException {
        assertEquals(json("gson_component"), toJson(ComponentTemplate.SINGLE));
        assertEquals(json("gson_component_list"), toJson(ComponentTemplate.LIST));
    }

    @Test
    void serializeToYaml() throws JacksonException {
        assertEquals(yaml("gson_component"), toYaml(ComponentTemplate.SINGLE));
        assertEquals(yaml("gson_component_list"), toYaml(ComponentTemplate.LIST));
    }

    @Test
    void serializeToToml() throws JacksonException {
        assertEquals(toml("gson_component"), toToml(ComponentTemplate.SINGLE));
        assertEquals(toml("gson_component_list"), toToml(ComponentTemplate.LIST));
    }

}
