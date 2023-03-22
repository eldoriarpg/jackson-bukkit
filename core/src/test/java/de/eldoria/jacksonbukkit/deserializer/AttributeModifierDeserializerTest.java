/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.eldoria.jacksonbukkit.CoreSerializationTest;
import de.eldoria.jacksonbukkit.templates.AttributeModifierTemplate;
import org.bukkit.attribute.AttributeModifier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static de.eldoria.jacksonbukkit.templates.AttributeModifierTemplate.LIST;
import static de.eldoria.jacksonbukkit.templates.AttributeModifierTemplate.SINGLE;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AttributeModifierDeserializerTest implements CoreSerializationTest {

    @Test
    void deserializeFromJson() throws JsonProcessingException {
        Assertions.assertEquals(AttributeModifierTemplate.SINGLE, fromJson("attribute_modifier", AttributeModifier.class));
        Assertions.assertEquals(AttributeModifierTemplate.LIST, fromJsonList("attribute_modifier_list", AttributeModifier.class));
    }

    @Test
    void deserializeFromYaml() throws JsonProcessingException {
        Assertions.assertEquals(AttributeModifierTemplate.SINGLE, fromYaml("attribute_modifier", AttributeModifier.class));
        Assertions.assertEquals(AttributeModifierTemplate.LIST, fromYamlList("attribute_modifier_list", AttributeModifier.class));
    }

    @Test
    void deserializeFromToml() throws JsonProcessingException {
        Assertions.assertEquals(AttributeModifierTemplate.SINGLE, fromToml("attribute_modifier", AttributeModifier.class));
    }

}
