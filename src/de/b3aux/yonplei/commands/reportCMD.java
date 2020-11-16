package de.b3aux.yonplei.commands;

import de.b3aux.yonplei.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class reportCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player) sender;

        if (args.length == 0 || args.length == 1) {

            p.sendMessage("§7Bitte Tippe: §6/report name Grund");

            return true;

        }

        if (args.length >= 2) {

            Player t = Bukkit.getPlayer(args[0]);

            if (t == null) {

                p.sendMessage(Main.playerNotOnline);

                return true;

            }

            if (args[0].equals(p.getName())) {

                p.sendMessage(Main.prefix + "§a:D §eDu kannst dich nicht selbst Reporten.");

                return true;

            }

            String s = "";

            for (int i = 1; i < args.length; i ++) s = s + args[i] + " ";

            s = s.trim();

            String i = Main.instance.getConfig().getString("Spieler." + t.getName() + ".Report.Grund" + s);

            p.sendMessage(Main.prefix + "§8Du hast §3" + t.getName() + " §8erfolgreich Reportet.");
            p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10F, 10F);

            Main.instance.getConfig().set("Spieler." + t.getName() + ".Report.Grund", i);

            for (Player all : Bukkit.getOnlinePlayers()) {

                if (all.hasPermission("yonplei.report.see")) {

                    all.sendMessage("§8[]-------- §4§lReport §8--------[]");
                    all.sendMessage("");
                    all.sendMessage("§8>> §7Von: §a" + p.getName());
                    all.sendMessage("§8>> §7Wer: §a" + t.getName());
                    all.sendMessage("§8>> §7Grund: §a" + s);
                    all.sendMessage("");
                    all.sendMessage("§8[]-------- §4§lReport §8--------[]");

                    all.playSound(all.getLocation(), Sound.ENTITY_WITCH_THROW, 80F, 80F);

                }
            }
        }

        return false;
    }
}
