/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.Module;
import de.eldoria.jacksonbukkit.JacksonBukkit;
import de.eldoria.jacksonbukkit.SerializationTest;
import org.junit.jupiter.api.Test;

import static de.eldoria.jacksonbukkit.templates.PaperColorTemplate.LIST;
import static de.eldoria.jacksonbukkit.templates.PaperColorTemplate.SINGLE;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PaperColorSerializerTest implements SerializationTest {

    @Override
    public Module buildModule() {
        return JacksonBukkit.paper().build();
    }

    @Test
    void serializeToJson() throws JsonProcessingException {
        assertEquals(json("paper_color"), toJson(SINGLE));
        assertEquals(json("paper_color_list"), toJson(LIST));
    }

    @Test
    void serializeToYaml() throws JsonProcessingException {
        assertEquals(yaml("paper_color"), toYaml(SINGLE));
        assertEquals(yaml("paper_color_list"), toYaml(LIST));
    }

    @Test
    void serializeToToml() throws JsonProcessingException {
        assertEquals(toml("paper_color"), toToml(SINGLE));
    }
}
