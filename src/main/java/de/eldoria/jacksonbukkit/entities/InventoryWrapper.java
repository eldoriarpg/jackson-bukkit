/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.entities;

import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public record InventoryWrapper(InventoryType inventoryType, ItemStack[] contents) {

    public static InventoryWrapper of(Inventory inventory) {
        return new InventoryWrapper(inventory.getType(), inventory.getContents());
    }
}
