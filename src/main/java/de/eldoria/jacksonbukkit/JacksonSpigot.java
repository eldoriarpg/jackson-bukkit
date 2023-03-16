/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.module.SimpleDeserializers;
import com.fasterxml.jackson.databind.module.SimpleSerializers;
import de.eldoria.jacksonbukkit.deserializer.VectorDeserializer;
import de.eldoria.jacksonbukkit.serializer.VectorSerializer;
import org.bukkit.util.Vector;

public class JacksonSpigot extends Module {
    @Override
    public String getModuleName() {
        return "JacksonBukkit";
    }

    @Override
    public Version version() {
        return new Version(1, 0, 0, "", "de.eldoria", "jackson-bukkit");
    }

    @Override
    public void setupModule(SetupContext context) {
        SimpleSerializers serializers = new SimpleSerializers();
        serializers.addSerializer(Vector.class, new VectorSerializer());
        SimpleDeserializers deserializers = new SimpleDeserializers();
        deserializers.addDeserializer(Vector.class, new VectorDeserializer());
        context.addSerializers(serializers);
        context.addDeserializers(deserializers);
    }
}

/*

- Vector
- BlockVector
- ItemStack
- Color
- PotionEffect
- FireworkEffect
- Pattern
- Location
- AttributeModifier
- BoundingBox

 */
