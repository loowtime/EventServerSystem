package de.lowtime.yt.Gui;

import de.lowtime.yt.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;



public class ExampleGui implements CommandExecutor, Listener {
    @Override
    public boolean onCommand(@NotNull CommandSender s, Command cmd, String label, @NotNull String[] args) {
        if (s instanceof Player) {
            s.sendMessage("§aEvent System | Temporary unavaible! ");
        } else {
            s.sendMessage(Main.getPrefix() + "§aEvent System | You´re not a Player!");

        }
        return false;

    }
}

