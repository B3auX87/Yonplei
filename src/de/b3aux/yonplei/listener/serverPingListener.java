package de.b3aux.yonplei.listener;

import de.b3aux.yonplei.main.Main;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import java.io.File;
import java.io.IOException;

public class serverPingListener implements Listener {

    @EventHandler
    public void onPing(ServerListPingEvent event) {

        if (Main.instance.wartung) {

            event.setMotd("§4§lDieser Server befindet sich momentan in Wartungsarbeiten.");

        } else {

            File ordner = new File("plugins//Yonplei");
            File file = new File("plugins//Yonplei//Motd.yml");

            YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

            if (!(ordner.exists()))  {

                ordner.mkdirs();

            }

            if (!(file.exists()))   {

                try {
                    file.createNewFile();

                    cfg.set("Motd", "§5§k == §5Minecraft §eServer §5§k ==");
                    cfg.save(file);

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            event.setMotd(ChatColor.translateAlternateColorCodes('&', cfg.getString("Motd")));

        }
    }
}

