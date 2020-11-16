package de.b3aux.yonplei.listener;

import de.b3aux.yonplei.main.Main;
import de.b3aux.yonplei.methoden.playerData;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class AsyncPlayerChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {

        Player p = e.getPlayer();

        playerData data = new playerData(p.getUniqueId());

        if (data.isMuted()) {

            e.setCancelled(true);

            p.sendMessage(Main.prefix + "§cDu wurdest gemutet und kannst hier nicht schreiben!");

            for (Player all : Bukkit.getOnlinePlayers()) {

                if (all.hasPermission("system.mute.see")) {

                    all.sendMessage("§7[§3MUTE§7] §a" + p.getName() + " §7: " + e.getMessage());

                }
            }
        }
    }
}
