package com.tenjava.entries.joaopms.t1;

import com.tenjava.entries.joaopms.t1.event.UpgradeCraftEvent;
import com.tenjava.entries.joaopms.t1.event.VehicleUpgradeEvent;
import com.tenjava.entries.joaopms.t1.upgrade.Upgrade;
import com.tenjava.entries.joaopms.t1.upgrade.UpgradeManager;
import com.tenjava.entries.joaopms.t1.upgrade.UpgradeType;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

public class TenJava extends JavaPlugin {
    private static Plugin plugin;

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

    @Override
    public void onEnable() {
        // TODO "/vupgrades" command
        plugin = this;

        // Register: Events
        Bukkit.getPluginManager().registerEvents(new VehicleUpgradeEvent(), plugin);
        Bukkit.getPluginManager().registerEvents(new UpgradeCraftEvent(), plugin);

        // Register: Upgrades
        Map<Material, Integer> testUpgrade = new HashMap<Material, Integer>();
        testUpgrade.put(Material.APPLE, 5);
        UpgradeManager.registerUpgrade(new Upgrade("Test", UpgradeType.SPEED, 1, testUpgrade));
    }
}