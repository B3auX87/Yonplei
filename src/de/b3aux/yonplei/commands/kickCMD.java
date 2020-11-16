package de.b3aux.yonplei.commands;

import de.b3aux.yonplei.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class kickCMD implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        final Player p = ((Player) sender);

        if(p.hasPermission("yonplei.kick")){

            if (args.length <= 2) {

                p.sendMessage(Main.use + "/bye <name> [Grund]");

            }

            if(args.length >= 2){

                final Player t = Bukkit.getPlayer(args[0]);

                if(t != null){

                    StringBuilder stringBuilder = new StringBuilder();

                    for (int i = 1; i < args.length; i++){

                        stringBuilder.append(args[i]).append(" ");

                    }

                    t.kickPlayer(stringBuilder.toString().replace('&', '§'));

                    p.sendMessage(Main.prefix + "§7Du hast den Spieler §e" + t.getName() + " §7erfolgreich gekickt.  §8[§7" + stringBuilder.toString().replace('&', '§') + "§8]");

                }else{

                    p.sendMessage(Main.playerNotOnline);

                }
            }

        }else{

            p.sendMessage(Main.noPerms);

        }

        return false;
    }
}
