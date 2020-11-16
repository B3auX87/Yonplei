package de.b3aux.yonplei.commands;

import de.b3aux.yonplei.main.Main;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class loreCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player) sender;

        if (p.hasPermission("yonplei.setlore")) {

            if (args.length >= 1) {

                String message = "";
                ArrayList<String> lore = new ArrayList<>();

                if (p.getItemInHand().getType() != Material.AIR) {

                    for (int i = 0; i < args.length; i++) {

                        message = message + args[i] + " ";

                    }

                    lore.add(this.formatAll(message));
                    ItemStack item = this.setLore(p.getItemInHand(), lore);

                    p.getInventory().removeItem(item);
                    p.getInventory().addItem(item);
                    p.sendMessage(Main.prefix + "§eErfolgreich");

                } else {

                    p.sendMessage(Main.prefix + "§7Nimm ein Item in die Hand");

                }

            } else {

                p.sendMessage(Main.prefix + "§7/setlore text.");

            }

        } else {

            p.sendMessage(Main.noPerms);

        }

        return true;
    }

    public String formatAll(String format) {

        format = format.replaceAll("&", "§");

        return format;

    }

    public ItemStack setLore(ItemStack item, ArrayList<String> message) {

        ItemMeta meta = item.getItemMeta();
        meta.setLore(message);
        item.setItemMeta(meta);

        return item;
    }
}
