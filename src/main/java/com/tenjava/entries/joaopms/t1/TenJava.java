package com.tenjava.entries.joaopms.t1;

import com.tenjava.entries.joaopms.t1.event.SwordBlockEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public class TenJava extends JavaPlugin {
    private static Plugin plugin;

    @Override
    public void onEnable() {
        plugin = this;

        //Register: Events
        Bukkit.getPluginManager().registerEvents(new SwordBlockEvent(), plugin);
    }

    /**
     * Gets the plugin instance
     *
     * @return The plugin instance
     */
    public static Plugin getPlugin() {
        return plugin;
    }

    /**
     * Logs a message to the console
     *
     * @param level   The message level
     * @param message The message
     */
    public static void log(Level level, Object message) {
        plugin.getLogger().log(level, message.toString());
    }
}