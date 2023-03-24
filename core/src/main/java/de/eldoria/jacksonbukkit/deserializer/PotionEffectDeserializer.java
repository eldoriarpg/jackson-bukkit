/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import de.eldoria.jacksonbukkit.entities.LegacyPotionEffectWrapper;
import de.eldoria.jacksonbukkit.entities.PotionEffectWrapper;
import org.bukkit.potion.PotionEffect;

import java.io.IOException;

/**
 * Class for deserialization of {@link PotionEffect}.
 */
public class PotionEffectDeserializer extends JsonDeserializer<PotionEffect> {
    @Override
    public PotionEffect deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode tree = ctxt.readTree(p);
        JsonNode type = tree.get("type");
        if (type.isInt()) {
            return ctxt.readTreeAsValue(tree, LegacyPotionEffectWrapper.class).toBukkitPotionEffect();
        }
        if (type.isObject()) {
            return ctxt.readTreeAsValue(tree, PotionEffectWrapper.class).toBukkitPotionEffect();
        }

        throw new IOException("Unknown type for field type" + type.getNodeType().name());
    }
}
