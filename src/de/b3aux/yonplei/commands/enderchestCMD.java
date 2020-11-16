package de.b3aux.yonplei.commands;

import de.b3aux.yonplei.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.UUID;

public class enderchestCMD implements CommandExecutor {

    public static ArrayList<UUID> enderchest = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player) sender;

        if (args.length == 0) {

            if (p.hasPermission("yonplei.enderchest")) {

                p.openInventory(p.getEnderChest());
                p.playSound(p.getLocation(), Sound.BLOCK_CHEST_OPEN, 10F, 10F);

            } else {

                p.sendMessage(Main.noPerms);

            }

        } else if (args.length == 1) {

            if (p.hasPermission("yonplei.enderchest.other")) {

                Player t = Bukkit.getPlayer(args[0]);

                if (t == null) {

                    p.sendMessage(Main.playerNotOnline);

                    return true;

                }

                p.openInventory(t.getEnderChest());
                p.playSound(p.getLocation(), Sound.BLOCK_CHEST_OPEN, 10F, 10F);
                p.sendMessage(Main.prefix + "§7Du hast die EnderChest von §3" + t.getName() + " §7geöffnet.");

                enderchest.contains(p.getUniqueId());

            } else {

                p.sendMessage(Main.noPerms);

            }
        }

        return false;
    }
}
