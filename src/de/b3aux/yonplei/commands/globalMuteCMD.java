package de.b3aux.yonplei.commands;

import de.b3aux.yonplei.main.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class globalMuteCMD implements CommandExecutor {

    public static boolean globalmute = false;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(!(sender instanceof Player)) {

            sender.sendMessage("Du musst ein Spieler sein!");

        } else {

            Player p = (Player)sender;

            if(!(p.hasPermission("yonplei.gmute"))) {

                p.sendMessage(Main.noPerms);
                return true;

            }

            if(globalmute) {

                globalmute = false;
                p.sendMessage(Main.prefix + "§7 Der Globale Chat wurde von §c" + sender.getName() + " §7aktiviert");

            } else {

                globalmute = true;
                p.sendMessage(Main.prefix + "§7 Der Globale chat wurde von §c" + sender.getName() + " §7deaktiviert!");

            }
        }

        return true;

    }
}
