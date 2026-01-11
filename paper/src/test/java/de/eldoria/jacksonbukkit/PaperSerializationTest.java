/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit;

import tools.jackson.databind.JacksonModule;

public interface PaperSerializationTest extends SerializationTest{
    default JacksonModule buildModule() {
        return new JacksonPaper();
    }
}
