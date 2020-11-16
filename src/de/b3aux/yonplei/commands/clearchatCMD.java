package de.b3aux.yonplei.commands;

import de.b3aux.yonplei.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class clearchatCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player) sender;

        if (sender instanceof ConsoleCommandSender) {

            return true;

        }

        if (sender instanceof Player) {

            if (p.hasPermission("yonplei.chatclear")) {

                if (args.length == 0) {

                    for (Player all : Bukkit.getOnlinePlayers()) {

                        if (!all.hasPermission("yonplei.chatclear.see")) {

                            ChatClear(all);

                        }

                    }

                    Bukkit.broadcastMessage(Main.prefix + "§7Der Chat wurde von §3" + p.getName() + " §7geleert.");

                }

                if (args.length == 1) {

                    Player t = Bukkit.getPlayer(args[0]);

                    if (t == null) {

                        p.sendMessage(Main.prefix + "§7Der Spieler §3" + t.getName() + " §7ist nicht Online.");

                        return true;

                    }

                    ChatClear(t);

                    p.sendMessage(Main.prefix + "§7Du hast den Chat von §3" + t.getName() + " §7geleert.");
                    t.sendMessage(Main.prefix + "§7Dein Chat wurde von §3" + p.getName() + " §7geleert.");

                }

            } else {

                p.sendMessage(Main.noPerms);

            }
        }

        return true;
    }

    public void ChatClear(Player p) {

        for (int i = 0; i < 200; i ++) {

            p.sendMessage(" ");

        }
    }
}
