package com.tenjava.entries.joaopms.t1.event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleDamageEvent;

public class VehicleUpgradeClick implements Listener {
    @EventHandler
    public void vehicleDamageEvent(VehicleDamageEvent event) {
        // Check if the attacker is a player
        if (!(event.getAttacker() instanceof Player))
            return;

        event.setCancelled(true);
        System.out.println("ATTACKED BABYY");
    }
}
