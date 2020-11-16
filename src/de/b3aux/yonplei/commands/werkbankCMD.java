package de.b3aux.yonplei.commands;

import de.b3aux.yonplei.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class werkbankCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player) sender;

        if (args.length == 0) {

            if (p.hasPermission("yonplei.werkbank")) {

                p.openWorkbench(p.getLocation(), true);

            } else {

                p.sendMessage(Main.noPerms);;

            }

        }else if (args.length == 1) {

            if (p.hasPermission("yonplei.werkbank.other")) {

                Player t = Bukkit.getServer().getPlayerExact(args[0]);

                t.openWorkbench(t.getLocation(), true);

            } else {

                p.sendMessage(Main.noPerms);

            }

        } else {

            p.sendMessage(Main.use + "/wb <Name>");
        }

        return false;

    }
}
