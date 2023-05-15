package com.donbaguette.minecraft.itemsmenu;

import com.donbaguette.minecraft.itemsmenu.managers.ConfigManager;
import com.donbaguette.minecraft.itemsmenu.types.ConfigType;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public final class ItemsMenu extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        ConfigType configType = new ConfigType();

        System.out.println("Testing 1");
        this.saveDefaultConfig();
        FileConfiguration config = this.getConfig();
        System.out.println(config.get("test1.test2.name"));
        config.addDefault("Prueba1", "chi uwu");
        config.addDefault("Prueba2", "jijijija");
        config.addDefault("gay", true);
        config.addDefault("test1.pene", false);
        config.options().copyDefaults(true);
        saveConfig();
        configType.setConfigPath(this.getDataFolder().getPath());
        configType.setConfigName("TestingXD.yml");
        ConfigManager configManager = new ConfigManager(this, configType);
        try {
            configManager.saveDefaultConfig();
            FileConfiguration newConfig = configManager.getConfig();
            newConfig.addDefault("NombreCompleto", "putakeriko");
            configManager.saveConfig();


        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("no se pudo guardar la config");
            throw new RuntimeException(e);
        }


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("Testing 2");
    }
}
