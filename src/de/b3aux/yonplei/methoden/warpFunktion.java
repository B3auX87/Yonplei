package de.b3aux.yonplei.methoden;

import de.b3aux.yonplei.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class warpFunktion {

    public static String sort = "plugins/Yonplei/Warps";

    public static void checkOrdner() {

        File file = new File(sort);
        if (file.isDirectory() == false)file.mkdirs();

    }

    public static void SetWarp(Player p, String wName) throws IOException {

        File file = new File("plugins/Yonplei/Warps", wName.toLowerCase() + ".yml");
        warpFunktion.checkOrdner();

        if (!file.exists()) {

            file.createNewFile();

            FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

            cfg.set("Location.X", p.getLocation().getX());
            cfg.set("Location.Y", p.getLocation().getY());
            cfg.set("Location.Z", p.getLocation().getZ());
            cfg.set("Location.Pitch", p.getLocation().getPitch());
            cfg.set("Location.Yaw", p.getLocation().getYaw());
            cfg.set("Location.World", p.getWorld().getName());

            cfg.save(file);

            p.sendMessage(Main.prefix + "§7 Du hast den Warp §3" + wName + " §7erfolgreich gesetzt.");
            return;

        } else {

            p.sendMessage(Main.prefix + "§cDieser warp existiert bereits.");
            return;

        }

    }

    public static void DelWarp(Player p, String wName) {

        File file = new File("plugins/Yonplei/Warps", wName.toLowerCase() + ".yml");

        if (file.exists()) {

            file.delete();
            p.sendMessage(Main.prefix + "§7 Du hast den Warp §3" + wName + " §7erfolgreich gelöscht.");
            return;

        } else {

            p.sendMessage(Main.prefix + "§cDieser warp existiert nicht.");

        }

    }

    public static void Warp(Player p, String wName) {

        File file = new File("plugins/Yonplei/Warps", wName.toLowerCase() + ".yml");

        if (!file.exists()) {

            p.sendMessage(Main.prefix + "§cDieser warp existiert nicht.");

            return;

        } else {

            FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

            double x = cfg.getDouble("Location.X");
            double y = cfg.getDouble("Location.Y");
            double z = cfg.getDouble("Location.Z");
            float pitch = (float) cfg.getDouble("Location.Pitch");
            float yaw = (float) cfg.getDouble("Location.Yaw");
            String WeltName = cfg.getString("Location.World");

            Location loc = p.getLocation();

            loc.setX(x);
            loc.setY(y);
            loc.setZ(z);
            loc.setPitch(pitch);
            loc.setYaw(yaw);
            loc.setWorld(Bukkit.getWorld(WeltName));

            p.teleport(loc);

            p.sendMessage(Main.prefix + "§7Du hast dich zu dem Warp §3" + wName + " §7teleportiert.");

        }
    }
}
