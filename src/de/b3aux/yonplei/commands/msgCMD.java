package de.b3aux.yonplei.commands;

import de.b3aux.yonplei.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class msgCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player) sender;

        if (p.hasPermission("yonplei.msg")) {

            if (args.length >= 2) {

                String pn = args[0];
                Player t = Bukkit.getPlayerExact(pn);

                if (!t.isOnline()) {

                    p.sendMessage(Main.playerNotOnline);

                }

                int i = 1;

                String msg = "";

                while (i < args.length) {

                    msg = msg + args[i] + " ";

                    i ++;

                }

                if (Main.msg.containsKey(p)) {

                    Main.msg.remove(p);

                }

                if (Main.msg.containsKey(t)) {

                    Main.msg.remove(t);

                }

                Main.msg.put(p, t);
                Main.msg.put(t, p);

                p.sendMessage("§7Du §e>> §c" + t.getName() + "§7: " + msg);
                t.sendMessage("§c" + p.getName() + " §e>> §7Dir: §7" + msg);

            } else {

                p.sendMessage(Main.use + "/msg name text");

            }

        } else {

            p.sendMessage(Main.noPerms);

        }

        return true;
    }
}
