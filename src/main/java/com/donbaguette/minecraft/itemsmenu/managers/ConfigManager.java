package com.donbaguette.minecraft.itemsmenu.managers;

import com.donbaguette.minecraft.itemsmenu.ItemsMenu;
import com.donbaguette.minecraft.itemsmenu.types.ConfigType;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class ConfigManager {

    private File configFile = null;
    private FileConfiguration config = null;
    private final ConfigType configType;
    private final ItemsMenu main;

    public ConfigManager(ItemsMenu main, ConfigType configType) {
        this.main = main;
        this.configType = configType;
    }

    public void reloadConfig() {
        if(this.configFile == null) {
            this.configFile = new File(this.main.getDataFolder(), this.configType.getConfigName());
        }

        this.config = YamlConfiguration.loadConfiguration(this.configFile);
        this.config.options().copyDefaults(true);

        Reader defaultConfigStream = new InputStreamReader(Objects.requireNonNull(this.main.getResource(this.configType.getConfigName())), StandardCharsets.UTF_8);
        YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(defaultConfigStream);
        this.config.setDefaults(defaultConfig);
    }

    public FileConfiguration getConfig() throws UnsupportedEncodingException {
        if(this.config == null){
            reloadConfig();
        }
        return this.config;
    }

    public void saveConfig() throws IOException {
        if(this.config == null || this.configFile == null) {
            return;
        }
        System.out.println("se guardo XD");
        getConfig().save(this.configFile);
    }

    public void saveDefaultConfig() throws IOException {
        if(this.configFile == null) {
            this.configFile = new File(this.main.getDataFolder(), this.configType.getConfigName());
        }
        if(!this.configFile.exists()){
            System.out.println("Saving resource: " + this.configFile.getName());
            this.main.saveResource(this.configFile.getName(), false);
        }
    }

}
