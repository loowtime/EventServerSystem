package de.lowtime.yt;

import org.bukkit.inventory.*;
import org.bukkit.*;
import java.util.*;
import org.bukkit.inventory.meta.*;

public class ItemManager
{
    Main plugin;
    public static ItemStack GrapplingHook;

    public ItemManager(final Main plugin) {
        this.plugin = plugin;
    }

    public static void init() {
        createGrapplingHook();
    }

    private static void createGrapplingHook() {
        final ItemStack item = new ItemStack(Material.FISHING_ROD, 1);
        final ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§6Grappling Hook");
        final List<String> lore = new ArrayList<String>();
        lore.add("§7Travel in style with this tool...");
        meta.setLore((List)lore);
        item.setItemMeta(meta);
        ItemManager.GrapplingHook = item;
    }
}