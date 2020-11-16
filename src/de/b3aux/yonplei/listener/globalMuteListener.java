package de.b3aux.yonplei.listener;

import de.b3aux.yonplei.commands.globalMuteCMD;
import de.b3aux.yonplei.main.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class globalMuteListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {

        if(globalMuteCMD.globalmute) {

            if(e.getPlayer().hasPermission("yonplei.gmute.bypass")) {

                return;
            }

            e.getPlayer().sendMessage(Main.prefix + "§c Zuerzeit ist der Chat §4deaktiviert!");
            e.setCancelled(true);

        }
    }
}
