/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.serializer;


import de.eldoria.jacksonbukkit.entities.AttributeModifierWrapper;
import org.bukkit.attribute.AttributeModifier;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonGenerator;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.ValueSerializer;

/**
 * Class for serialization of {@link AttributeModifier}.
 */
public class AttributeModifierSerializer extends ValueSerializer<AttributeModifier> {
    @Override
    public void serialize(AttributeModifier value, JsonGenerator gen, SerializationContext serializers) throws JacksonException {
        gen.writePOJO(AttributeModifierWrapper.of(value));
    }
}
