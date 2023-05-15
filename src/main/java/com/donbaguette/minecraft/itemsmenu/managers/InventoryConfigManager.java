package com.donbaguette.minecraft.itemsmenu.managers;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

public class InventoryConfigManager {

    private final String inventoryName;
    private File inventoryFile = null;
    private final File inventoryFolder;
    private FileConfiguration inventoryConfig = null;

    public InventoryConfigManager(String inventoryName, File inventoryFolder) {
        this.inventoryName = inventoryName;
        this.inventoryFolder = inventoryFolder;
    }

    public void reloadInventoryConfig() throws IOException {
        if(this.inventoryFile == null) {
            this.inventoryFile = new File(this.inventoryFolder, this.inventoryName);
            if(!this.inventoryFolder.isDirectory()) {
                final boolean inventoryFolderCreated = this.inventoryFolder.mkdir();
                if(!inventoryFolderCreated) {
                    System.out.println("We couldn't create the folder named \"" + this.inventoryFolder.getName() + "\"");
                    return;
                }
            }
            if(!this.inventoryFile.exists()) {
                final boolean inventoryFileCreated = this.inventoryFile.createNewFile();
                if(!inventoryFileCreated) {
                    System.out.println("We couldn't create the inventory file named \"" + this.inventoryFile.getName() + "\"");
                    return;
                }
            }
        }
        this.inventoryConfig = YamlConfiguration.loadConfiguration(this.inventoryFile);
        this.inventoryConfig.options().copyDefaults(true);

        final Reader inventoryReader = new InputStreamReader(this.inventoryFile.toURI().toURL().openStream(), StandardCharsets.UTF_8);
        final YamlConfiguration defaultInventoryReader = YamlConfiguration.loadConfiguration(inventoryReader);
        this.inventoryConfig.setDefaults(defaultInventoryReader);
    }

    public FileConfiguration getInventoryConfig() throws IOException {
        if(this.inventoryConfig == null){
            reloadInventoryConfig();
        }

        return this.inventoryConfig;
    }

    public void saveInventoryConfig() throws IOException {
        this.inventoryConfig.save(this.inventoryFile);
    }

}
