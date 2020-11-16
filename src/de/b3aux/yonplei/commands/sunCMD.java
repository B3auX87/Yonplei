package de.b3aux.yonplei.commands;

import de.b3aux.yonplei.main.Main;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class sunCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player) sender;

        if (p.hasPermission("yonplei.sun")) {

            if (args.length == 0) {

                World wld = p.getWorld();

                wld.setStorm(false);
                wld.setThundering(false);

                p.sendMessage(Main.prefix + "§7Es scheint jetzt die §eSonne!");

            }

        } else {

            p.sendMessage(Main.noPerms);

        }

        return true;
    }
}
