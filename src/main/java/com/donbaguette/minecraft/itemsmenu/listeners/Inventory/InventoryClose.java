package com.donbaguette.minecraft.itemsmenu.listeners.Inventory;

import com.donbaguette.minecraft.itemsmenu.utils.InventorySettings;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class InventoryClose implements Listener {

    private final InventorySettings inventorySettings;

    public InventoryClose(InventorySettings inventorySettings) {
        this.inventorySettings = inventorySettings;
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        Player player = (Player) event.getPlayer();
        if(event.getView().getTitle().replace('§', '&').equals("&c&lInventory Creator") &&
                inventorySettings.getPlayerInventoryCreating().containsKey(player) &&
                !inventorySettings.getWaitingForChat().contains(player.getName())
        ){
            inventorySettings.removePlayerInventoryCreating(player);
        }
    }

}
