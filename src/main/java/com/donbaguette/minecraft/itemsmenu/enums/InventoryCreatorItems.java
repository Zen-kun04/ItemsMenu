package com.donbaguette.minecraft.itemsmenu.enums;

import com.cryptomorin.xseries.XMaterial;
import org.bukkit.Material;
import org.bukkit.block.data.BlockData;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public enum InventoryCreatorItems {
    
    SIGN(new ItemStack(Objects.requireNonNull(XMaterial.OAK_SIGN.parseMaterial())));

    public final ItemStack itemStack;

    InventoryCreatorItems(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

}
