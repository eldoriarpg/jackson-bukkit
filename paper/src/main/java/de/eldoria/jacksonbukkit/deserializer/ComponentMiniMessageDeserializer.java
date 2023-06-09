/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import de.eldoria.jacksonbukkit.util.PaperFeatures;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;

import java.io.IOException;

/**
 * Class for deserialization of {@link Component} using {@link MiniMessage}.
 */
public class ComponentMiniMessageDeserializer extends ComponentGsonDeserializer {
    private final MiniMessage miniMessage;

    /**
     * Creates a new serializer
     *
     * @param miniMessage MiniMessage instance to use
     */
    public ComponentMiniMessageDeserializer(MiniMessage miniMessage) {
        this.miniMessage = miniMessage;
    }

    /**
     * Creates a new serializer
     */
    public ComponentMiniMessageDeserializer() {
        if (PaperFeatures.HAS_COMPONENT_COMPACT) {
            miniMessage = MiniMessage.builder().build();
        } else {
            miniMessage = MiniMessage.builder().postProcessor(Function::indentity).build();
        }
    }

    @Override
    public Component deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode tree = ctxt.readTree(p);
        if (tree.isObject()) return parseObjectTree(tree, ctxt);
        return miniMessage.deserialize(ctxt.readValue(p, String.class));
    }
}
