/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.entities;

import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlot;

import java.util.UUID;


/**
 * Class for wrapping an {@link AttributeModifier}.
 */
public record AttributeModifierWrapper(UUID uuid, String name, double amount, AttributeModifier.Operation operation,
                                       EquipmentSlot equipmentSlot) {

    /**
     * Create a new {@link AttributeModifierWrapper} based on an {@link AttributeModifier}.
     *
     * @param attributeModifier attribute modifier instance
     * @return new {@link AttributeModifierWrapper} instance
     */
    public static AttributeModifierWrapper of(AttributeModifier attributeModifier) {
        return new AttributeModifierWrapper(
                attributeModifier.getUniqueId(),
                attributeModifier.getName(),
                attributeModifier.getAmount(),
                attributeModifier.getOperation(),
                attributeModifier.getSlot());
    }

    /**
     * Constructs a new {@link AttributeModifier} based on wrapper values.
     *
     * @return new {@link AttributeModifier} instance
     */
    public AttributeModifier toBukkitAttributeModifier() {
        return new AttributeModifier(
                uuid,
                name,
                amount,
                operation,
                equipmentSlot
        );
    }
}
