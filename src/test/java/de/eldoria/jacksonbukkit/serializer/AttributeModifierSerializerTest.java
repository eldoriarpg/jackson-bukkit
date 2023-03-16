package de.eldoria.jacksonbukkit.serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.eldoria.jacksonbukkit.TestUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static de.eldoria.jacksonbukkit.templates.AttributeModifierTemplate.LIST;
import static de.eldoria.jacksonbukkit.templates.AttributeModifierTemplate.SINGLE;


class AttributeModifierSerializerTest implements TestUtil {


    @Test
    void serializeToJson() throws JsonProcessingException {
        Assertions.assertEquals(json("attribute_modifier"), toJson(SINGLE));
        Assertions.assertEquals(json("attribute_modifier_list"), toJson(LIST));
    }
    @Test
    void serializeToYaml() throws JsonProcessingException {
        Assertions.assertEquals(yaml("attribute_modifier"), toYaml(SINGLE));
        Assertions.assertEquals(yaml("attribute_modifier_list"), toYaml(LIST));
    }
    @Test
    void serializeToToml() throws JsonProcessingException {
        Assertions.assertEquals(toml("attribute_modifier"), toToml(SINGLE));
    }

}
