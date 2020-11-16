package de.b3aux.yonplei.commands;

import de.b3aux.yonplei.main.Main;
import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class backCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player) sender;

        if (p.hasPermission("yonplei.back")) {

            if (args.length == 0) {

                if (Main.back.containsKey(p.getName())) {

                    p.teleport(Main.back.get(p.getName()));
                    p.spawnParticle(Particle.FLAME, p.getLocation(), 1);
                    p.sendMessage(Main.prefix + "§7 Du wurdest §eerfolgreich §7teleportiert.");
                    Main.back.remove(p.getName());

                } else {

                    p.sendMessage(Main.prefix + "§c Es gibt ein Ort an den du zurück kannst.");

                }

            } else {

                p.sendMessage(Main.use + "/back");

            }

        } else {

            p.sendMessage(Main.noPerms);

        }

        return true;
    }
}
