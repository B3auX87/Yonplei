package de.b3aux.yonplei.commands;

import de.b3aux.yonplei.main.Main;
import de.b3aux.yonplei.methoden.rdmTPmanager;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class rtpCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player) sender;

        if (p.hasPermission("yonplei.randomtp")) {

            if (args.length == 0) {

                if (p.getWorld().getName().equals("Farmwelt") || p.getWorld().getName().equals("Natur")) {

                    rdmTPmanager.randomTp(p);
                    p.playSound(p.getLocation(), Sound.UI_BUTTON_CLICK, 10F, 10F);

                } else {

                    p.sendMessage(Main.prefix + "§cDazu musst du in einer §eFarmwelt §csein.");

                }

            } else {

                p.sendMessage(Main.prefix + "§7Bitte Tippe: §6/rtp");

            }

        } else {

            p.sendMessage(Main.noPerms);

        }

        return true;

    }
}
