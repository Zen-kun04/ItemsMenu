package com.donbaguette.minecraft.itemsmenu.listeners.Chat;

import com.donbaguette.minecraft.itemsmenu.managers.InventoryManager;
import com.donbaguette.minecraft.itemsmenu.utils.InventorySettings;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class PlayerChat implements Listener {

    private final InventorySettings inventorySettings;
    public PlayerChat(InventorySettings inventorySettings) {
        this.inventorySettings = inventorySettings;
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) throws IOException {
        Player player = event.getPlayer();
        String message = event.getMessage();

        ArrayList<String> waiting = inventorySettings.getWaitingForChat();
        if(waiting.contains(player.getName())){

            if(message.replace("&", "").length() > 45){
                player.sendMessage("Maximum title length is 45 chatacters!");
            }else{
                inventorySettings.removeWaitingForChat(player.getName());
                // code here
                HashMap<Player, InventoryManager> inventoryManagerHashMap = inventorySettings.getPlayerInventoryCreating();
                InventoryManager inventoryManager = inventoryManagerHashMap.get(player);
                FileConfiguration config = inventoryManager.getInventoryConfig();
                config.set("title", message);
                inventoryManager.saveInventoryConfig();
                inventoryManager.reloadInventoryConfig();


                player.openInventory(inventorySettings.createInventory());
            }


        }else{
            player.sendMessage("no");
        }
    }
}
