/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import tools.jackson.core.JacksonException;
import de.eldoria.jacksonbukkit.CoreSerializationTest;
import de.eldoria.jacksonbukkit.templates.AttributeModifierTemplate;
import org.bukkit.attribute.AttributeModifier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static de.eldoria.jacksonbukkit.templates.AttributeModifierTemplate.LIST;
import static de.eldoria.jacksonbukkit.templates.AttributeModifierTemplate.SINGLE;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AttributeModifierDeserializerTest implements CoreSerializationTest {

    @Test
    void deserializeFromJson() throws JacksonException {
        assertEquals(AttributeModifierTemplate.SINGLE, fromJson("attribute_modifier", AttributeModifier.class));
        assertEquals(AttributeModifierTemplate.LIST, fromJsonList("attribute_modifier_list", AttributeModifier.class));
    }

    @Test
    void deserializeFromYaml() throws JacksonException {
        assertEquals(AttributeModifierTemplate.SINGLE, fromYaml("attribute_modifier", AttributeModifier.class));
        assertEquals(AttributeModifierTemplate.LIST, fromYamlList("attribute_modifier_list", AttributeModifier.class));
    }

    @Test
    void deserializeFromToml() throws JacksonException {
        assertEquals(AttributeModifierTemplate.SINGLE, fromToml("attribute_modifier", AttributeModifier.class));
    }

}
