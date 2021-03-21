package de.lowtime.yt.events;

import de.lowtime.yt.ItemManager;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.*;

public class Commands implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use that command");
            return true;
        }
        final Player player = (Player)sender;
        if (player.hasPermission("op")) {
            if (args.length > 0) {

                if (args[0].equalsIgnoreCase("grapplinghook")) {
                    player.getInventory().addItem(new ItemStack[] { ItemManager.GrapplingHook });
                }
            }
        }
        else {
            sender.sendMessage("You are not allowed to use this command");
        }
        return true;
    }
}
