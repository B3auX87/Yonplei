package de.b3aux.yonplei.commands;

import de.b3aux.yonplei.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class warnyouCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player) sender;

        if (p.hasPermission("yonplei.warnyou")) {

            if (args.length == 0) {

                p.sendMessage(Main.use + "/warnyou name anzahl (1)");

            }

            if (args.length == 1) {

                Player t = p.getServer().getPlayer(args[0]);

                if (getWarns(t) == 3) {

                    String s = "4 Verwarnungen";

                    for (int i = 1; i < args.length; i ++) s = s + args[i] + "4 Verwarnungen";

                    s = s.trim();

                    p.sendMessage(Main.prefix + "§7Du hast §3" + t.getName() + " §7erfolgreich Reportet.");
                    p.playSound(p.getLocation(), Sound.ENTITY_TURTLE_EGG_CRACK, 10F, 10F);

                    for (Player all : Bukkit.getOnlinePlayers()) {

                        if (all.hasPermission("yonplei.report.see")) {

                            all.sendMessage("§8[]-------- §4§lReport §8--------[]");
                            all.sendMessage("");
                            all.sendMessage("§8>> §7Von: §a" + p.getName());
                            all.sendMessage("§8>> §7Wer: §a" + t.getName());
                            all.sendMessage("§8>> §7Grund: §a" + s);
                            all.sendMessage("");
                            all.sendMessage("§8[]-------- §4§lReport §8--------[]");

                        }
                    }
                }

                int i = Main.instance.getConfig().getInt("Spieler." + t.getName() + ".Warns");

                i ++;

                Main.instance.getConfig().set("Spieler." + t.getName() + ".Warns", i);

                Main.instance.saveConfig();

                p.sendMessage(Main.prefix + "§7 Du hast §c§l" + t.getName() + "§7 Verwarnt und Reportet.");
                p.sendMessage(Main.prefix + "§c§l" + t.getName() + "§7 hat jetzt: §c" + getWarns(t) + "§7 Verwarnung(en).");
                t.sendMessage(Main.prefix + "§7 Du wurdest von: §a§l" + p.getName() + "§7 Verwarnt und Reportet.");
                t.sendMessage(Main.prefix + "§7Du hast jetzt: §c" + getWarns(t) + "§7 Verwarnung(en).");
                t.playSound(t.getLocation(), Sound.BLOCK_ANVIL_DESTROY, 10F, 10F);

            }

        } else {

            p.sendMessage(Main.noPerms);

        }

        return false;
    }

    public Integer getWarns(Player p) {

        int i = Main.instance.getConfig().getInt("Spieler." + p.getName() + ".Warns");

        return i;

    }
}
