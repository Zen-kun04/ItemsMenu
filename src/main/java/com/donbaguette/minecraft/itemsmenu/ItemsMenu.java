package com.donbaguette.minecraft.itemsmenu;

import com.donbaguette.minecraft.itemsmenu.listeners.Chat.PlayerChat;
import com.donbaguette.minecraft.itemsmenu.listeners.Chat.PlayerCommand;
import com.donbaguette.minecraft.itemsmenu.listeners.Inventory.InventoryClick;
import com.donbaguette.minecraft.itemsmenu.listeners.Inventory.InventoryClose;
import com.donbaguette.minecraft.itemsmenu.managers.ConfigManager;
import com.donbaguette.minecraft.itemsmenu.managers.InventoryManager;
import com.donbaguette.minecraft.itemsmenu.types.ConfigType;
import com.donbaguette.minecraft.itemsmenu.types.InventoryType;
import com.donbaguette.minecraft.itemsmenu.utils.InventorySettings;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.Objects;


public final class ItemsMenu extends JavaPlugin {

    private InventorySettings inventorySettings;
    @Override
    public void onEnable() {
        // Plugin startup logic
        inventorySettings = new InventorySettings();
        loadEvents();
        loadCommands();
        ConfigType configType = new ConfigType();

        configType.setConfigPath(this.getDataFolder().getPath());
        configType.setConfigName("config.yml");
        ConfigManager configManager = new ConfigManager(this, configType);
        configManager.saveDefaultConfig();

        InventoryType inventoryType = new InventoryType("My Inventory", 16);
        InventoryManager inventoryManager = new InventoryManager("inventory1.yml", new File(getDataFolder(), "Inventories"));
        try {
            inventoryManager.createInventoryConfig(inventoryType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("Testing 2");
    }
    public void loadCommands() {
        Objects.requireNonNull(this.getCommand("itemsmenu")).setExecutor(new Commands(this, inventorySettings));
    }

    public void loadEvents() {
        getServer().getPluginManager().registerEvents(new InventoryClick(inventorySettings), this);
        getServer().getPluginManager().registerEvents(new PlayerChat(inventorySettings), this);
        getServer().getPluginManager().registerEvents(new InventoryClose(inventorySettings), this);
        getServer().getPluginManager().registerEvents(new PlayerCommand(this), this);
    }
}
