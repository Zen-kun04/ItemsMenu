package com.donbaguette.minecraft.itemsmenu;

import com.donbaguette.minecraft.itemsmenu.managers.ConfigManager;
import com.donbaguette.minecraft.itemsmenu.managers.InventoryConfigManager;
import com.donbaguette.minecraft.itemsmenu.managers.InventoryManager;
import com.donbaguette.minecraft.itemsmenu.types.ConfigType;
import com.donbaguette.minecraft.itemsmenu.types.InventoryType;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;


public final class ItemsMenu extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        ConfigType configType = new ConfigType();

        configType.setConfigPath(this.getDataFolder().getPath());
        configType.setConfigName("config.yml");
        ConfigManager configManager = new ConfigManager(this, configType);
        configManager.saveDefaultConfig();
        FileConfiguration newConfig = configManager.getConfig();
        //newConfig.addDefault("Key", "Value");
        //configManager.saveConfig();


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
}
