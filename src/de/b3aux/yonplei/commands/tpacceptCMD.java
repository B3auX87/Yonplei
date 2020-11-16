package de.b3aux.yonplei.commands;

import de.b3aux.yonplei.main.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class tpacceptCMD implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {

            Player p = (Player)sender;

            if (p.hasPermission("yonplei.tpaccept")) {

                if (args.length == 0) {

                    Player p2 = (Player) Main.tpa.get(p);
                    p2.teleport(p.getLocation());
                    p.sendMessage(Main.prefix + "§eTeleportiert");
                    p2.sendMessage(Main.prefix + "§eTeleportiert");

                } else {

                    p.sendMessage(Main.use + "/tpaccept");

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
