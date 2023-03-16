package de.eldoria.jacksonbukkit.templates;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemStackTemplate {
    public static final ItemStack DEFAULT;

    public static final List<ItemStack> STACKS = new ArrayList<>();

    static {
        ItemStack stack = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta meta = stack.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addEnchant(Enchantment.DURABILITY, 3, false);
        meta.setLore(List.of("Amazing",  "Lore"));
        meta.setDisplayName("Almighty wooden sword");
        meta.setUnbreakable(true);
        stack.setItemMeta(meta);
        STACKS.add(stack);
        DEFAULT = stack;

        STACKS.add(new ItemStack(Material.SANDSTONE, 64));

        STACKS.add(new ItemStack(Material.DIRT, 32));

        STACKS.add(new ItemStack(Material.GRAVEL));
    }
}
