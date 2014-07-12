package com.tenjava.entries.joaopms.t1.command;

import com.tenjava.entries.joaopms.t1.upgrade.Upgrade;
import com.tenjava.entries.joaopms.t1.upgrade.UpgradeManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class UpgradeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String prefix, String[] args) {
        commandSender.sendMessage("§2§lAVAILABLE VEHICLE UPGRADES");
        for (Upgrade upgrade : UpgradeManager.getUpgrades())
            commandSender.sendMessage("§2§l>> §a" + upgrade.getName());

        return true;
    }
}
