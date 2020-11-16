package de.b3aux.yonplei.commands;

import de.b3aux.yonplei.main.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import static org.bukkit.Material.LEGACY_SKULL_ITEM;

public class kopfCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player) sender;

        if (p.hasPermission("yonplei.kopf")) {

            if (args.length == 1) {

                ItemStack itemStack = new ItemStack(LEGACY_SKULL_ITEM, 1, (short) 3);
                SkullMeta skullMeta = (SkullMeta) itemStack.getItemMeta();

                skullMeta.setOwner(args[0]);
                skullMeta.setDisplayName(args[0]);

                itemStack.setItemMeta(skullMeta);

                p.getInventory().addItem(itemStack);
                p.updateInventory();

                p.sendMessage(Main.prefix + "§6Erfolgreich§7, schau in dein Inventar!");

            } else {

                p.sendMessage(Main.use + "/kopf name");

            }

        } else {

            p.sendMessage(Main.noPerms);

        }

        return true;
    }
}
