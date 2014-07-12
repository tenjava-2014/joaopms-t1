package com.tenjava.entries.joaopms.t1.upgrade;

import com.tenjava.entries.joaopms.t1.TenJava;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class UpgradeManager {
    private static List<Upgrade> upgrades = new ArrayList<>();

    /**
     * Registers an upgrade
     *
     * @param upgrade Upgrade to register
     */
    public static void registerUpgrade(Upgrade upgrade) {
        upgrades.add(upgrade);
        TenJava.log(Level.INFO, "Upgrade Manager > " + upgrade.getName() + " registered");
    }

    /**
     * Gets if the upgrade exists
     *
     * @param upgradeName Upgrade name
     * @return Does the upgrade exist?
     */
    public static boolean doesUpgradeExist(String upgradeName) {
        for (Upgrade upgrade : upgrades)
            if (upgrade.getName().equalsIgnoreCase(upgradeName))
                return true;

        return false;
    }
}
