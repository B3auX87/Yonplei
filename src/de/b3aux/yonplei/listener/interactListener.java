package de.b3aux.yonplei.listener;

import de.b3aux.yonplei.main.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class interactListener implements Listener {

    @EventHandler
    public void onCMD(PlayerCommandPreprocessEvent e) {

        Player p = e.getPlayer();

        String[] cmd = e.getMessage().substring(1).split(" ");

        /*
        /bukkit
        /pl
        /?
        /op
        /help
        /version
        /me
        /deop
        /plugins
        /plugin
        /var
        /ver
         */

        if (cmd[0].startsWith("bukkit") || cmd[0].startsWith("me") || cmd[0].startsWith("op") || cmd[0].startsWith("deop")) {

            if (!p.isOp() || !p.hasPermission("yonplei.op")) {

                p.sendMessage(Main.prefix + "§4§l Alter mach nicht so! XD");
                e.setCancelled(true);

            }
        }

        if (cmd[0].startsWith("?") || cmd[0].startsWith("version") || cmd[0].startsWith("plugins") || cmd[0].startsWith("ver") || cmd[0].startsWith("var")) {

            if (!p.isOp() || !p.hasPermission("yonplei.cmd")) {

                p.kickPlayer(Main.prefix + "§4§l Alter mach nicht so! XD");
                e.setCancelled(true);

            }
        }

        if (cmd[0].startsWith("help")) {

            p.sendMessage(Main.use + "/info");
            e.setCancelled(true);

        }
    }
}
