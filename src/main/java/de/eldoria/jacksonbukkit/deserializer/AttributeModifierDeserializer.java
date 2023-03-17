/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import de.eldoria.jacksonbukkit.entities.AttributeModifierWrapper;
import org.bukkit.attribute.AttributeModifier;

import java.io.IOException;

public class AttributeModifierDeserializer extends JsonDeserializer<AttributeModifier> {
    @Override
    public AttributeModifier deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return ctxt.readValue(p, AttributeModifierWrapper.class).toBukkitAttributeModifier();
    }
}
