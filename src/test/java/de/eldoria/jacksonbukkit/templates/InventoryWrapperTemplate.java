/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.templates;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryWrapperTemplate {

    public static final Inventory SINGLE;

    static {
        SINGLE = Bukkit.createInventory(null, InventoryType.BARREL);
        SINGLE.setContents(new ItemStack[]{
                new ItemStack(Material.SANDSTONE, 64),
                new ItemStack(Material.DIRT, 32),
                new ItemStack(Material.GRAVEL)
        });
    }
}
