package de.lowtime.yt.commands;

import de.lowtime.yt.Main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityCategory;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class CursedPickaxeCommand implements CommandExecutor {
    @Override
    public boolean onCommand( CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player){
            Player player =(Player)commandSender;
            commandSender.sendMessage(ChatColor.AQUA + "§aEvent System | You have given yourself the cursed pickaxe!");
            ItemStack stack = new ItemStack(Material.NETHERITE_PICKAXE);
            ItemMeta meta = stack.getItemMeta();
            meta.setDisplayName(ChatColor.BLUE + "Pickaxe from the " + ChatColor.RED + "Cursed");
            ArrayList<String> lore = new ArrayList<>();
            lore.add("");
            lore.add(ChatColor.GRAY + ">>  Pickaxe from the §aCursed!");
            lore.add(ChatColor.GRAY + ">> How it was made?");
            lore.add("§7>> ");
            lore.add(ChatColor.GRAY + ">> It was made by the trolls of the Cursed");
            lore.add("§7>> ");
            lore.add("§7>> §3§lRARE ITEM");
            lore.add("§7>> ");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.CHANNELING, 1, true);
            meta.setUnbreakable(false);
            stack.setItemMeta(meta);
            player.getInventory().addItem(stack);

        }else {
            commandSender.sendMessage(Main.getPrefix() + "§aEvent System | §cYou´re not a Player!");

        }



        return false;
    }
}