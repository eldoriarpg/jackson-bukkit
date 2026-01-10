/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import de.eldoria.jacksonbukkit.entities.AttributeModifierWrapper;
import org.bukkit.attribute.AttributeModifier;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.ValueDeserializer;

/**
 * Class for deserialization of {@link AttributeModifier}.
 */
public class AttributeModifierDeserializer extends ValueDeserializer<AttributeModifier> {
    @Override
    public AttributeModifier deserialize(JsonParser p, DeserializationContext ctxt) throws JacksonException {
        return ctxt.readValue(p, AttributeModifierWrapper.class).toBukkitAttributeModifier();
    }
}
