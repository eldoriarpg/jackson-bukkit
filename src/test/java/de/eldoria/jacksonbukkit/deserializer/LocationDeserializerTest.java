/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.eldoria.jacksonbukkit.SerializationTest;
import de.eldoria.jacksonbukkit.templates.LocationTemplate;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.World;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.UUID;
import java.util.logging.Logger;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LocationDeserializerTest implements SerializationTest {

    static Server server;
    static UUID worldUID = new UUID(0, 0);
    static World world;

    @BeforeAll
    static void setup() {
        server = mock(Server.class);
        world = mock(World.class);
        when(world.getUID()).thenReturn(worldUID);
        when(world.getName()).thenReturn("world");
        when(server.getWorld(worldUID)).thenReturn(world);
        when(server.getWorld("world")).thenReturn(world);
        when(server.getLogger()).thenReturn(Logger.getGlobal());
        Bukkit.setServer(server);
    }

    @AfterAll
    static void tearDown() throws NoSuchFieldException, IllegalAccessException {
        Field field = Bukkit.class.getDeclaredField("server");
        field.setAccessible(true);
        field.set(null, null);
    }

    @Test
    void deserializeToJson() throws JsonProcessingException {
        assertEqualsIgnoring(LocationTemplate.SINGLE, fromJson("location", Location.class));
        assertEqualsIgnoring(LocationTemplate.LIST, fromJsonList("location_list", Location.class));
    }

    @Test
    void deserializeToYaml() throws JsonProcessingException {
        assertEqualsIgnoring(LocationTemplate.SINGLE, fromYaml("location", Location.class));
        assertEqualsIgnoring(LocationTemplate.LIST, fromYamlList("location_list", Location.class));
    }

    @Test
    void deserializeToToml() throws JsonProcessingException {
        assertEqualsIgnoring(LocationTemplate.SINGLE, fromToml("location", Location.class));
    }

    @Test
    void deserializeUidOnly() throws JsonProcessingException {
        assertEqualsIgnoring(LocationTemplate.SINGLE, fromJson("location_only_uid", Location.class));
    }

    @Test
    void deserializeNameOnly() throws JsonProcessingException {
        assertEqualsIgnoring(LocationTemplate.SINGLE, fromJson("location_only_name", Location.class));
    }
}
