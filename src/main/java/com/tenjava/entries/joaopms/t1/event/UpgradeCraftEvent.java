package com.tenjava.entries.joaopms.t1.event;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
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
        Block block = event.getClickedBlock();
        // Checks if the action is the one we want and the block is a chest
        if (!(action == Action.LEFT_CLICK_BLOCK && block.getType() == Material.CHEST))
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

        Chest chest = (Chest) block.getState();
        ItemStack[] chestContents = chest.getBlockInventory().getContents();

        for (int i = 0; i < chestContents.length; i++) {
            // Checks if the item is null
            if (chestContents[i] == null)
                continue;

            ItemStack chestItem = chestContents[i];
            System.out.println(chestItem.getType());
        }

        event.setCancelled(true);
        System.out.println("random thing goes here");
    }
}
