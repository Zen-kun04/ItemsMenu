package com.donbaguette.minecraft.itemsmenu.listeners.Inventory;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;

import java.util.Objects;

public class InventoryClick implements Listener {

    @EventHandler
    public void onInventoryClickEvent(InventoryClickEvent event) {
        if(event.getView().getTitle().replace('§', '&').equals("&c&lInventory Creator")) {
            // code here
            Player player = (Player) event.getWhoClicked();
            if(event.getSlotType() != InventoryType.SlotType.OUTSIDE && Objects.equals(event.getClickedInventory(), event.getView().getTopInventory())){
                if (Objects.requireNonNull(event.getCurrentItem()).getType() == Material.GRASS) {
                    player.sendMessage("It's a grass block");
                } else {
                    player.sendMessage("Anything but not a grass block");
                }
            }

            event.setCancelled(true);
        }
    }
}
