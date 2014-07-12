package com.tenjava.entries.joaopms.t1.event;

import com.tenjava.entries.joaopms.t1.TenJava;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.logging.Level;

public class SwordBlockEvent implements Listener {
    @EventHandler
    public void onSwordBlock(PlayerInteractEvent event) {
        Action action = event.getAction();

        // Check if the item is null
        if (event.getItem() == null)
            return;

        Material material = event.getItem().getType();

        // Check if the action isn't right clicking the air or a block
        if (!(action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK))
            return;

        // Check if the item in question isn't a sword, return
        if (!(material == Material.WOOD_SWORD || material == Material.STONE_SWORD || material == Material.GOLD_SWORD || material == Material.IRON_SWORD || material == Material.DIAMOND_SWORD))
            return;

        TenJava.log(Level.INFO, "Blocking!");
    }
}
