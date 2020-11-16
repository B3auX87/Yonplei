package de.b3aux.yonplei.methoden;

import de.b3aux.yonplei.main.Main;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.Random;

public class rdmTPmanager {

    public static void randomTp(Player p) {

        Random rdm = new Random();

        int rdmx = rdm.nextInt(20000) - 10000;
        int rdmz = rdm.nextInt(20000) - 10000;

        World wld = p.getWorld();

        int hblock = wld.getHighestBlockYAt(rdmx, rdmz);

        Location toTp = new Location(wld, rdmx, hblock, rdmz);

        p.teleport(toTp);

        p.sendMessage(Main.prefix + "§8[]-------- §ctͬeͣᶰlͩeͦpͫort §8--------[]");
        p.sendMessage(Main.prefix + "");
        p.sendMessage(Main.prefix + "§7Du wurdest zu diesen Koordinaten teleportiert.");
        p.sendMessage(Main.prefix + "");
        p.sendMessage(Main.prefix + "§6Z §8>> §6" + rdmz);
        p.sendMessage(Main.prefix + "§6X §8>> §6" + rdmx);
        p.sendMessage(Main.prefix + "");
        p.sendMessage(Main.prefix + "§8[]-------- §ctͬeͣᶰlͩeͦpͫort §8--------[]");

    }
}
