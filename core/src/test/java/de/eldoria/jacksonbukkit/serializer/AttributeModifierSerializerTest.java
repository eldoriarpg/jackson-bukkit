/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import de.eldoria.jacksonbukkit.CoreSerializationTest;
import de.eldoria.jacksonbukkit.templates.AttributeModifierTemplate;
import org.junit.jupiter.api.Test;
import tools.jackson.core.JacksonException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AttributeModifierSerializerTest implements CoreSerializationTest {

    @Test
    void serializeToJson() throws JacksonException {
        assertEquals(json("attribute_modifier"), toJson(AttributeModifierTemplate.SINGLE));
        assertEquals(json("attribute_modifier_list"), toJson(AttributeModifierTemplate.LIST));
    }

    @Test
    void serializeToYaml() throws JacksonException {
        assertEquals(yaml("attribute_modifier"), toYaml(AttributeModifierTemplate.SINGLE));
        assertEquals(yaml("attribute_modifier_list"), toYaml(AttributeModifierTemplate.LIST));
    }

    @Test
    void serializeToToml() throws JacksonException {
        assertEquals(toml("attribute_modifier"), toToml(AttributeModifierTemplate.SINGLE));
    }
}
