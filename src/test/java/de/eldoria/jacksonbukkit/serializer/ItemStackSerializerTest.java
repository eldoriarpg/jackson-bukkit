package de.eldoria.jacksonbukkit.serializer;

import be.seeseemelk.mockbukkit.MockBukkit;
import com.fasterxml.jackson.core.JsonProcessingException;
import de.eldoria.jacksonbukkit.TestUtil;
import de.eldoria.jacksonbukkit.templates.ItemStackTemplate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled
class ItemStackSerializerTest implements TestUtil {
    // Mockbukkit does not support serialization to bytes
    @BeforeAll
    static void setup() {
        MockBukkit.mock();
    }

    @Test
    void serializeToJson() throws JsonProcessingException {
        Assertions.assertEquals(json("item_stack"), toJson(ItemStackTemplate.SINGLE));
        Assertions.assertEquals(json("item_stack_list"), toJson(ItemStackTemplate.LIST));
    }

    @Test
    void serializeToYaml() throws JsonProcessingException {
        Assertions.assertEquals(yaml("item_stack"), toYaml(ItemStackTemplate.SINGLE));
        Assertions.assertEquals(yaml("item_stack_list"), toYaml(ItemStackTemplate.LIST));
    }

    @Test
    void serializeToToml() throws JsonProcessingException {
        Assertions.assertEquals(toml("item_stack"), toToml(ItemStackTemplate.SINGLE));
    }
}
