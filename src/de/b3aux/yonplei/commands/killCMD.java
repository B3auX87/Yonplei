package de.b3aux.yonplei.commands;

import de.b3aux.yonplei.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class killCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player) sender;

        if (p.hasPermission("yonplei.slay")) {

            if (args.length == 0) {

                p.setHealth(0);

            }

            if (args.length == 1) {

                if (cmd.getName().equalsIgnoreCase("slay")) {

                    Player t = Bukkit.getPlayer(args[0]);

                    if (t.isOp() || t.hasPermission("yonplei.slay.bypass")) {

                        p.sendMessage(Main.prefix + "§7Du kannst diesen Spieler nicht §cTöten");
                        return true;
                    }

                    t.setHealth(0);
                    p.sendMessage(Main.prefix + "§7 Du hast §c" + t.getName() + "§7 getötet.");

                } else {

                    p.sendMessage(Main.use + "/slay name");

                }
            }

        } else {

            p.sendMessage(Main.noPerms);

        }

        return false;
    }
}
