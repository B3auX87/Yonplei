package de.b3aux.yonplei.commands;

import de.b3aux.yonplei.main.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class nightCMD implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player)sender;

        if (p.hasPermission("yonplay.night")) {

            if (args.length != 0) {

                p.sendMessage(Main.prefix + "§7Bitte nur §e/night");

            } else {

                p.getWorld().setTime(13000L);
                p.sendMessage(Main.prefix + "§7Die Zeit wurde auf §eNacht §7gesetzt");

            }

        } else {

            p.sendMessage(Main.noPerms);

        }

        return true;
    }
}
