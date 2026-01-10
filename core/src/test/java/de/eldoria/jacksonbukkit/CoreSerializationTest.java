/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit;

import tools.jackson.databind.JacksonModule;

import java.util.List;

public interface CoreSerializationTest extends SerializationTest {

    default JacksonModule buildModule() {
        return new JacksonBukkit();
    }

    @Override
    default List<JacksonModule> additionalModules() {
        return List.of(new DummyItemStackSerialization());
    }
}
