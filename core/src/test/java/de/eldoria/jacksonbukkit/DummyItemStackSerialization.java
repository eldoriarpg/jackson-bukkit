/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleDeserializers;
import com.fasterxml.jackson.databind.module.SimpleSerializers;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.io.IOException;

public class DummyItemStackSerialization extends Module {
    @Override
    public String getModuleName() {
        return "ItemStack";
    }

    @Override
    public Version version() {
        return new Version(1,0,0,"0");
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

    private static class ItemStackSerializer extends JsonSerializer<ItemStack> {

        @Override
        public void serialize(ItemStack value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeObject(ItemStackWrapper.from(value));
        }
    }

    private static class ItemStackDeserializer extends JsonDeserializer<ItemStack> {

        @Override
        public ItemStack deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
            return ctxt.readValue(p, ItemStackWrapper.class).toItemStack();
        }
    }

    private record ItemStackWrapper(Material material, int amount) {
        public static ItemStackWrapper from(ItemStack stack) {
            return new ItemStackWrapper(stack.getType(), stack.getAmount());
        }

        public ItemStack toItemStack(){
            return new ItemStack(material, amount);
        }
    }
}
