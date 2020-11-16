package de.b3aux.yonplei.commands;

import de.b3aux.yonplei.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class tpaCMD implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {

            Player p = (Player)sender;

            if (p.hasPermission("yonplei.tpa")) {

                if (args.length == 1) {

                    try {

                        Player p2 = Bukkit.getPlayer(args[0]);
                        Main.tpa.put(p2, p);

                        p2.sendMessage(Main.prefix + "§3" + p.getName() + "§7 möchte sich zu dir Teleportieren. Tippe §e/tpaccept §7um zu akzeptieren.");
                        p.sendMessage(Main.prefix + "§7Du hast eine §eTPA §7zu §3" + p2.getName() + " §7geschickt");

                    } catch (Exception ex) {

                        p.sendMessage(Main.noPerms);

                    }

                } else {

                    p.sendMessage(Main.use + "/tpa <player>");

                }

            } else {

                p.sendMessage(Main.noPerms);

            }

        } else {

            sender.sendMessage(Main.noPlayer);

        }

        return false;
    }
}
