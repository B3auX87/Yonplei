package de.b3aux.yonplei.commands;

import de.b3aux.yonplei.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class flyCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player) sender;

        if (args.length == 0) {

            if (p.hasPermission("yonplei.fly")) {

                if (p.getAllowFlight()) {

                    p.setAllowFlight(false);
                    p.setFlying(false);
                    p.sendMessage(Main.prefix + "§7Du kannst nicht mehr §eFliegen.");
                    return true;

                } else {

                    p.setAllowFlight(true);
                    p.setFlying(true);
                    p.sendMessage(Main.prefix + "§7Du kannst jetzt §eFliegen.");

                }

                return true;

            } else {

                p.sendMessage(Main.noPerms);

            }


        } else if (args.length == 1) {

            if (p.hasPermission("yonplei.fly.other")) {

                Player t = Bukkit.getPlayerExact(args[0]);

                if (t == null) {

                    p.sendMessage(Main.playerNotOnline);

                }

                if (t.getAllowFlight()) {

                    t.setAllowFlight(false);
                    t.setFlying(false);

                    t.sendMessage(Main.prefix + "§7Du kannst nicht mehr §eFliegen.");
                    p.sendMessage(Main.prefix + "§7Der Spieler §3" + t.getName() + " §7kann nicht mehr §eFliegen.");
                    return true;

                } else {

                    t.setAllowFlight(true);
                    t.setFlying(true);

                    t.sendMessage(Main.prefix + "§7Du kannst nun §eFliegen.");
                    p.sendMessage(Main.prefix + "§7Der Spieler §3" + t.getName() + " §7kann nun §eFliegen.");

                }

            }  else {

                p.sendMessage(Main.noPerms);

            }
        }

        return false;

    }
}
