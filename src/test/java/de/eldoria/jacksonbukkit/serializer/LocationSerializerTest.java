package de.eldoria.jacksonbukkit.serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.eldoria.jacksonbukkit.TestUtil;
import de.eldoria.jacksonbukkit.templates.LocationTemplate;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.World;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.UUID;
import java.util.logging.Logger;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class LocationSerializerTest implements TestUtil {
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

    @Test
    void serializeToJson() throws JsonProcessingException {
        Assertions.assertEquals(json("location"), toJson(LocationTemplate.SINGLE));
        Assertions.assertEquals(json("location_list"), toJson(LocationTemplate.LIST));
    }

    @Test
    void serializeToYaml() throws JsonProcessingException {
        Assertions.assertEquals(yaml("location"), toYaml(LocationTemplate.SINGLE));
        Assertions.assertEquals(yaml("location_list"), toYaml(LocationTemplate.LIST));
    }

    @Test
    void serializeToToml() throws JsonProcessingException {
        Assertions.assertEquals(toml("location"), toToml(LocationTemplate.SINGLE));
    }

    @AfterAll
    static void tearDown() throws NoSuchFieldException, IllegalAccessException {
        Field field = Bukkit.class.getDeclaredField("server");
        field.setAccessible(true);
        field.set(null, null);
    }
}
