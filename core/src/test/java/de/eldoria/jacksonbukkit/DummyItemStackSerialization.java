/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonGenerator;
import tools.jackson.core.JsonParser;
import tools.jackson.core.Version;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.JacksonModule;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.ValueDeserializer;
import tools.jackson.databind.ValueSerializer;
import tools.jackson.databind.module.SimpleDeserializers;
import tools.jackson.databind.module.SimpleSerializers;

public class DummyItemStackSerialization extends JacksonModule {
    @Override
    public String getModuleName() {
        return "ItemStack";
    }

    @Override
    public Version version() {
        return new Version(1, 0, 0, "0", null, null);
    }

    @Override
    public void setupModule(SetupContext context) {
        SimpleSerializers serializers = new SimpleSerializers();
        SimpleDeserializers deserializers = new SimpleDeserializers();
        serializers.addSerializer(ItemStack.class, new ItemStackSerializer());
        deserializers.addDeserializer(ItemStack.class, new ItemStackDeserializer());

        context.addSerializers(serializers);
        context.addDeserializers(deserializers);
    }

    private static class ItemStackSerializer extends ValueSerializer<ItemStack> {

        @Override
        public void serialize(ItemStack value, JsonGenerator gen, SerializationContext serializers) throws JacksonException {
            gen.writePOJO(ItemStackWrapper.from(value));
        }
    }

    private static class ItemStackDeserializer extends ValueDeserializer<ItemStack> {

        @Override
        public ItemStack deserialize(JsonParser p, DeserializationContext ctxt) throws JacksonException {
            return ctxt.readValue(p, ItemStackWrapper.class).toItemStack();
        }
    }

    private record ItemStackWrapper(Material material, int amount) {
        public static ItemStackWrapper from(ItemStack stack) {
            return new ItemStackWrapper(stack.getType(), stack.getAmount());
        }

        public ItemStack toItemStack() {
            return new ItemStack(material, amount);
        }
    }
}
