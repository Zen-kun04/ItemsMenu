package com.donbaguette.minecraft.itemsmenu.types;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ConfigType {
    private String configName;
    private String configPath;

    private final Map<String, Object> map = new HashMap<>();

    public String getConfigName() {
        return this.configName;
    }

    public void setConfigName(String name) {
        this.configName = name;
    }

    public String getConfigPath() {
        return this.configPath;
    }

    public void setConfigPath(String path) {
        this.configPath = path;
    }

    public void addDefaults(String key, Object value) {
        map.put(key, value);
    }

    public void removeDefaults(String key) {
        map.remove(key);
    }

    public Map<String, Object> getMap() {
        return this.map;
    }
}
