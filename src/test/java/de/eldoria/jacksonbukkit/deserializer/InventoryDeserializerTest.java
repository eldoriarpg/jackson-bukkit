package de.eldoria.jacksonbukkit.deserializer;

import be.seeseemelk.mockbukkit.MockBukkit;
import com.fasterxml.jackson.core.JsonProcessingException;
import de.eldoria.jacksonbukkit.TestUtil;
import de.eldoria.jacksonbukkit.entities.InventoryWrapper;
import de.eldoria.jacksonbukkit.templates.InventoryWrapperTemplate;
import org.junit.jupiter.api.*;

@Disabled
class InventoryDeserializerTest implements TestUtil {


    @BeforeAll
    static void setup() {
        MockBukkit.mock();
    }

    @Test
    void deserializeToJson() throws JsonProcessingException {
        var wrapper = fromJson("inventory", InventoryWrapper.class);
        Assertions.assertEquals(InventoryWrapperTemplate.SINGLE.getType(), wrapper.inventoryType());
        Assertions.assertEquals(InventoryWrapperTemplate.SINGLE.getContents(), wrapper.contents());
    }

    @Test
    void deserializeToYaml() throws JsonProcessingException {
        var wrapper = fromYaml("inventory", InventoryWrapper.class);
        Assertions.assertEquals(InventoryWrapperTemplate.SINGLE.getType(), wrapper.inventoryType());
        Assertions.assertEquals(InventoryWrapperTemplate.SINGLE.getContents(), wrapper.contents());
    }

    @Test
    void deserializeToToml() throws JsonProcessingException {
        var wrapper = fromToml("inventory", InventoryWrapper.class);
        Assertions.assertEquals(InventoryWrapperTemplate.SINGLE.getType(), wrapper.inventoryType());
        Assertions.assertEquals(InventoryWrapperTemplate.SINGLE.getContents(), wrapper.contents());
    }

    @AfterAll
    static void tearDown(){
        MockBukkit.unmock();
    }
}
