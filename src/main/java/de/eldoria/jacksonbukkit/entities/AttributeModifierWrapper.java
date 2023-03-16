package de.eldoria.jacksonbukkit.entities;

import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlot;

import java.util.UUID;

public record AttributeModifierWrapper(UUID uuid, String name, double amount, AttributeModifier.Operation operation, EquipmentSlot equipmentSlot) {

    public static AttributeModifierWrapper of(AttributeModifier attributeModifier){
        return new AttributeModifierWrapper(
                attributeModifier.getUniqueId(),
                attributeModifier.getName(),
                attributeModifier.getAmount(),
                attributeModifier.getOperation(),
                attributeModifier.getSlot());
    }

    public AttributeModifier toBukkitAttributeModifier(){
        return new AttributeModifier(
                uuid,
                name,
                amount,
                operation,
                equipmentSlot
        );
    }
}
