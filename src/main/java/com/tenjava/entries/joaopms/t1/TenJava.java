package com.tenjava.entries.joaopms.t1;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class TenJava extends JavaPlugin {
    private static Plugin plugin;

    @Override
    public void onEnable() {
        plugin = this;
        System.out.println("Hello world!");
    }

    /**
     * Gets the plugin instance
     *
     * @return the plugin instance
     */
    public static Plugin getPlugin() {
        return plugin;
    }
}