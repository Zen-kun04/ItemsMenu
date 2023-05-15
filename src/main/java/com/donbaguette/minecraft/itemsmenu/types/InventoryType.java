package com.donbaguette.minecraft.itemsmenu.types;

public class InventoryType {

    private String inventoryTitle;
    private int inventorySlots;

    public InventoryType(String inventoryTitle, int inventorySlots) {
        this.inventoryTitle = inventoryTitle;
        this.inventorySlots = inventorySlots;
    }

    public String getInventoryTitle() {
        return inventoryTitle;
    }

    public void setInventoryTitle(String inventoryTitle) {
        this.inventoryTitle = inventoryTitle;
    }

    public int getInventorySlots() {
        return inventorySlots;
    }

    public void setInventorySlots(int inventorySlots) {
        this.inventorySlots = inventorySlots;
    }
}
