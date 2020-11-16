package de.b3aux.yonplei.commands;

import de.b3aux.yonplei.main.Main;
import de.b3aux.yonplei.methoden.warpFunktion;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;

public class warpCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player) sender;

        if (sender instanceof ConsoleCommandSender) {

            System.out.println("Du musst ein Spieler sein.");
            return true;

        }

        if (p.hasPermission("yonplei.setwarp")) {

            if (cmd.getName().equalsIgnoreCase("swarp")) {

                if (args.length == 0) {

                    p.sendMessage(Main.use + "swarp <Name>");
                    return true;

                }

                if (args.length == 1) {

                    try {

                        warpFunktion.SetWarp(p, args[0]);
                        p.playSound(p.getLocation(), Sound.UI_BUTTON_CLICK, 10F, 10F);

                    } catch (IOException e) {

                        e.printStackTrace();

                    }

                    return true;

                }
            }

        } else {

            p.sendMessage(Main.noPerms);

        }

        if (p.hasPermission("yonplei.delwarp")) {

            if (cmd.getName().equalsIgnoreCase("dwarp")) {

                if (args.length == 0) {

                    p.sendMessage(Main.use + "dwarp <name>");
                    return true;

                }

                if (args.length == 1) {

                    warpFunktion.DelWarp(p, args[0]);
                    return true;

                }
            }

        } else {

            p.sendMessage(Main.noPerms);

        }

        if (cmd.getName().equalsIgnoreCase("tele")) {

            if (args.length == 0) {

                p.sendMessage(Main.use + " tele <name>");
                return true;

            }

            if (args.length == 1) {

                warpFunktion.Warp(p, args[0]);
                return true;

            }
        }

        return false;
    }
}
