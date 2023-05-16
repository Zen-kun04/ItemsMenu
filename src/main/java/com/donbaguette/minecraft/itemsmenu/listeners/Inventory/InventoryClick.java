package com.donbaguette.minecraft.itemsmenu.listeners.Inventory;

import com.donbaguette.minecraft.itemsmenu.enums.InventoryCreatorItems;
import com.donbaguette.minecraft.itemsmenu.utils.InventorySettings;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;

import java.util.Objects;

public class InventoryClick implements Listener {

    private final InventorySettings inventorySettings;
    public InventoryClick(InventorySettings inventorySettings) {
        this.inventorySettings = inventorySettings;
    }
    @EventHandler
    public void onInventoryClickEvent(InventoryClickEvent event) {
        if(event.getView().getTitle().replace('§', '&').equals("&c&lInventory Creator")) {
            // code here
            Player player = (Player) event.getWhoClicked();
            if(event.getSlotType() != InventoryType.SlotType.OUTSIDE && Objects.equals(event.getClickedInventory(), event.getView().getTopInventory())){
                if (Objects.requireNonNull(event.getCurrentItem()).getType() == InventoryCreatorItems.SIGN.itemStack.getType()) {
                    inventorySettings.addWaitingForChat(player.getName());
                    player.closeInventory();

                } else if(Objects.requireNonNull(event.getCurrentItem()).getType() == InventoryCreatorItems.WOOL.itemStack.getType()) {
                    player.closeInventory();
                    player.sendMessage("Vamos a agregar items custom al nuevo inventario");
                }else {
                    player.sendMessage("Anything but not a grass block");
                }
            }

            event.setCancelled(true);
        }
    }
}
