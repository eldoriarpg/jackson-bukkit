package de.eldoria.jacksonbukkit;

import be.seeseemelk.mockbukkit.MockBukkit;
import be.seeseemelk.mockbukkit.ServerMock;

public class MockServer {
    static ServerMock server = null;

    public static void startServer() {
        if (server == null) {
            server = MockBukkit.mock();
        }
    }
}
