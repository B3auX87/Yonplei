package de.b3aux.yonplei.commands;

import de.b3aux.yonplei.main.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class motdCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player) sender;

        if (p.hasPermission("yonplei.motd")) {

            if (args.length >= 1) {

                if (args[0].length() >= 4) {

                    String motd = "";

                    for (int i = 0; i < args.length; i ++) {

                        motd = motd + args[i] + " ";

                    }

                    File ordner = new File("plugins//Yonplei");
                    File file = new File("plugins//Yonplei//Motd.yml");

                    if (!(ordner.exists()))  {

                        ordner.mkdirs();

                    }

                    if (!(file.exists())) {

                        try {

                            file.createNewFile();

                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }

                    }

                    YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

                    cfg.set("Motd", motd);

                    try {

                        cfg.save(file);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    p.sendMessage(Main.prefix + "§7 Der neue Motd ist nun: §r" + ChatColor.translateAlternateColorCodes('&', motd));

                }
            }

        } else {

            p.sendMessage(Main.noPerms);

        }

        return true;
    }
}
