package de.b3aux.yonplei.commands;

import de.b3aux.yonplei.main.Main;
import de.b3aux.yonplei.methoden.playerData;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class muteCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player) sender;

        if (p.hasPermission("yonplei.mute")) {

            if (args.length < 2) {

                p.sendMessage(Main.use + "/mute name grund");

                return true;

            } else {

                Player t = Bukkit.getServer().getPlayer(args [0]);

                if (t == null) {

                    p.sendMessage(Main.playerNotOnline);

                    return true;

                }

                playerData data = new playerData(t.getUniqueId());

                data.setMuted(true);

                String reason = "";

                for ( int i = 1; i < args.length; i ++) {

                    reason = reason + " " + args[i];

                }

                reason = reason.trim();

                if (reason != null) {

                    p.sendMessage(Main.prefix + "§7Du hast erfolgreich §3" + t.getName() + " §7gemutet.");
                    t.sendMessage("§cDu wurdest von §4" + p.getName() + " §cgemutet!");
                    t.sendMessage("§e>> §3" + (reason.isEmpty() ? "" : "§7 Grund: §3" + reason));

                    return true;

                } else {

                    p.sendMessage(Main.prefix + "§7Bitte gebe einen Grund an.");

                }
            }

        } else {

            p.sendMessage(Main.noPerms);

        }

        return false;
    }
}
