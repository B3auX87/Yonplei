package de.b3aux.yonplei.commands;

import de.b3aux.yonplei.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class invseeCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("invsee")) {

            if (p.hasPermission("yonplei.invsee")) {

                if (args.length == 0) {

                    p.sendMessage(Main.use + "/invsee §7<Name>");

                }

                if (args.length == 1) {

                    Player t = Bukkit.getPlayerExact(args[0]);

                    if (t != null) {

                        p.openInventory(t.getInventory());
                        p.playSound(p.getLocation(), Sound.BLOCK_CHEST_OPEN, 10F, 10F);

                    } else {

                        p.sendMessage(Main.prefix + "§7 Dieser Spieler ist offline.");

                    }

                } else {

                    p.sendMessage(Main.use + "/invsee name");

                }

            } else {

                p.sendMessage(Main.noPerms);

            }
        }

        return true;

    }
}
