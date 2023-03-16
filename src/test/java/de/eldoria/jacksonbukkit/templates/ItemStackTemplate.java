package de.eldoria.jacksonbukkit.templates;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemStackTemplate {
    public static final ItemStack SINGLE;

    public static final List<ItemStack> LIST = new ArrayList<>();

    static {
        ItemStack stack = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta meta = stack.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addEnchant(Enchantment.DURABILITY, 3, false);
        meta.setLore(List.of("Amazing",  "Lore"));
        meta.setDisplayName("Almighty wooden sword");
        meta.setUnbreakable(true);
        stack.setItemMeta(meta);
        LIST.add(stack);
        SINGLE = stack;

        LIST.add(new ItemStack(Material.SANDSTONE, 64));

        LIST.add(new ItemStack(Material.DIRT, 32));

        LIST.add(new ItemStack(Material.GRAVEL));
    }
}
