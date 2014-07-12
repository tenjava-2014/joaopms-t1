package com.tenjava.entries.joaopms.t1.manager;

import com.tenjava.entries.joaopms.t1.TenJava;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

public class PlayerManager {
    private static Map<Player, Boolean> playersBlocking = new HashMap<>();

    /**
     * Registers a player
     *
     * @param player The player to register
     */
    public static void registerPlayer(Player player) {
        playersBlocking.put(player, false);
        TenJava.log(Level.INFO, "PlayerManager > " + player.getName() + " registered");
    }
}
