package com.donbaguette.minecraft.itemsmenu;

import com.donbaguette.minecraft.itemsmenu.types.ConfigType;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;


public final class ItemsMenu extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        ConfigType configType = new ConfigType();
        this.saveDefaultConfig();
        FileConfiguration config = this.getConfig();
        System.out.println(config.get("test1.test2.name"));
        config.addDefault("TestingOne", "Yes");
        config.addDefault("TestingTwo", "No");
        config.addDefault("Yes", true);
        config.addDefault("test1.False", false);
        config.options().copyDefaults(true);
        saveConfig();
        /*
        configType.setConfigPath(this.getDataFolder().getPath());
        configType.setConfigName("TestingXD.yml");
        ConfigManager configManager = new ConfigManager(this, configType);
        try {
             configManager.saveDefaultConfig();
            FileConfiguration newConfig = configManager.getConfig();
            newConfig.addDefault("Key", "Value");
            configManager.saveConfig();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        */

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("Testing 2");
    }
}
