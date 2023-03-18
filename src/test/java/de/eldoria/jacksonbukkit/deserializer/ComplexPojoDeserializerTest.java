/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import be.seeseemelk.mockbukkit.MockBukkit;
import be.seeseemelk.mockbukkit.WorldMock;
import com.fasterxml.jackson.core.JsonProcessingException;
import de.eldoria.jacksonbukkit.SerializationTest;
import de.eldoria.jacksonbukkit.templates.ComplexPojoTemplate;
import org.bukkit.World;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ComplexPojoDeserializerTest implements SerializationTest {
    static UUID worldUID = new UUID(0, 0);

    @BeforeAll
    static void setup() {
        var serverMock = MockBukkit.mock();
        var world = spy(new WorldMock());
        world.setName("world");
        when(world.getUID()).thenReturn(worldUID);
        serverMock.addWorld(world);
    }

    @AfterAll
    static void tearDown() {
        MockBukkit.unmock();
    }

    @Test
    void deserializeFromJson() throws JsonProcessingException {
        assertEquals(ComplexPojoTemplate.SINGLE, fromJson("complex_pojo", ComplexPojoTemplate.ComplexPojo.class));
    }

    @Test
    void deserializeFromYaml() throws JsonProcessingException {
        assertEquals(ComplexPojoTemplate.SINGLE, fromYaml("complex_pojo", ComplexPojoTemplate.ComplexPojo.class));
    }

    @Test
    void deserializeFromToml() throws JsonProcessingException {
        assertEquals(ComplexPojoTemplate.SINGLE, fromToml("complex_pojo", ComplexPojoTemplate.ComplexPojo.class));
    }
}
