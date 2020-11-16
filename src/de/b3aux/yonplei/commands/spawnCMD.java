package de.b3aux.yonplei.commands;

import de.b3aux.yonplei.main.Main;
import de.b3aux.yonplei.methoden.FileConfig;
import de.b3aux.yonplei.methoden.Locations;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class spawnCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player))
            return true;

        Player player = (Player) sender;

        FileConfig spawns = new FileConfig("spawn.yml");

        if (label.equalsIgnoreCase("sspawn")) {

            if (player.hasPermission("yonplei.setspawn")) {

                spawns.set("spawn", Locations.loc2Str(player.getLocation()));
                spawns.saveConfig();
                player.sendMessage(Main.prefix + " §aSpawn §7gesetzt.");

            } else {

                player.sendMessage(Main.noPerms);
            }
            return true;
        }

        if (spawns.contains("spawn")) {

            Locations.teleport(player, Locations.str2Loc(spawns.getString("spawn")));

        } else {

            player.sendMessage(Main.prefix + " §7Es wurde noch kein §cSpawnpunkt §7gesetzt.");

        }


        return true;
    }
}
