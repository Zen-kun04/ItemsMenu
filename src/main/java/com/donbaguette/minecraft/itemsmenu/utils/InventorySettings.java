package com.donbaguette.minecraft.itemsmenu.utils;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InventorySettings {

    public Inventory createInventory() {
        Inventory inventory = Bukkit.createInventory(null, 36, ChatColor.translateAlternateColorCodes('&', "&c&lInventory Creator"));
        ItemStack grass = new ItemStack(Material.GRASS);
        ItemMeta grassMeta = grass.getItemMeta();
        assert grassMeta != null;
        grassMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&5&lSomething weird"));
        grass.setItemMeta(grassMeta);
        inventory.setItem(3, grass);
        return inventory;
    }

}
