/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.eldoria.jacksonbukkit.CoreSerializationTest;
import de.eldoria.jacksonbukkit.templates.AttributeModifierTemplate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static de.eldoria.jacksonbukkit.templates.AttributeModifierTemplate.LIST;
import static de.eldoria.jacksonbukkit.templates.AttributeModifierTemplate.SINGLE;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


class AttributeModifierSerializerTest implements CoreSerializationTest {


    @Test
    void serializeToJson() throws JsonProcessingException {
        assertEquals(json("attribute_modifier"), toJson(AttributeModifierTemplate.SINGLE));
        assertEquals(json("attribute_modifier_list"), toJson(AttributeModifierTemplate.LIST));
    }

    @Test
    void serializeToYaml() throws JsonProcessingException {
        assertEquals(yaml("attribute_modifier"), toYaml(AttributeModifierTemplate.SINGLE));
        assertEquals(yaml("attribute_modifier_list"), toYaml(AttributeModifierTemplate.LIST));
    }

    @Test
    void serializeToToml() throws JsonProcessingException {
        assertEquals(toml("attribute_modifier"), toToml(AttributeModifierTemplate.SINGLE));
    }
}
