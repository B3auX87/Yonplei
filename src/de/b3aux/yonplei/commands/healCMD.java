package de.b3aux.yonplei.commands;

import de.b3aux.yonplei.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class healCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(!(sender instanceof Player)) {

            sender.sendMessage(Main.noPlayer);
            return true;
        }

        Player player = (Player) sender;

        if(args.length == 0) {

            if (player.hasPermission("Yonplei.heal")) {

                player.setHealth(20d);
                player.setFoodLevel(20);
                player.sendMessage(Main.prefix + "§7Du wurdest geheilt.");
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 0.2f, 1.2f);

            }  else {

                player.sendMessage(Main.noPerms);
                player.playSound(player.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 0.2f, 1.4f);

            }

        } else if (args.length == 1) {

            if (player.hasPermission("yonplei.heal.other")) {

                Player t = Bukkit.getServer().getPlayer(args[0]);

                t.setHealth(20d);
                t.setFoodLevel(20);
                t.sendMessage(Main.prefix + "§7Du wurdest von §6" + player.getName() + "§7 geheilt.");
                t.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 0.2f, 1.2f);
                player.sendMessage(Main.prefix + "§7Du hast §6" + t.getName() + "§7 geheilt.");
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 0.2f, 1.2f);

            }
        }

        return true;
    }
}
