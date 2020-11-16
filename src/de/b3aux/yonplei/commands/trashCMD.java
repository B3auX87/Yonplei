package de.b3aux.yonplei.commands;

import de.b3aux.yonplei.main.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class trashCMD implements CommandExecutor {

    @Override
    public boolean onCommand (CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player) sender;

        if (p.hasPermission("yonplei.trash")) {

            if (args.length == 0) {

                ItemStack[] ac = p.getInventory().getArmorContents().clone();

                p.getInventory().clear();
                p.getInventory().setArmorContents(ac);
                p.updateInventory();

                p.sendMessage(Main.prefix + "§7Inventar geleert");

            } else { p.sendMessage(Main.use + "/trash"); }

        } else { p.sendMessage(Main.noPerms); }


        return false;
    }
}
