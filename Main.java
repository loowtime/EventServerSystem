package de.lowtime.yt;

import de.lowtime.yt.Gui.ExampleGui;
import de.lowtime.yt.commands.*;
import de.lowtime.yt.commands.listeners.JoinListener;
import de.lowtime.yt.commands.listeners.LeaveListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Listener;

public final class Main extends JavaPlugin implements Listener {


    private static Main plugin;
    private String prefix;

    @Override
    public void onEnable() {

        getLogger().info("lowtime Plugin enabled!");
        getCommand("timer").setExecutor(new TimerCommand());
        getCommand("dev").setExecutor(new DevCommand());
        getCommand("webside").setExecutor(new WebsiteCommand());
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("cursedaxt").setExecutor(new CursedAxtCommand());
        getCommand("cursedweapon").setExecutor(new CursedWeaponCommand());
        getCommand("cursedpickaxe").setExecutor(new CursedPickaxeCommand());
        getCommand("gui").setExecutor(new ExampleGui());
        getCommand("heal").setExecutor(new HealCommand());
        getCommand("wonderfulbanana").setExecutor(new WonderfulBananaCommand());
        getCommand("wonderfulavocado").setExecutor(new WonderfulAvocadoCommand());
        this.loadConfiguration();
        this.prefix = translateColor(this.getConfig().getString("messages.prefix"));
        final CommandSender cmd = (CommandSender)this.getServer().getConsoleSender();
        final PluginDescriptionFile pdf = this.getDescription();



        ConsoleCommandSender console = Bukkit.getConsoleSender();
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("§8[]==============[§6EventServerSystem§8]==============[]");
        Bukkit.getConsoleSender().sendMessage("§8|                                             §8|");
        Bukkit.getConsoleSender().sendMessage("§8|                  §bInformation                §8|");
        Bukkit.getConsoleSender().sendMessage("§8|                                             §8|");
        Bukkit.getConsoleSender().sendMessage("§8|  §bName: §6EventServer                        §8|");
        Bukkit.getConsoleSender().sendMessage("§8|                                             §8|");
        Bukkit.getConsoleSender().sendMessage("§8|  §bVersion: §1.6                               §8|");
        Bukkit.getConsoleSender().sendMessage("§8|                                             §8|");
        Bukkit.getConsoleSender().sendMessage("§8[]=================[§aActivated§8]===============[]");
        Bukkit.getConsoleSender().sendMessage("");


        PluginManager manager = Bukkit.getPluginManager();
        manager.registerEvents(new JoinListener(), this);
        manager.registerEvents(new LeaveListener(), this);


    }

    public static String getPrefix() {

        return ChatColor.GRAY + "[" + ChatColor.BLUE + "§aEvent System | " + ChatColor.GRAY + "] ";
    }


    public void registerEvents() {
        PluginManager pm = Bukkit.getServer().getPluginManager();
        pm.registerEvents(new JoinListener(), this);
        pm.registerEvents(new LeaveListener(), this);
}

    @Override
    public void onDisable() {
        ConsoleCommandSender console = Bukkit.getConsoleSender();
        Bukkit.getConsoleSender().sendMessage("§8[]==============[§6EventServerSystem§8]==============[]");
        Bukkit.getConsoleSender().sendMessage("§8|                                             §8|");
        Bukkit.getConsoleSender().sendMessage("§8|                  §bInformation                §8|");
        Bukkit.getConsoleSender().sendMessage("§8|                                             §8|");
        Bukkit.getConsoleSender().sendMessage("§8|  §bName: §6EventServer                        §8|");
        Bukkit.getConsoleSender().sendMessage("§8|                                             §8|");
        Bukkit.getConsoleSender().sendMessage("§8|  §bVersion: §1.6                               §8|");
        Bukkit.getConsoleSender().sendMessage("§8|                                             §8|");
        Bukkit.getConsoleSender().sendMessage("§8[]=================[§aDisabled§8]===============[]");
        getCommand("timer").setExecutor(new TimerCommand());
        getCommand("dev").setExecutor(new DevCommand());
        getCommand("webside").setExecutor(new WebsiteCommand());
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("cursedaxt").setExecutor(new CursedAxtCommand());
        getCommand("cursedweapon").setExecutor(new CursedWeaponCommand());
        getCommand("cursedpickaxe").setExecutor(new CursedPickaxeCommand());
        getCommand("gui").setExecutor(new ExampleGui());
        getCommand("heal").setExecutor(new HealCommand());
        getCommand("banana").setExecutor(new WonderfulBananaCommand());

        PluginManager manager = Bukkit.getPluginManager();
        manager.registerEvents(new JoinListener(), this);
        manager.registerEvents(new LeaveListener(), this);


    }



