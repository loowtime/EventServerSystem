package de.lowtime.yt.commands;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.util.Vector;

public class DuCommand implements CommandExecutor {


    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        e.getPlayer().setAllowFlight(true);
    }

    @EventHandler
    public void onPlayerDoubleJump(PlayerToggleFlightEvent e){
        Player p = e.getPlayer();
        if(p.getGameMode() != GameMode.CREATIVE){
            e.setCancelled(true);
            Block b = p.getWorld().getBlockAt(p.getLocation().subtract(0,2,0));
            if(!b.getType().equals(Material.AIR)){
                Vector v = p.getLocation().getDirection().multiply(1).setY(1);
                p.setVelocity(v);
            }
        }

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        return false;
    }
}
