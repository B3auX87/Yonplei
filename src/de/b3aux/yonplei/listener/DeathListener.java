package de.b3aux.yonplei.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathListener implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {

        Player p = e.getEntity();
        Player k = p.getKiller();

        if (k != null) {

            e.setDeathMessage("§7>>§c ☠ §7<< " + p.getName() + k.getName());

        } else {
            e.setDeathMessage("§7>>§c ☠ §7<< " + p.getName());
        }

    }
}
