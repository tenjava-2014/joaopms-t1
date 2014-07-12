package com.tenjava.entries.joaopms.t1.upgrade;

import com.tenjava.entries.joaopms.t1.TenJava;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

public class UpgradeManager {
    private static List<Upgrade> upgrades = new ArrayList<>();

    /**
     * Gets the upgrades
     *
     * @return Upgrade list
     */
    public static List<Upgrade> getUpgrades() {
        return upgrades;
    }

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

    /**
     * Gets if the upgrade can be crafted
     *
     * @param upgradeName The upgrade name
     * @param craftItems  The items allowed to craft
     * @return Can the upgrade be crafted?
     */
    public static boolean canCraftUpgrade(String upgradeName, List<ItemStack> craftItems) {
        Upgrade upgrade = null;

        // Loops through all of the upgrades
        for (Upgrade u : upgrades) {
            // Checks if the upgrade's name equals to the provided upgrade's name
            if (u.getName().equalsIgnoreCase(upgradeName)) {
                // Set the upgrade
                upgrade = u;
                break;
            }
        }

        Map<Material, Integer> upgradeMaterials = upgrade.getMaterials();

        // Checks if the chest's items are more than needed
        if (craftItems.size() > upgradeMaterials.size())
            return false;

        Map<Material, Boolean> existingMaterials = new HashMap<>();

        for (Material material : upgradeMaterials.keySet())
            existingMaterials.put(material, false);

        for (ItemStack itemStack : craftItems) {
            Material itemMaterial = itemStack.getType();
            Integer itemQuantity = itemStack.getAmount();

            if (upgradeMaterials.containsKey(itemMaterial) && upgradeMaterials.get(itemMaterial) == itemQuantity)
                existingMaterials.put(itemMaterial, true);
        }

        for (boolean taken : existingMaterials.values())
            if (!taken)
                return false;

        return true;
    }
}
