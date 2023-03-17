package de.eldoria.jacksonbukkit.serializer;

import be.seeseemelk.mockbukkit.MockBukkit;
import be.seeseemelk.mockbukkit.ServerMock;
import be.seeseemelk.mockbukkit.entity.PlayerMock;
import com.fasterxml.jackson.core.JsonProcessingException;
import de.eldoria.jacksonbukkit.TestUtil;
import de.eldoria.jacksonbukkit.templates.PatternTemplate;
import org.bukkit.OfflinePlayer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

class PlayerSerializerTest implements TestUtil {
    static OfflinePlayer SINGLE;
    static List<OfflinePlayer> LIST = new ArrayList<>();

    @BeforeAll
    static void setup() {
        ServerMock mock = MockBukkit.mock();
        PlayerMock player1 = new PlayerMock(mock, "Player1", new UUID(0, 1));
        PlayerMock player2 = new PlayerMock(mock, "Player2", new UUID(0, 2));
        PlayerMock player3 = new PlayerMock(mock, "Player3", new UUID(0, 3));
        mock.addPlayer(player1);
        mock.addPlayer(player2);
        mock.addPlayer(player3);
        SINGLE = player1;
        LIST.add(player1);
        LIST.add(player2);
        LIST.add(player3);
    }

    @Test
    void serializeToJson() throws JsonProcessingException {
        Assertions.assertEquals(json("player"), toJson(SINGLE));
        Assertions.assertEquals(json("player_list"), toJson(LIST));
    }

    @Test
    void serializeToYaml() throws JsonProcessingException {
        Assertions.assertEquals(yaml("player"), toYaml(SINGLE));
        Assertions.assertEquals(yaml("player_list"), toYaml(LIST));
    }

    @Test
    @Disabled
    // Does not work since this is nothing toml supports
    void serializeToToml() throws JsonProcessingException {
        Assertions.assertEquals(toml("player"), toToml(SINGLE));
    }

    @AfterAll
    static void tearDown() {
        MockBukkit.unmock();
    }
}
