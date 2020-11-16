package de.b3aux.yonplei.commands;

import de.b3aux.yonplei.main.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class returnCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player) sender;

        if (p.hasPermission("yonplei.return")) {

            if (args.length >= 1) {

                Player t = Main.msg.get(p);

                if (!t.isOnline()) {

                    p.sendMessage(Main.playerNotOnline);

                }

                int i = 0;

                String msg = "";

                while (i < args.length) {

                    msg = msg + args[i] + " ";

                    i ++;

                }

                if (!Main.msg.containsKey(t)) {

                    p.sendMessage(Main.prefix + "§7 Es gibt keinen Spieler den du Antworten könntest.");

                }

                p.sendMessage("§7Du §6>> §c" + t.getName() + "§7: " + msg);
                t.sendMessage("§c" + p.getName() + " §6>> §7Dir: §7" + msg);

            } else {

                p.sendMessage(Main.use + "/r text");

            }

        } else {

            p.sendMessage(Main.noPerms);

        }

        return true;
    }
}
