/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import be.seeseemelk.mockbukkit.MockBukkit;
import be.seeseemelk.mockbukkit.ServerMock;
import be.seeseemelk.mockbukkit.entity.PlayerMock;
import com.fasterxml.jackson.core.JsonProcessingException;
import de.eldoria.jacksonbukkit.CoreSerializationTest;
import org.bukkit.OfflinePlayer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerSerializerTest implements CoreSerializationTest {
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

    @AfterAll
    static void tearDown() {
        MockBukkit.unmock();
    }

    @Test
    void serializeToJson() throws JsonProcessingException {
        assertEquals(json("player"), toJson(SINGLE));
        assertEquals(json("player_list"), toJson(LIST));
    }

    @Test
    void serializeToYaml() throws JsonProcessingException {
        assertEquals(yaml("player"), toYaml(SINGLE));
        assertEquals(yaml("player_list"), toYaml(LIST));
    }

    @Test
    @Disabled
        // Does not work since this is nothing toml supports
    void serializeToToml() throws JsonProcessingException {
        assertEquals(toml("player"), toToml(SINGLE));
    }
}
