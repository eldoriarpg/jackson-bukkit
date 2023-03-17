package de.eldoria.jacksonbukkit.serializer;

import be.seeseemelk.mockbukkit.MockBukkit;
import com.fasterxml.jackson.core.JsonProcessingException;
import de.eldoria.jacksonbukkit.TestUtil;
import de.eldoria.jacksonbukkit.templates.InventoryWrapperTemplate;
import org.junit.jupiter.api.*;

@Disabled
class InventorySerializerTest implements TestUtil {


    // Mockbukkit does not support serialization to bytes
    @BeforeAll
    static void setup() {
        MockBukkit.mock();
    }

    @Test
    void serializeToJson() throws JsonProcessingException {
        Assertions.assertEquals(json("inventory"), toJson(InventoryWrapperTemplate.SINGLE));
    }

    @Test
    void serializeToYaml() throws JsonProcessingException {
        Assertions.assertEquals(yaml("inventory"), toYaml(InventoryWrapperTemplate.SINGLE));
    }

    @Test
    void serializeToToml() throws JsonProcessingException {
        Assertions.assertEquals(toml("inventory"), toToml(InventoryWrapperTemplate.SINGLE));
    }

    @AfterAll
    static void tearDown(){
        MockBukkit.unmock();
    }

}
