/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.eldoria.jacksonbukkit.SerializationTest;
import org.junit.jupiter.api.Test;

import static de.eldoria.jacksonbukkit.templates.AttributeModifierTemplate.LIST;
import static de.eldoria.jacksonbukkit.templates.AttributeModifierTemplate.SINGLE;
import static org.junit.jupiter.api.Assertions.assertEquals;


class AttributeModifierSerializerTest implements SerializationTest {


    @Test
    void serializeToJson() throws JsonProcessingException {
        assertEquals(json("attribute_modifier"), toJson(SINGLE));
        assertEquals(json("attribute_modifier_list"), toJson(LIST));
    }

    @Test
    void serializeToYaml() throws JsonProcessingException {
        assertEquals(yaml("attribute_modifier"), toYaml(SINGLE));
        assertEquals(yaml("attribute_modifier_list"), toYaml(LIST));
    }

    @Test
    void serializeToToml() throws JsonProcessingException {
        assertEquals(toml("attribute_modifier"), toToml(SINGLE));
    }
}
