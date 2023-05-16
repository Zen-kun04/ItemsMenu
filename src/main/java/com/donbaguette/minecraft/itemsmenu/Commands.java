package com.donbaguette.minecraft.itemsmenu;

import com.donbaguette.minecraft.itemsmenu.managers.InventoryManager;
import com.donbaguette.minecraft.itemsmenu.types.InventoryType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;

public class Commands implements CommandExecutor {

    private final ItemsMenu main;

    public Commands(ItemsMenu main) {
        this.main = main;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if(sender instanceof Player) {
            if(args.length > 0) {
                switch (args[0]){
                    case "help":
                        System.out.println("si xd");
                        break;
                    case "create":
                        if(args.length > 1){
                            InventoryType inventoryType = new InventoryType("My Inventory", 16);
                            InventoryManager inventoryManager = new InventoryManager(args[1] + ".yml", new File(this.main.getDataFolder(), "Inventories"));
                            try {
                                inventoryManager.createInventoryConfig(inventoryType);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }else{
                            System.out.println("necesito el nombre de un inventario para crear");
                        }

                        System.out.println("creating inv");
                        break;
                    default:
                        System.out.println("unknown");
                        break;
                }
            }else{
                System.out.println("no hay argumentos");
            }
        }else{
            if(args.length > 0) {
                switch (args[0]){
                    case "help":
                        System.out.println("si xd");
                        break;
                    case "create":
                        if(args.length > 1){
                            InventoryType inventoryType = new InventoryType("My Inventory", 16);
                            InventoryManager inventoryManager = new InventoryManager(args[1] + ".yml", new File(this.main.getDataFolder(), "Inventories"));
                            try {
                                inventoryManager.createInventoryConfig(inventoryType);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }else{
                            System.out.println("necesito el nombre de un inventario para crear");
                        }

                        System.out.println("creating inv");
                        break;
                    default:
                        System.out.println("unknown");
                        break;
                }
            }else{
                System.out.println("no hay argumentos");
            }
        }

        return false;
    }
}
