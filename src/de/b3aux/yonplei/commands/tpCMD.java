package de.b3aux.yonplei.commands;

import de.b3aux.yonplei.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class tpCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player) sender;
        Player t = Bukkit.getPlayer(args[0]);

        if (p.hasPermission("yonplei.tp")) {

            if (args.length == 1) {

                if (t != null) {

                    if (p != t) {

                        p.teleport(t);

                        p.sendMessage(Main.prefix + "§7Du hast dich erfolgreich zu §3" + t.getName() + " §7teleportiert.");

                    } else {

                        p.sendMessage(Main.prefix + "§7Du kannst dich nicht zu dir selbst teleportieren.");

                    }

                } else {

                    p.sendMessage(Main.playerNotOnline);

                }

            } else {

                p.sendMessage(Main.use + "§6/tp name.");

            }

        } else {

            p.sendMessage(Main.noPerms);

        }
        return true;
    }
}
