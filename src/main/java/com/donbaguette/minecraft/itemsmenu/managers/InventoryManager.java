package com.donbaguette.minecraft.itemsmenu.managers;

import com.donbaguette.minecraft.itemsmenu.types.InventoryType;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class InventoryManager extends InventoryConfigManager {


    public InventoryManager(String inventoryName, File inventoryFolder) {
        super(inventoryName, inventoryFolder);
    }

    @Override
    public void reloadInventoryConfig() throws IOException {
        super.reloadInventoryConfig();
    }

    @Override
    public FileConfiguration getInventoryConfig() throws IOException {
        return super.getInventoryConfig();
    }

    @Override
    public void saveInventoryConfig() throws IOException {
        super.saveInventoryConfig();
    }

    public void createInventoryConfig(InventoryType inventoryType) throws IOException {
        reloadInventoryConfig();
        FileConfiguration inventoryConfig = getInventoryConfig();
        inventoryConfig.addDefault("title", inventoryType.getInventoryTitle());
        inventoryConfig.addDefault("slots", inventoryType.getInventorySlots());
        saveInventoryConfig();
    }
}
