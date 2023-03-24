/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.Module;
import de.eldoria.jacksonbukkit.JacksonPaper;
import de.eldoria.jacksonbukkit.PaperSerializationTest;
import de.eldoria.jacksonbukkit.deserializer.ComponentGsonDeserializer;
import de.eldoria.jacksonbukkit.templates.ComponentTemplate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ComponentGsonSerializerTest implements PaperSerializationTest {

    @Override
    public Module buildModule() {
        return new JacksonPaper(false,
                false,
                new ComponentGsonDeserializer(),
                new ComponentGsonSerializer());
    }

    @Test
    void serializeToJson() throws JsonProcessingException {
        assertEquals(json("gson_component"), toJson(ComponentTemplate.SINGLE));
        assertEquals(json("gson_component_list"), toJson(ComponentTemplate.LIST));
    }

    @Test
    void serializeToYaml() throws JsonProcessingException {
        assertEquals(yaml("gson_component"), toYaml(ComponentTemplate.SINGLE));
        assertEquals(yaml("gson_component_list"), toYaml(ComponentTemplate.LIST));
    }

    @Test
    void serializeToToml() throws JsonProcessingException {
        assertEquals(toml("gson_component"), toToml(ComponentTemplate.SINGLE));
        assertEquals(toml("gson_component_list"), toToml(ComponentTemplate.LIST));
    }

}
