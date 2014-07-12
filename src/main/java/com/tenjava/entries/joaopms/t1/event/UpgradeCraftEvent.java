package com.tenjava.entries.joaopms.t1.event;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class UpgradeCraftEvent implements Listener {
    @EventHandler
    public void chestClick(PlayerInteractEvent event) {
        Action action = event.getAction();

        // Checks if the action is the one we want
        if (action != Action.LEFT_CLICK_BLOCK)
            return;

        // Checks if the item is null
        ItemStack item = event.getItem();
        if (item == null)
            return;

        // Checks if the item is a stick
        if (item.getType() != Material.STICK)
            return;

        ItemMeta itemMeta = item.getItemMeta();
        String itemName = itemMeta.getDisplayName();

        // Checks if the stick's name is null
        if (itemName == null)
            return;

        // Checks if the stick's name is "Upgrade Wand"
        if (!itemName.equalsIgnoreCase("Upgrade Wand"))
            return;
        
        event.setCancelled(true);
        System.out.println("random thing goes here");
    }
}
