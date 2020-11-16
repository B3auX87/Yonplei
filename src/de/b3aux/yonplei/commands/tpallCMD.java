package de.b3aux.yonplei.commands;

import de.b3aux.yonplei.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class tpallCMD implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {

            Player p = (Player)sender;

            if (p.hasPermission("yonplei.tpall")) {

                if (args.length == 0) {

                    for (Player all : Bukkit.getOnlinePlayers()) {

                        all.teleport(p.getLocation());
                        all.sendMessage(Main.prefix + p.getName() + "§7hat §5ALLE §7zu sich teleportiert");
                        p.sendMessage(Main.prefix + "§5ALLE §7sind zu dir teleportiert.");
                    }

                } else {

                    p.sendMessage(Main.use + "/tpall");

                }

            } else {

                p.sendMessage(Main.noPerms);

            }

        } else {

            sender.sendMessage(Main.noPlayer);

        }

        return true;
    }
}
