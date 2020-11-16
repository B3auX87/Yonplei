package de.b3aux.yonplei.commands;

import de.b3aux.yonplei.main.Main;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class renameCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player) sender;

        if(p.hasPermission("yonplei.rename")) {

            if (args.length == 1) {

                String format = args[0];

                if (p.getItemInHand().getType() != Material.AIR) {

                    ItemStack item = this.renameItem(p.getItemInHand(), format);

                    p.getInventory().remove(p.getItemInHand());
                    p.getInventory().addItem(item);

                    p.sendMessage(Main.prefix + "§eErfolgreich");

                } else {

                    p.sendMessage(Main.prefix + "§7Bitte nimm ein Item in die Hand.");

                }

            } else {

                p.sendMessage(Main.prefix + "§7Bitte Tippe: §6/rename text");

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

    public ItemStack renameItem(ItemStack item, String format) {

        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(this.formatAll(format));
        item.setItemMeta(meta);

        return item;

    }
}
