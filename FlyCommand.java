package de.lowtime.yt.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {
    private boolean flymode = false;

    public FlyCommand() {
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player)sender;
            if (player.hasPermission("Fly.Command")) {
                if (command.getName().equalsIgnoreCase("Fly")) {
                    if (!this.flymode) {
                        player.setAllowFlight(true);
                        this.flymode = true;
                        player.sendMessage("§aEvent System | §2You´re yet in the Flymode!");
                    } else {
                        player.setAllowFlight(false);
                        this.flymode = false;
                        player.sendMessage("§aEvent System | §2Flymode disabled!");
                    }
                }
            } else {
                player.sendMessage("§aEvent System | §cYou have not the Permission to execute the Command!");
            }
        } else {
            sender.sendMessage("§aEvent System | §cYou´re not a Player!");
        }

        return false;
    }
}
