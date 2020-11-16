package de.b3aux.yonplei.commands;

import de.b3aux.yonplei.main.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class wartungCMD implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player) sender;

        if(cmd.getName().equalsIgnoreCase("wartung")) {

            if((p.hasPermission("yonplei.wartung")) || p.isOp()) {

                if(args.length == 1) {

                    if(args[0].equalsIgnoreCase("true")) {

                        Main.getInstance().wartung = true;
                        p.sendMessage(Main.prefix + "§7Du hast den Wartungs-Modus §aaktiviert!");

                    }

                    if(args[0].equalsIgnoreCase("false")) {

                        Main.getInstance().wartung = false;
                        p.sendMessage(Main.prefix + "§7Du hast den Wartungs-Modus §cdeaktiviert!");

                    }

                    Main.getInstance().file.set("Wartung.Status", Main.getInstance().wartung);
                    Main.getInstance().file.saveConfig();

                    return true;

                } else {

                    p.sendMessage(Main.use + "wartung true/false");

                }

                return false;

            } else {

                p.sendMessage(Main.noPerms);

            }

            return false;
        }

        return false;
    }
}
