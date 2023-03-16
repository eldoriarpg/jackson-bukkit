package de.eldoria.jacksonbukkit.templates;

import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlot;

import java.util.List;
import java.util.UUID;

public class AttributeModifierTemplate {

    public static final AttributeModifier SINGLE = new AttributeModifier(
            UUID.fromString("78d16016-b2c3-48c0-8334-4dff96a1b42d"),
            "test",
            1337,
            AttributeModifier.Operation.ADD_NUMBER,
            EquipmentSlot.HAND
    );
    public static final List<AttributeModifier> LIST = List.of(

            new AttributeModifier(
                    new UUID(10L, 20L),
                    "test1",
                    1337,
                    AttributeModifier.Operation.ADD_NUMBER,
                    EquipmentSlot.HAND
            ),
            new AttributeModifier(
                    new UUID(20L, 40L),
                    "test2",
                    1337,
                    AttributeModifier.Operation.ADD_SCALAR,
                    EquipmentSlot.HAND
            ),
            new AttributeModifier(
                    new UUID(30L, 60L),
                    "test3",
                    1337,
                    AttributeModifier.Operation.MULTIPLY_SCALAR_1,
                    EquipmentSlot.HAND
            ));

}
