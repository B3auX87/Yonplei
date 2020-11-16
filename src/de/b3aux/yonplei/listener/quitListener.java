package de.b3aux.yonplei.listener;

import de.b3aux.yonplei.commands.vanishCMD;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class quitListener implements Listener {

    @EventHandler
    public void onQuit (PlayerQuitEvent event) {

        Player p = event.getPlayer();

        event.setQuitMessage("§7[§c-§7] " + p.getName());

        if (vanishCMD.vanished.contains(p)) { vanishCMD.vanished.remove(p); }

    }
}
