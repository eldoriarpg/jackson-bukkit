/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import be.seeseemelk.mockbukkit.MockBukkit;
import be.seeseemelk.mockbukkit.WorldMock;
import de.eldoria.jacksonbukkit.JacksonPaper;
import de.eldoria.jacksonbukkit.PaperSerializationTest;
import de.eldoria.jacksonbukkit.templates.ComplexPojoTemplate;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import tools.jackson.core.JacksonException;
import tools.jackson.databind.JacksonModule;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

public class ComplexPojoDeserializerTest implements PaperSerializationTest {
    static UUID worldUID = new UUID(0, 0);

    @Override
    public JacksonModule buildModule() {
        return JacksonPaper.builder().build();
    }

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
    void deserializeFromJson() throws JacksonException {
        assertEquals(ComplexPojoTemplate.SINGLE, fromJson("complex_pojo", ComplexPojoTemplate.ComplexPojo.class));
    }

    @Test
    void deserializeFromYaml() throws JacksonException {
        assertEquals(ComplexPojoTemplate.SINGLE, fromYaml("complex_pojo", ComplexPojoTemplate.ComplexPojo.class));
    }

    @Test
    void deserializeFromToml() throws JacksonException {
        assertEquals(ComplexPojoTemplate.SINGLE, fromToml("complex_pojo", ComplexPojoTemplate.ComplexPojo.class));
    }
}
