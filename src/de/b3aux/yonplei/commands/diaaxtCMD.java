package de.b3aux.yonplei.commands;

import de.b3aux.yonplei.main.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class diaaxtCMD implements CommandExecutor {

    public static ArrayList<Player> diaaxt = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player) sender;

        if (p.hasPermission("yonplei.woodpacker")) {

            if (args.length == 0) {

                p.sendMessage(Main.use + "/break an/aus");

            }

            if (args.length == 1) {

                if (args[0].equalsIgnoreCase("an")) {

                    if (diaaxt.contains(p)) {

                        p.sendMessage(Main.prefix + "§7Du hast den §cBaum Break §7schon angestellt.");
                        return true;

                    }

                    diaaxt.add(p);
                    p.sendMessage(Main.prefix + "§7Du hast den §9Baum Break §7jetzt angestellt.");

                } else if (args[0].equalsIgnoreCase("aus")) {

                    if (!diaaxt.contains(p)) {

                        p.sendMessage(Main.prefix + "§c7Du hast den §cBaum Break §7noch nicht angestellt.");
                        return true;

                    }

                    diaaxt.remove(p);
                    p.sendMessage(Main.prefix + "§7Du hast den §9Baum Break §7jetzt ausgestellt.");


                } else { p.sendMessage(Main.use + "/break an/aus"); }
            }

        } else { p.sendMessage(Main.noPerms); }

        return false;
    }
}
