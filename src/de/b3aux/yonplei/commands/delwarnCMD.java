package de.b3aux.yonplei.commands;

import de.b3aux.yonplei.main.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class delwarnCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player) sender;

        if (p.hasPermission("yonplei.delwarn")) {

            if (args.length <= 1) {

                p.sendMessage(Main.use + "/delwarn name anzahl");

            }

            if (args.length == 2) {

                Player t = p.getServer().getPlayer(args[0]);

                int i = Integer.parseInt(args[1]);

                if (getWarns(t) >= 1) {

                    removeWarns(t, i);

                    p.sendMessage(Main.prefix + "§7 Du hast von §c" + t.getName() + " §7, §e" + i + " §7Verwarnung(en) gelöscht.");
                    t.sendMessage(Main.prefix + "§e " + p.getName() + "§7 hat dir §c" + i + " §7Verwarnung(en) gelöscht.");

                }

            }

        } else {

            p.sendMessage(Main.noPerms);

        }

        return false;
    }

    public void removeWarns(Player p, int howmuch) {

        int i = Main.instance.getConfig().getInt("Spieler." + p.getName() + ".Warns");

        i -= howmuch;

        Main.instance.getConfig().set("Spieler." + p.getName() + ".Warns", i);

        Main.instance.saveConfig();

    }

    public Integer getWarns(Player p) {

        int i = Main.instance.getConfig().getInt("Spieler." + p.getName() + ".Warns");

        return i;

    }
}
