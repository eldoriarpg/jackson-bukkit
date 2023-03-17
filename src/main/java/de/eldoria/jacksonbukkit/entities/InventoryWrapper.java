/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.entities;

import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

/**
 * Class for wrapping an {@link Inventory}.
 */
public record InventoryWrapper(InventoryType inventoryType, ItemStack[] contents) {

    /**
     * Create a new {@link InventoryWrapper} based on a {@link Inventory}.
     *
     * @param inventory inventory instance
     * @return new {@link InventoryWrapper} instance
     */
    public static InventoryWrapper of(Inventory inventory) {
        return new InventoryWrapper(inventory.getType(), inventory.getContents());
    }
}
