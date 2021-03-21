package de.lowtime.yt.util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import javax.swing.plaf.basic.BasicButtonUI;

public class ScoreboardUtils {

    public static Scoreboard getBaseScoreboard(Player player){
        Scoreboard s = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective objective = s.registerNewObjective("main" , "main" , "§aInformations - Server");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.getScore("").setScore(0);
        objective.getScore("§a").setScore(1);
        objective.getScore("Your Life:").setScore(3);
        objective.getScore("§c").setScore(4);
        objective.getScore(player.isOp() ? "§cAdmin" : "§7Player").setScore(5);
        objective.getScore("Your Rank:").setScore(6);
        objective.getScore("§b").setScore(7);
        objective.getScore("").setScore(0);


        Team t = s.registerNewTeam("life");
        t.addEntry(ChatColor.AQUA + "" + ChatColor.RED);
        objective.getScore(ChatColor.AQUA + "" + ChatColor.RED).setScore(2);

        t.setPrefix("§a" + Math.round(player.getHealth() * 100 /100));


        return s;
    }
}
