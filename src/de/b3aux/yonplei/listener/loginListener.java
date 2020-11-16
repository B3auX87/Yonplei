package de.b3aux.yonplei.listener;

import de.b3aux.yonplei.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;

public class loginListener implements Listener {

    @EventHandler
    public void onLogin(AsyncPlayerPreLoginEvent e) {

        if(Main.getInstance().wartung == true) {

            for(OfflinePlayer op : Bukkit.getWhitelistedPlayers()) {

                if(op.getName().equalsIgnoreCase(e.getName())) {

                    return;
                }
            }

            if(!Bukkit.getOfflinePlayer(e.getName()).isOp() || !Bukkit.getOfflinePlayer(e.getName()).isWhitelisted()) {

                e.disallow(AsyncPlayerPreLoginEvent.Result.KICK_OTHER, "§4Wir haben Momentan Wartungsarbeiten!");
            }
        }
    }
}
