package de.b3aux.yonplei.commands;

import de.b3aux.yonplei.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class tphereCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player) sender;

        if (p.hasPermission("yonplei.tphere")) {

            if (args.length == 1) {

                Player t = Bukkit.getPlayer(args[0]);

                if (t != null) {

                    t.teleport(p);
                    p.sendMessage(Main.prefix + "§7Du hast §3" + t.getName() + "§7 teleportiert.");
                    t.sendMessage(Main.prefix + "§7Du wurdest zu §3" + p.getName() + "§7 teleportiert.");

                } else {

                    p.sendMessage(Main.playerNotOnline);

                }

            } else {

                p.sendMessage(Main.use + "/tphere name");

            }

        } else {

            p.sendMessage(Main.noPerms);

        }

        return true;
    }
}
