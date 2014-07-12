package com.tenjava.entries.joaopms.t1.event;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class UpgradeCraftEvent implements Listener {
    @EventHandler
    public void chestClick(PlayerInteractEvent event) {
        Action action = event.getAction();

        // Checks if the action is the one we want
        if (action != Action.LEFT_CLICK_BLOCK)
            return;

        // Check if the item is null
        if (event.getItem() == null)
            return;

        System.out.println("random thing goes here");
    }
}
