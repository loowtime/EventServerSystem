package de.lowtime.yt.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class DevCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        String message = "§aEvent System |  The Developer is §6lowtime §afrom the Plugin.";


        sender.sendMessage(message);
        return false;
    }
}
