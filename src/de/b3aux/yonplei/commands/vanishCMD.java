package de.b3aux.yonplei.commands;

import de.b3aux.yonplei.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class vanishCMD implements CommandExecutor {

    public static List<Player> vanished = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player) sender;



            if (args.length == 0) {

                if (p.hasPermission("yonplei.vanish")) {

                    if (vanished.contains(p)) {

                        vanished.remove(p);

                        p.sendMessage(Main.prefix + "§7Du bist jetzt §6Sichtbar.");

                        for (Player all : Bukkit.getOnlinePlayers()) {

                            all.showPlayer(p);

                        }

                    } else {

                        vanished.add(p);

                        p.sendMessage(Main.prefix + "§7Du bist jetzt §6Unsichtbar.");
                        Bukkit.getServer().broadcastMessage("§7[§c-§7] " + p.getName());

                        for (Player all : Bukkit.getOnlinePlayers()) {

                            if (!all.hasPermission("yonplei.vanish.see")) {

                                all.hidePlayer(p);

                            }
                        }
                    }
                } else {

                    p.sendMessage(Main.noPerms);

                }

            } else if (args.length == 1) {

                if (p.hasPermission("yonplei.vanish.other")) {

                    Player t = Bukkit.getServer().getPlayerExact(args[0]);

                    if (vanished.contains(t)) {

                        vanished.remove(t);

                        for (Player all : Bukkit.getOnlinePlayers()) {

                            all.showPlayer(t);

                        }

                        t.sendMessage(Main.prefix + "§7Du bist von §6" + p.getName() + " §7aus dem Vanish geholt worden!");
                        p.sendMessage(Main.prefix + "§7Du hast §6" + t.getName() + " §7aus dem Vanish geholt!");

                    } else {

                        vanished.add(t);

                        t.sendMessage(Main.prefix + "§7Du bist von §6" + p.getName() + " §7ins Vanish gesetzt worden!");
                        p.sendMessage(Main.prefix + "§7Du hast §6" + t.getName() + " §7ins Vanish gesetzt!");

                        for (Player all : Bukkit.getOnlinePlayers()) {

                            if (!all.hasPermission("yonplei.vanish.see")) {

                                all.hidePlayer(t);

                            }
                        }
                    }

                } else {

                    p.sendMessage(Main.noPerms);

                }

            } else {

                p.sendMessage(Main.use = "/vanish <name>");

            }

        return false;
    }
}
