package de.b3aux.yonplei.listener;

import de.b3aux.yonplei.main.Main;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import static de.b3aux.yonplei.commands.vanishCMD.vanished;

public class joinListener implements Listener {

    @EventHandler
    public void onJoin (PlayerJoinEvent event) {

        Player player = event.getPlayer();

        player.performCommand("spawn");

        if (!event.getPlayer().isOp()) {

            event.getPlayer().setGameMode(GameMode.SURVIVAL);
            event.getPlayer().setAllowFlight(false);
            event.getPlayer().setFlying(false);

        }

        if (Main.getInstance().wartung == true) {

            if (player.isOp() || player.hasPermission("yonplei.wartung.in")) {

                player.kickPlayer("Wir sind grade in der Wartung, Bitte komme spaeter wieder.");

            }
        }

        if (!player.hasPlayedBefore()) {

            if (!event.getPlayer().isOp()) {

                event.getPlayer().setGameMode(GameMode.SURVIVAL);
                event.getPlayer().setAllowFlight(false);
                event.getPlayer().setFlying(false);

            }

            player.performCommand("spawn");

        } else {

            event.setJoinMessage("§7[§e+§7] " + player.getName());

        }

        for (Player vanish : vanished) {

            if (!event.getPlayer().hasPermission("yonplei.vanish.see")) {

                event.getPlayer().hidePlayer(vanish);

            }
        }
    }
}
