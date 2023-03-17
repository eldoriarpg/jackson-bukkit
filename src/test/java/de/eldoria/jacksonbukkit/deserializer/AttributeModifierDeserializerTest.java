/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.eldoria.jacksonbukkit.SerializationTest;
import org.bukkit.attribute.AttributeModifier;
import org.junit.jupiter.api.Test;

import static de.eldoria.jacksonbukkit.templates.AttributeModifierTemplate.LIST;
import static de.eldoria.jacksonbukkit.templates.AttributeModifierTemplate.SINGLE;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AttributeModifierDeserializerTest implements SerializationTest {

    @Test
    void deserializeFromJson() throws JsonProcessingException {
        assertEquals(SINGLE, fromJson("attribute_modifier", AttributeModifier.class));
        assertEquals(LIST, fromJsonList("attribute_modifier_list", AttributeModifier.class));
    }

    @Test
    void deserializeFromYaml() throws JsonProcessingException {
        assertEquals(SINGLE, fromYaml("attribute_modifier", AttributeModifier.class));
        assertEquals(LIST, fromYamlList("attribute_modifier_list", AttributeModifier.class));
    }

    @Test
    void deserializeFromToml() throws JsonProcessingException {
        assertEquals(SINGLE, fromToml("attribute_modifier", AttributeModifier.class));
    }

}
