package de.b3aux.yonplei.commands;

import de.b3aux.yonplei.main.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class repairCMD implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player)sender;

        if (p.hasPermission("yonplei.repair")) {

            if (args.length != 0) {

                p.sendMessage(Main.prefix + "§7Bitte nur /repair mit einem Item in der Hand");

            } else {

                ItemStack item = p.getItemInHand();
                item.setDurability((short)0);
                p.getInventory().setItemInHand(item);
                p.sendMessage(Main.prefix + "§7Item repariert");

            }

        } else {

            p.sendMessage(Main.noPerms);

        }

        return true;
    }
}
