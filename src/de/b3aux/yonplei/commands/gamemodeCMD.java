package de.b3aux.yonplei.commands;

import de.b3aux.yonplei.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class gamemodeCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("gm")) {

            if (args.length == 0) {

                p.sendMessage(Main.use + "/gm 0, 1, 2, 3 §7[Spieler]");

                return true;

            }

            GameMode gm = null;

            if (args.length == 1) {

                if (args[0].equalsIgnoreCase("0")) {

                    if (p.hasPermission("yonplei.gamemode") || p.hasPermission("yonplei.gamemode.survival")) {

                        gm = GameMode.SURVIVAL;

                        p.setGameMode(gm);
                        p.sendMessage(Main.prefix + "§7Du bist nun im §e" + gm.name() + " §7GameMode.");

                        return true;

                    } else {

                        p.sendMessage(Main.noPerms);

                    }

                } else if (args[0].equalsIgnoreCase("1")) {

                    if (p.hasPermission("yonplei.gamemode") || p.hasPermission("yonplei.gamemode.creative")) {

                        gm = GameMode.CREATIVE;

                        p.setGameMode(gm);
                        p.sendMessage(Main.prefix + "§7Du bist nun im §e" + gm.name() + " §7GameMode.");

                        return true;

                    } else {

                        p.sendMessage(Main.noPerms);

                    }

                } else if (args[0].equalsIgnoreCase("2")) {

                    if (p.hasPermission("yonplei.gamemode") || p.hasPermission("yonplei.gamemode.adventure")) {

                        gm = GameMode.ADVENTURE;

                        p.setGameMode(gm);
                        p.sendMessage(Main.prefix + "§7Du bist nun im §e" + gm.name() + " §7GameMode.");

                        return true;

                    } else {

                        p.sendMessage(Main.noPerms);

                    }

                } else if (args[0].equalsIgnoreCase("3")) {

                    if (p.hasPermission("yonplei.gamemode") || p.hasPermission("yonplei.gamemode.spectator")) {

                        gm = GameMode.SPECTATOR;

                        p.setGameMode(gm);
                        p.sendMessage(Main.prefix + "§7Du bist nun im §e" + gm.name() + " §7GameMode.");

                        return true;

                    } else {

                        p.sendMessage(Main.noPerms);

                    }
                }
            }

            if (args.length == 2) {

                Player t = Bukkit.getPlayer(args[1]);

                if (t == null) {

                    p.sendMessage(Main.playerNotOnline);

                    return true;

                }

                if (args[0].equalsIgnoreCase("0")) {

                    if (p.hasPermission("yonplei.gamemode.other")) {

                        gm = GameMode.SURVIVAL;

                        t.setGameMode(gm);
                        t.sendMessage(Main.prefix + "§7Du bist nun im §e" + gm.name() + " §7GameMode.");
                        p.sendMessage(Main.prefix + "§7Du hast §3" + t.getName() + " §7in den §3" + gm.name() + " §7GameMode gesetzt.");

                        return true;

                    } else {

                        p.sendMessage(Main.noPerms);

                    }

                } else if (args[0].equalsIgnoreCase("1")) {

                    if (p.hasPermission("yonplei.gamemode.other")) {

                        gm = GameMode.CREATIVE;

                        t.setGameMode(gm);
                        t.sendMessage(Main.prefix + "§7Du bist nun im §e" + gm.name() + " §7GameMode.");
                        p.sendMessage(Main.prefix + "§7Du hast §3" + t.getName() + " §7in den §3" + gm.name() + " §7GameMode gesetzt.");

                        return true;

                    } else {

                        p.sendMessage(Main.noPerms);

                    }

                } else if (args[0].equalsIgnoreCase("2")) {

                    if (p.hasPermission("yonplei.gamemode.other")) {

                        gm = GameMode.ADVENTURE;

                        t.setGameMode(gm);
                        t.sendMessage(Main.prefix + "§7Du bist nun im §e" + gm.name() + " §7GameMode.");
                        p.sendMessage(Main.prefix + "§7Du hast §3" + t.getName() + " §7in den §3" + gm.name() + " §7GameMode gesetzt.");

                        return true;

                    } else {

                        p.sendMessage(Main.noPerms);

                    }

                } else if (args[0].equalsIgnoreCase("3")) {

                    if (p.hasPermission("yonplei.gamemode.other")) {

                        gm = GameMode.SPECTATOR;

                        t.setGameMode(gm);
                        t.sendMessage(Main.prefix + "§7Du bist nun im §e" + gm.name() + " §7GameMode.");
                        p.sendMessage(Main.prefix + "§7Du hast §3" + t.getName() + " §7in den §3" + gm.name() + " §7GameMode gesetzt.");

                        return true;

                    } else {

                        p.sendMessage(Main.noPerms);

                    }
                }

                return true;

            }
        }

        return false;
    }
}
