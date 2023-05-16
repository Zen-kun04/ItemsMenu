package com.donbaguette.minecraft.itemsmenu.utils;


import com.donbaguette.minecraft.itemsmenu.enums.InventoryCreatorItems;
import com.donbaguette.minecraft.itemsmenu.managers.InventoryManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;


public class InventorySettings {

    private final ArrayList<String> waitingForChat = new ArrayList<>();
    private final HashMap<Player, InventoryManager> playerInventoryCreating = new HashMap<>();

    public ArrayList<String> getWaitingForChat() {
        return waitingForChat;
    }

    public void addWaitingForChat(String player) {
        waitingForChat.add(player);
    }

    public void removeWaitingForChat(String player) {
        waitingForChat.remove(player);
    }

    public HashMap<Player, InventoryManager> getPlayerInventoryCreating() {
        return playerInventoryCreating;
    }

    public void addPlayerInventoryCreating(Player player, InventoryManager inventoryManager){
        playerInventoryCreating.put(player, inventoryManager);
    }

    public void removePlayerInventoryCreating(Player player){
        playerInventoryCreating.remove(player);
    }

    public Inventory createInventory() {

        Inventory inventory = Bukkit.createInventory(null, 36, ChatColor.translateAlternateColorCodes('&', "&c&lInventory Creator"));

        ItemStack sign = InventoryCreatorItems.SIGN.itemStack;
        ItemMeta signMeta = sign.getItemMeta();
        assert signMeta != null;
        signMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&5&lSomething weird"));
        sign.setItemMeta(signMeta);
        inventory.setItem(3, sign);

        ItemStack greenWool = InventoryCreatorItems.WOOL.itemStack;
        ItemMeta greenWoolMeta = greenWool.getItemMeta();
        assert greenWoolMeta != null;
        greenWoolMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&aAdd custom items"));
        greenWool.setItemMeta(greenWoolMeta);
        inventory.setItem(5, greenWool);

        return inventory;
    }

}
