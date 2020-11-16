package de.b3aux.yonplei.commands;

import de.b3aux.yonplei.main.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;

public class nightvisionCMD implements CommandExecutor {

    public static ArrayList<Player> nv = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player) sender;

        if (p.hasPermission("yonplei.nightvision")) {

            if (args.length == 0) {

                p.sendMessage(Main.use + "/nv on/off");

            }

            if (args.length == 1) {

                if (args[0].equalsIgnoreCase("on")) {

                    if (nv.contains(p)) {
                        p.sendMessage(Main.prefix + "§7Du nutzt bereits §eNachtsicht.");
                        return true;
                    }

                    nv.add(p);
                    p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 30000, 250));
                    p.sendMessage(Main.prefix + "§7Du nutzt jetzt §5Nachtsicht.");

                } else if (args[0].equalsIgnoreCase("off")) {

                    if (!nv.contains(p)) {
                        p.sendMessage(Main.prefix + "§7Du nutzt keine §eNachtsicht.");
                        return true;
                    }

                    nv.remove(p);
                    p.removePotionEffect(PotionEffectType.NIGHT_VISION);
                    p.sendMessage(Main.prefix + "§7Du nutzt jetzt keine §eNachtsicht §7mehr.");

                } else { p.sendMessage(Main.use + "/nv on/off"); }

            }

        } else { p.sendMessage(Main.noPerms); }

        return false;
    }
}
