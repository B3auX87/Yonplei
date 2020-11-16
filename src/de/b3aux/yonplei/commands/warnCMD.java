package de.b3aux.yonplei.commands;

import de.b3aux.yonplei.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class warnCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player) sender;

        if (args.length == 0) {

            if (getWarns(p) == 0) {

                p.sendMessage(Main.prefix + "§7 Du hast §e§lkeine §7Verwarnungen.");

            } else if (getWarns(p) == 1) {

                p.sendMessage(Main.prefix + "§7 Du hast §c§l1 §7Verwarnung.");
                p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_DESTROY, 10F, 10F);

            } else if (getWarns(p) == 2) {

                p.sendMessage(Main.prefix + "§7 Du hast §c§l2 §7Verwarnungen.");
                p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_DESTROY, 20F, 20F);

            } else if (getWarns(p) == 3) {

                p.sendMessage(Main.prefix + "§7 Du hast §c§l3 §7Verwarnungen.");
                p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_DESTROY, 30F, 30F);

            }

        } else if (args.length == 1) {

            if (p.hasPermission("yonplei.warn.other")) {

                Player t = p.getServer().getPlayer(args[0]);

                p.sendMessage(Main.prefix + "§e " + t.getName() + "§7 hat: §c" + getWarns(t) + "§7 Verwarnung(en).");
                p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10F, 10F);

            } else {

                p.sendMessage(Main.noPerms);

            }
        }

        return false;
    }

    public Integer getWarns(Player p) {

        int i = Main.instance.getConfig().getInt("Spieler." + p.getName() + ".Warns");

        return i;

    }

    public String getUUID(String playername) {

        return Bukkit.getOfflinePlayer(playername).getUniqueId().toString();

    }
}