    private void loadConfiguration() {
        this.getConfig().addDefault("#", (Object) "Doun't edit this!  Player 1 = %player%    Player 2 = %target%");
        this.getConfig().addDefault("messages.prefix", (Object) "&8[&bEventSystem&8]");
        this.getConfig().addDefault("messages.no-perm", (Object) "&cYou have no Permission to use that!");
        this.getConfig().addDefault("messages.use", (Object) "&cBitte benutze /gm 0,1,2,3");
        this.getConfig().addDefault("messages.player-offline", (Object) "&6That Player is not online!");
        this.getConfig().addDefault("messages.other-player", (Object) "&cPlease choose another Player!");
        this.getConfig().addDefault("gamemode.Survival", (Object) "&aYour Gamemode ahs update to &6\u00dcberleben &age\u00e4ndert");
        this.getConfig().addDefault("gamemode.Creativ", (Object) "&aDein Spielmodus wurde zu &6Kreativ &age\u00e4ndert");
        this.getConfig().addDefault("gamemode.Adventure", (Object) "&aYour Gamemode is yet &6Abenteurer &age\u00e4ndert");
        this.getConfig().addDefault("gamemode.Spectator", (Object) "&aYour Gamemode is yet &6Spectator &age\u00e4ndert");
        this.getConfig().addDefault("Gamemode-Other-me.Survival", (Object) "&a&aYour Gamemode is yet from &6%player% &azu \u00dcberleben ge\u00e4ndert");
        this.getConfig().addDefault("Gamemode-Other-me.Creativ", (Object) "&a&aYour Gamemode is yet from &6%player% &azu Kreativ ge\u00e4ndert");
        this.getConfig().addDefault("Gamemode-Other-me.Adventure", (Object) "&a&aYour Gamemode is yet from &6%player% &azu Abendteurer ge\u00e4ndert");
        this.getConfig().addDefault("Gamemode-Other-me.Spectator", (Object) "&a&aYour Gamemode is yet from &6%player% &azu Spectator ge\u00e4ndert");
        this.getConfig().addDefault("Gamemode-Other.Survival", (Object) "&aYour Gamemode is yet from &6%target% &azu \u00dcberleben ge\u00e4ndert");
        this.getConfig().addDefault("Gamemode-Other.Creativ", (Object) "&aYour Gamemode is yet from &6%target% &azu Kreativ ge\u00e4ndert");
        this.getConfig().addDefault("Gamemode-Other.Adventure", (Object) "&aYour Gamemode is yet from &6%target% &azu Abendteurer ge\u00e4ndert");
        this.getConfig().addDefault("Gamemode-Other.Spectator", (Object) "&a&aYour Gamemode is yet from &6%target% &azu Spectator ge\u00e4ndert");
        this.getConfig().options().copyDefaults(true);
        this.saveConfig();
        this.reloadConfig();
    }

    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        boolean result = true;
        if (cmd.getName().equalsIgnoreCase("gamemode") || cmd.getName().equalsIgnoreCase("gm")) {
            if (sender instanceof Player) {
                final Player p = (Player) sender;
                if (!p.hasPermission("gamemode.gamemode")) {
                    sender.sendMessage(String.valueOf(this.prefix) + " " + translateColor(this.getConfig().getString("messages.no-perm")));
                    result = false;
                } else {
                    if (args.length == 0) {
                        p.sendMessage(String.valueOf(this.prefix) + " " + translateColor(this.getConfig().getString("messages.use")));
                    }
                    if (args.length == 1) {
                        if (args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("\u00fcberleben") || args[0].equalsIgnoreCase("survival")) {
                            p.setGameMode(GameMode.SURVIVAL);
                            p.sendMessage(String.valueOf(this.prefix) + " " + translateColor(this.getConfig().getString("gamemode.Survival")));
                        }
                        if (args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("Kreativ")) {
                            p.setGameMode(GameMode.CREATIVE);
                            p.sendMessage(String.valueOf(this.prefix) + " " + translateColor(this.getConfig().getString("gamemode.Creativ")));
                        }
                        if (args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("abendteurer") || args[0].equalsIgnoreCase("abendteurer")) {
                            p.setGameMode(GameMode.ADVENTURE);
                            p.sendMessage(String.valueOf(this.prefix) + " " + translateColor(this.getConfig().getString("gamemode.Adventure")));
                        }
                        if (args[0].equalsIgnoreCase("3") || args[0].equalsIgnoreCase("spectator")) {
                            p.setGameMode(GameMode.SPECTATOR);
                            p.sendMessage(String.valueOf(this.prefix) + " " + translateColor(this.getConfig().getString("gamemode.Spectator")));
                        }
                        if (args[0].equalsIgnoreCase("s") || args[0].equalsIgnoreCase("\u00fcberleben") || args[0].equalsIgnoreCase("survival")) {
                            p.setGameMode(GameMode.SURVIVAL);
                            p.sendMessage(String.valueOf(this.prefix) + " " + translateColor(this.getConfig().getString("gamemode.Survival")));
                        }
                        if (args[0].equalsIgnoreCase("c") || args[0].equalsIgnoreCase("Kreativ")) {
                            p.setGameMode(GameMode.CREATIVE);
                            p.sendMessage(String.valueOf(this.prefix) + " " + translateColor(this.getConfig().getString("gamemode.Creativ")));
                        }
                        if (args[0].equalsIgnoreCase("a") || args[0].equalsIgnoreCase("abendteurer") || args[0].equalsIgnoreCase("abendteurer")) {
                            p.setGameMode(GameMode.ADVENTURE);
                            p.sendMessage(String.valueOf(this.prefix) + " " + translateColor(this.getConfig().getString("gamemode.Adventure")));
                        }
                        if (args[0].equalsIgnoreCase("spec") || args[0].equalsIgnoreCase("spectator")) {
                            p.setGameMode(GameMode.SPECTATOR);
                            p.sendMessage(String.valueOf(this.prefix) + " " + translateColor(this.getConfig().getString("gamemode.Spectator")));
                        }
                    }
                    if (args.length == 2) {
                        if (!p.hasPermission("gamemode.gamemode.other")) {
                            p.sendMessage(String.valueOf(this.prefix) + " " + translateColor(this.getConfig().getString("messages.no-perm")));
                            result = false;
                        } else {
                            final Player target = this.getServer().getPlayer(args[1]);
                            if (target == null) {
                                p.sendMessage(String.valueOf(this.prefix) + " " + translateColor(this.getConfig().getString("messages.player-offline")));
                                result = false;
                            } else if (p == target) {
                                p.sendMessage(String.valueOf(this.prefix) + " " + translateColor(this.getConfig().getString("messages.other-player")));
                                result = false;
                            } else {
                                if (args[0].equalsIgnoreCase("0")) {
                                    target.setGameMode(GameMode.SURVIVAL);
                                    target.sendMessage(String.valueOf(this.prefix) + " " + translateColor(this.getConfig().getString("Gamemode-Other-me.Survival").replace("%player%", p.getName())));
                                    p.sendMessage(String.valueOf(this.prefix) + " " + translateColor(this.getConfig().getString("Gamemode-Other.Survival").replace("%target%", target.getName())));
                                }
                                if (args[0].equalsIgnoreCase("1")) {
                                    target.setGameMode(GameMode.CREATIVE);
                                    target.sendMessage(String.valueOf(this.prefix) + " " + translateColor(this.getConfig().getString("Gamemode-Other-me.Creativ").replace("%player%", p.getName())));
                                    p.sendMessage(String.valueOf(this.prefix) + " " + translateColor(this.getConfig().getString("Gamemode-Other.Creativ").replace("%target%", target.getName())));
                                }
                                if (args[0].equalsIgnoreCase("2")) {
                                    target.setGameMode(GameMode.ADVENTURE);
                                    target.sendMessage(String.valueOf(this.prefix) + " " + translateColor(this.getConfig().getString("Gamemode-Other-me.Adventure").replace("%player%", p.getName())));
                                    p.sendMessage(String.valueOf(this.prefix) + " " + translateColor(this.getConfig().getString("Gamemode-Other.Adventure").replace("%target%", target.getName())));
                                }
                                if (args[0].equalsIgnoreCase("3")) {
                                    target.setGameMode(GameMode.SPECTATOR);
                                    target.sendMessage(String.valueOf(this.prefix) + " " + translateColor(this.getConfig().getString("Gamemode-Other-me.Spectator").replace("%player%", p.getName())));
                                    p.sendMessage(String.valueOf(this.prefix) + " " + translateColor(this.getConfig().getString("Gamemode-Other.Spectator").replace("%target%", target.getName())));
                                }
                                if (args[0].equalsIgnoreCase("s")) {
                                    target.setGameMode(GameMode.SURVIVAL);
                                    target.sendMessage(String.valueOf(this.prefix) + " " + translateColor(this.getConfig().getString("Gamemode-Other-me.Survival").replace("%player%", p.getName())));
                                    p.sendMessage(String.valueOf(this.prefix) + " " + translateColor(this.getConfig().getString("Gamemode-Other.Survival").replace("%target%", target.getName())));
                                }
                                if (args[0].equalsIgnoreCase("c")) {
                                    target.setGameMode(GameMode.CREATIVE);
                                    target.sendMessage(String.valueOf(this.prefix) + " " + translateColor(this.getConfig().getString("Gamemode-Other-me.Creativ").replace("%player%", p.getName())));
                                    p.sendMessage(String.valueOf(this.prefix) + " " + translateColor(this.getConfig().getString("Gamemode-Other.Creativ").replace("%target%", target.getName())));
                                }
                                if (args[0].equalsIgnoreCase("a")) {
                                    target.setGameMode(GameMode.ADVENTURE);
                                    target.sendMessage(String.valueOf(this.prefix) + " " + translateColor(this.getConfig().getString("Gamemode-Other-me.Adventure").replace("%player%", p.getName())));
                                    p.sendMessage(String.valueOf(this.prefix) + " " + translateColor(this.getConfig().getString("Gamemode-Other.Adventure").replace("%target%", target.getName())));
                                }
                                if (args[0].equalsIgnoreCase("spec")) {
                                    target.setGameMode(GameMode.SPECTATOR);
                                    target.sendMessage(String.valueOf(this.prefix) + " " + translateColor(this.getConfig().getString("Gamemode-Other-me.Spectator").replace("%player%", p.getName())));
                                    p.sendMessage(String.valueOf(this.prefix) + " " + translateColor(this.getConfig().getString("Gamemode-Other.Spectator").replace("%target%", target.getName())));
                                }
                            }
                        }
                    }
                }
            } else if (args.length == 2) {
                final Player target2 = this.getServer().getPlayer(args[1]);
                if (target2 == null) {
                    sender.sendMessage(String.valueOf(this.prefix) + " " + translateColor(this.getConfig().getString("messages.player-offline")));
                    result = false;
                } else {
                    if (args[0].equalsIgnoreCase("0")) {
                        target2.setGameMode(GameMode.SURVIVAL);
                        target2.sendMessage(String.valueOf(this.prefix) + " " + translateColor(this.getConfig().getString("Gamemode-Other-me.Survival").replace("%player%", sender.getName())));
                        sender.sendMessage(String.valueOf(this.prefix) + " " + translateColor(this.getConfig().getString("Gamemode-Other.Survival").replace("%target%", target2.getName())));
                    }
                    if (args[0].equalsIgnoreCase("1")) {
                        target2.setGameMode(GameMode.CREATIVE);
                        target2.sendMessage(String.valueOf(this.prefix) + " " + translateColor(this.getConfig().getString("Gamemode-Other-me.Creativ").replace("%player%", sender.getName())));
                        sender.sendMessage(String.valueOf(this.prefix) + " " + translateColor(this.getConfig().getString("Gamemode-Other.Creativ").replace("%target%", target2.getName())));
                    }
                    if (args[0].equalsIgnoreCase("2")) {
                        target2.setGameMode(GameMode.ADVENTURE);
                        target2.sendMessage(String.valueOf(this.prefix) + " " + translateColor(this.getConfig().getString("Gamemode-Other-me.Adventure").replace("%player%", sender.getName())));
                        sender.sendMessage(String.valueOf(this.prefix) + " " + translateColor(this.getConfig().getString("Gamemode-Other.Adventure").replace("%target%", target2.getName())));
                    }
                    if (args[0].equalsIgnoreCase("3")) {
                        target2.setGameMode(GameMode.SPECTATOR);
                        target2.sendMessage(String.valueOf(this.prefix) + " " + translateColor(this.getConfig().getString("Gamemode-Other-me.Spectator").replace("%player%", sender.getName())));
                        sender.sendMessage(String.valueOf(this.prefix) + " " + translateColor(this.getConfig().getString("Gamemode-Other.Spectator").replace("%target%", target2.getName())));
                    }
                    if (args[0].equalsIgnoreCase("s")) {
                        target2.setGameMode(GameMode.SURVIVAL);
                        target2.sendMessage(String.valueOf(this.prefix) + " " + translateColor(this.getConfig().getString("Gamemode-Other-me.Survival").replace("%player%", sender.getName())));
                        sender.sendMessage(String.valueOf(this.prefix) + " " + translateColor(this.getConfig().getString("Gamemode-Other.Survival").replace("%target%", target2.getName())));
                    }
                    if (args[0].equalsIgnoreCase("c")) {
                        target2.setGameMode(GameMode.CREATIVE);
                        target2.sendMessage(String.valueOf(this.prefix) + " " + translateColor(this.getConfig().getString("Gamemode-Other-me.Creativ").replace("%player%", sender.getName())));
                        sender.sendMessage(String.valueOf(this.prefix) + " " + translateColor(this.getConfig().getString("Gamemode-Other.Creativ").replace("%target%", target2.getName())));
                    }
                    if (args[0].equalsIgnoreCase("a")) {
                        target2.setGameMode(GameMode.ADVENTURE);
                        target2.sendMessage(String.valueOf(this.prefix) + " " + translateColor(this.getConfig().getString("Gamemode-Other-me.Adventure").replace("%player%", sender.getName())));
                        sender.sendMessage(String.valueOf(this.prefix) + " " + translateColor(this.getConfig().getString("Gamemode-Other.Adventure").replace("%target%", target2.getName())));
                    }
                    if (args[0].equalsIgnoreCase("spec")) {
                        target2.setGameMode(GameMode.SPECTATOR);
                        target2.sendMessage(String.valueOf(this.prefix) + " " + translateColor(this.getConfig().getString("Gamemode-Other-me.Spectator").replace("%player%", sender.getName())));
                        sender.sendMessage(String.valueOf(this.prefix) + " " + translateColor(this.getConfig().getString("Gamemode-Other.Spectator").replace("%target%", target2.getName())));
                    }
                }
            }
        }
        if (result) {
            result = false;
        }
        return result;
    }

    private static String translateColor(final String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}



