package de.b3aux.yonplei.commands;

import de.b3aux.yonplei.main.Main;
import de.b3aux.yonplei.methoden.playerData;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class unmuteCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof ConsoleCommandSender) {

            Player t = Bukkit.getServer().getPlayer(args [0]);

            if (args.length == 0) {

                sender.sendMessage(Main.use + "/unmute name");

                return true;

            }

            if (args.length == 1) {

                if (t == null) {

                    sender.sendMessage(Main.playerNotOnline);

                    return true;

                }

                playerData data = new playerData(t.getUniqueId());

                data.setMuted(false);

                sender.sendMessage(Main.prefix + "§7Du hast erfolgreich §3" + t.getName() + " §7entmutet.");
                t.sendMessage(Main.prefix + "§cDu wurdest von §4" + sender.getName() + " §centmutet!");

                return true;

            }
        }

        Player p = (Player) sender;

        if (p.hasPermission("yonplei.unmute")) {

            Player t = Bukkit.getServer().getPlayer(args [0]);

            if (args.length == 0) {

                p.sendMessage(Main.use + "/unmute name");

                return true;

            }

            if (args.length == 1) {

                if (t == null) {

                    p.sendMessage(Main.playerNotOnline);

                    return true;

                }

                playerData data = new playerData(t.getUniqueId());

                data.setMuted(false);

                p.sendMessage(Main.prefix + "§7Du hast erfolgreich §3" + t.getName() + " §7entmutet.");
                t.sendMessage(Main.prefix + "§cDu wurdest von §4" + p.getName() + " §centmutet!");

                return true;

            }

        } else {

            p.sendMessage(Main.noPerms);

        }

        return false;
    }
}
