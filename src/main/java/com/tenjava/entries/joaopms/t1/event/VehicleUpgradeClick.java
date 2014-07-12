package com.tenjava.entries.joaopms.t1.event;

import org.bukkit.entity.EntityType;
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

        EntityType entityType = event.getVehicle().getType();
        // Check if the vehicle is a Minecart or a Boat
        if (!(entityType == EntityType.MINECART || entityType == EntityType.BOAT))
            return;

        event.setCancelled(true);
        System.out.println("ATTACKED BABYY");
    }
}
