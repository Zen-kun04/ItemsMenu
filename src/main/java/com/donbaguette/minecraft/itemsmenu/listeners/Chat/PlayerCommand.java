package com.donbaguette.minecraft.itemsmenu.listeners.Chat;

import com.donbaguette.minecraft.itemsmenu.ItemsMenu;
import com.donbaguette.minecraft.itemsmenu.managers.ConfigManager;
import com.donbaguette.minecraft.itemsmenu.managers.InventoryManager;
import com.donbaguette.minecraft.itemsmenu.types.ConfigType;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PlayerCommand implements Listener {

    private final ItemsMenu main;

    public PlayerCommand(ItemsMenu main) {
        this.main = main;
    }
    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent event) throws IOException {
        Player player = event.getPlayer();
        String message = event.getMessage();
        String command = message.substring(1).split(" ")[0];
        ConfigType configType = new ConfigType();

        configType.setConfigPath(this.main.getDataFolder().getPath());
        configType.setConfigName("config.yml");
        ConfigManager configManager = new ConfigManager(this.main, configType);
        FileConfiguration config = configManager.getConfig();
        List<String> commands = new ArrayList<>(Objects.requireNonNull(config.getConfigurationSection("commands")).getKeys(false));
        System.out.println(commands);
        System.out.println(command);
        if(commands.contains(command)) {
            String fullpath = config.getString("commands." + command);
            assert fullpath != null;
            File file = new File(fullpath);
            InventoryManager inventoryManager = new InventoryManager(file.getName(), new File(this.main.getDataFolder(), file.getParent()));
            player.openInventory(inventoryManager.getInventoryFromConfig());
            event.setCancelled(true);
        }

    }

}
