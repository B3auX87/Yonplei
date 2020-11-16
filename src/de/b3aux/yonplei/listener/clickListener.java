package de.b3aux.yonplei.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class clickListener implements Listener {

    @EventHandler
    public void oClick (InventoryClickEvent event) {

        Player p = (Player) event.getWhoClicked();

        if (event.getView().getTitle().equalsIgnoreCase("§7>> §9§lSpieler§7-§9§lInv") || event.getView().getTitle().equalsIgnoreCase("§7>> §9§lSpieler§7-§9§lEC")) {

            if (event.getCurrentItem() != null && event.getCurrentItem().getType() != null) {

                event.setCancelled(true);

            }
        }
    }
}
