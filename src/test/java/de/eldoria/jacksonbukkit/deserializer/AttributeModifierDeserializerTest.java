package de.eldoria.jacksonbukkit.deserializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.eldoria.jacksonbukkit.TestUtil;
import org.bukkit.attribute.AttributeModifier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static de.eldoria.jacksonbukkit.templates.AttributeModifierTemplate.LIST;
import static de.eldoria.jacksonbukkit.templates.AttributeModifierTemplate.SINGLE;

class AttributeModifierDeserializerTest implements TestUtil {

    @Test
    void deserializeFromJson() throws JsonProcessingException {
        Assertions.assertEquals(SINGLE, fromJson("attribute_modifier", AttributeModifier.class));
        Assertions.assertEquals(LIST, fromJsonList("attribute_modifier_list", AttributeModifier.class));
    }
    @Test
    void deserializeFromYaml() throws JsonProcessingException {
        Assertions.assertEquals(SINGLE, fromYaml("attribute_modifier", AttributeModifier.class));
        Assertions.assertEquals(LIST, fromYamlList("attribute_modifier_list", AttributeModifier.class));
    }
    @Test
    void deserializeFromToml() throws JsonProcessingException {
        Assertions.assertEquals(SINGLE, fromToml("attribute_modifier", AttributeModifier.class));
    }

}
